package kevin;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;



class Grid {
	
	static final int SIZE = 4;
	
	Square[][] mainGrid = new Square[SIZE][SIZE];  // Declare a 2D array of Squares

	
	Grid() {
		for(int i = 0; i < SIZE; ++i) {
			 for(int j = 0; j < SIZE; ++j) {
				 	mainGrid[i][j] = new Square();  // Call the Square constructor to initialize the new memory
	                }
			 }	
	}

	
	void printGrid() {
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				System.out.print(mainGrid[i][j].getValue()); 
				System.out.print(" "); 
			}
			System.out.println("\n");
		}

		System.out.println();

	}
	
	
	
	// Used to check if the grid has any empty spaces in it
	private boolean hasEmptySquare() {
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				if(mainGrid[i][j].getValue() == 0)
					return true; // Since a value of 0 is considered empty, return true
			}
		}
		
		// Algorithm has complexity O(n) 
		// where n is the number of elements in the grid 

		return false;
	}

	
	// Helps to check for one of the "Game Over" conditions
	// That is, if a square has a neighbor with the same value as it, a legal move can
	// be made.  If this method returns true, then the game can continue.  If it does not,
	// the game may end, but there may still be a valid move.
	private boolean hasEqualNeighbour() {
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				if(j < SIZE - 1) {
					// check squares along the right side, ignore the last column
					//System.out.println("line 64, j < 3");

                    if(mainGrid[i][j].isEqual(mainGrid[i][j+1])) {
                        //System.out.println("true, line 65");
					    return true;
                    }

                   // System.out.println("line 71, did not return true");
                }

               // System.out.println("line 74, still inner for loop, about to check if #2");
				if(i < SIZE - 1) {
                    //System.out.println("line 76, inside if statement");
                   // System.out.println("line 77, " + mainGrid[i+1][j] + " " + mainGrid[i][j]);
                    // check squares below the selected square, ignoring the last row
					if(mainGrid[i][j].isEqual(mainGrid[i+1][j])) {
                        //System.out.println("true, line 80");
					    return true;
                    }
				}
			}
		}
		
		return false;
	}
	
	private int getNewValue() {
		Random random = new Random();
		
		int RGJesus = random.nextInt(2) + 1;
		/* This generates a new number, either a 2 or a 4 for the square value
		 * TODO make this function generate a 2 or a 4 based on discrete probabilities
		 * the value of 2 should have a probability of .75
		 * the value of 4 should have a probability of .25
		 */
		return (RGJesus * 2);
	}
	
	
	// This method deals with generating a new square once a move is made.
    void generateSquare() {
		
		// return if there is no place to put a new square
		// a square will not be created in this situation
		if(!(hasEmptySquare())) { // if hasEmptySquare() returns false...
			return;
		}
		
		Random randomGen = new Random();

		// iterate until an empty tile is found
		// this has to be random, so we cannot just sequentially check for empty grid spaces

		while(true) {
			int x = randomGen.nextInt(SIZE);
			int y = randomGen.nextInt(SIZE);
			System.out.print("New grid location: (" + x + ", " + y + ")\n");
			
			if(mainGrid[x][y].getValue() == 0) {

				mainGrid[x][y].setValue(getNewValue());

				return;
			}
			
		}
		
		
	}
	
	
	// Returns true if there is no possible move to be made
	// If the grid has an empty square, there is a possible move
	// if no square has a neighbor that is equal to itself, and
	// the grid is full, there is no possible move.

	void gameOver() {
		if(hasEmptySquare() && !(hasEqualNeighbour())) {
			System.out.println(Boolean.toString(hasEmptySquare()));
			System.out.println(Boolean.toString(hasEqualNeighbour()));
		    new GameOverScreen();
		}
        System.out.println(Boolean.toString(hasEqualNeighbour()));
	}
	

	void move(Direction direction) {
		
		for(int i = 0; i < SIZE; ++i) {

			// group of tiles
			List<Square> squareSet = new ArrayList<>();

			for(int j = 0; j < SIZE; ++j) {

				// switching on an enum is faster than if/then/else
				// since there is only one comparison that has to be done
				switch(direction) {
				case LEFT: squareSet.add(mainGrid[i][j]); break;
				case RIGHT: squareSet.add(mainGrid[i][SIZE - j - 1]); break;
				case UP: squareSet.add(mainGrid[j][i]); break;
				case DOWN: squareSet.add(mainGrid[SIZE - j - 1][i]); break;
				default: break;

				}
			}
			if(!(isEmptySquare(squareSet))) {
				slide(squareSet);

			}

		}
		System.out.println();

		printGrid();

	}

	private void slide(List<Square> squareSet) {
	    slideToEdge(squareSet);
	    mergeSquare(squareSet);
    }
	
	private boolean isEmptySquare(List<Square> squareSet) {
		for(Square tile: squareSet) {
			if(tile.getValue() != 0)  // a square with a value of 0 is defined as "empty"
				return false;
		}
		return true;
	}


	private void slideToEdge(List<Square> squareSet) {
		for(int i = 0; i < squareSet.size(); ++i) {
			if(remainingIsZero(squareSet, i))
				return;
			while(squareSet.get(i).getValue() == 0) {
				slideTo(squareSet, i);
			}
		}
	}

	private boolean remainingIsZero(List<Square> squareSet, int i) {
		List<Square> remainingSquare = new ArrayList<>();
		for(int j = i; j < squareSet.size(); ++j) {
			remainingSquare.add(squareSet.get(j));
		}

		return(isEmptySquare(remainingSquare));

	}

	private void slideTo(List<Square> squareSet, int index) {
		for(int j = index; j < squareSet.size() - 1; ++j) {
			squareSet.get(j).setValue(squareSet.get(j + 1).getValue());
		}
		squareSet.get(squareSet.size() - 1).clear();

		}

	private void mergeSquare(List<Square> squareSet) {
		for(int i = 0; i < squareSet.size() - 1; ++i) {
			if(squareSet.get(i).isEqual(squareSet.get(i + 1))) {
				squareSet.get(i).merge(squareSet.get(i + 1));
				squareSet.get(i + 1).clear();
				slideTo(squareSet, i + 1);

			}
		}
	}
}

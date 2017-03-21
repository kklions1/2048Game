package kevin;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;



public class Grid {
	
	private final int SIZE = 4;
	
	private Square[][] mainGrid = new Square[SIZE][SIZE];  // Declare a 2D array of Squares

	
	public Grid() {
		for(int i = 0; i < SIZE; ++i) {
			 for(int j = 0; j < SIZE; ++j) {
				 	mainGrid[i][j] = new Square();  // Call the Square constructor to initialize the new memory
	                }
			 }	
	}
	 
	
	public void printGrid() {
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				System.out.print(mainGrid[i][j].getValue()); 
				System.out.print(" "); 
			}
			System.out.println("\n");
		}
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

	
	
	private boolean hasEqualNeighbour() {
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				if(j < SIZE - 1) {
					// check squares along the right side, ignore the last column
					if(mainGrid[i][j].equals(mainGrid[i][j+1])) 
						return true;
				}
				
				else if(i < SIZE - 1) {
					// check squares below the selected square, ignoring the last row
					if(mainGrid[i][j].equals(mainGrid[i+1][j])) 
						return true;
				}
			}
		}
		
		return false;
	}
	
	private int getNewValue() {
		Random random = new Random();
		
		int rnjesus = random.nextInt(2) + 1; 
		/* This generates a new number, either a 2 or a 4 for the square value
		 * TODO make this function generate a 2 or a 4 based on discrete probabilites
		 * the value of 2 should have a probability of .75
		 * the value of 4 should have a probability of .25
		 */
		return (rnjesus * 2);
	}
	
	
	// This method deals with generating a new square once a move is made.
	public boolean generateSquare() {
		
		// return false if there is no place to put a new square
		// a square will not be created in this situation
		if(!(hasEmptySquare())) {
			return false;
		}
		
		Random randomGen = new Random();

		// iterate until an empty tile is found
		while(true) {
			int x = randomGen.nextInt(SIZE);
			int y = randomGen.nextInt(SIZE);
			
			if(mainGrid[x][y].getValue() == 0)) {
				mainGrid[x][y].setValue(getNewValue());
				return true;
			}
			
		}
		
		
	}
	
	
	
	public void gameOver() {
		// TODO This method checks to see if the game ends.
		// This will be called after every move
		System.out.print("did you lose yet?\n"); // dummy statement does nothing
	}
	

	public void move(Direction direction) {
		
		for(int i = 0; i < SIZE; ++i) {
			
			// group of tiles
			List<Square> squareSet = new ArrayList<Square>();
			
			for(int j = 0; j < SIZE; ++j) {
				
				// switching on an enum is faster than if/then/else
				// since there is only one comparison that has to be done
				switch(direction) {
				case LEFT: squareSet.add(mainGrid[i][j]); break;
				case RIGHT: squareSet.add(mainGrid[i][SIZE - j - i]); break;
				case UP: squareSet.add(mainGrid[j][i]); break;
				case DOWN: squareSet.add(mainGrid[SIZE - j - i][i]); break;

				
				default: break;
				
				}
			}
		}
	}
	
	
	
	
}

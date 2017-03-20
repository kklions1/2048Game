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
	// This method deals with generating a new square once a move is made.
	public boolean generateSquare() {
		
		if(!(hasEmptySquare())) {
			return false;
		}
		
		Random randomGen = new Random();
		// TODO Finish implementing this method
	
	}
	
	public void gameOver() {
		// TODO This method checks to see if the game ends.
		// This will be called after every move
		System.out.print("did you lose yet?\n"); // dummy statement 
	}
	
	// These methods will likely be used to move the squares around the grid
	public void moveLeft() {
		System.out.println("Moving left\n");
		
		printGrid();
		gameOver();
	}
	
	public void moveRight() {
	    System.out.println("move right\n");
	    printGrid();
	    gameOver();
	    
	}

	public void moveTop() {
	    System.out.println("move up\n");
	    printGrid();
	    gameOver();
	    
	}

	public void moveDown() {
	    System.out.println("move down\n");
	    printGrid();
	    gameOver();
	    
	}
}

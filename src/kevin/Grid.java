package kevin;

public class Grid {
	
	public Square[][] mainGrid;  // Declare a 2D array of Squares

	private int[] generate = {1, 2};  // values to insert into squares. modifies currentValue index 
	
	private double[] discreteProb = {.75, .25}; // Probability associated with 'generate' array
	
	public Grid() {
		mainGrid = new Square[4][4]; // allocate a 4x4 array of Squares for the main Grid

		for(int i = 0; i < 4; ++i) {
			 for(int j = 0; j < 4; ++j) {
				 	mainGrid[i][j] = new Square();  // Call the Square constructor to initialize the new memory 
				 	mainGrid[i][j].xPos = i;  		// allocated by the previous steps
	                mainGrid[i][j].yPos = j;		// as well as initialize the coordinates
	                }
			 }	
	}
	 
	
	public void printGrid() {
		for(int i = 0; i < 4; ++i) {
			for(int j = 0; j < 4; ++j) {
				System.out.print(mainGrid[i][j].value[mainGrid[i][j].currentValue]); // Messy, but works
				System.out.print(" "); 
			}
			System.out.println("\n");
		}
	}
	
	
	// This method deals with generating a new square once a move is made.
	public void generateSquare() {
		// TODO Implement random number selection with the following specifications:
		// 1. The number will be randomly assigned to an open square (that is one with a value at 0)
		// 2. The number assigned will have a .75 chance of being a 2, and a .25 chance of being a 4
		// 		This means that there can be a square that starts off at the second "level" in the game
		// 3. Only one square will receive a number per move.
		
	
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

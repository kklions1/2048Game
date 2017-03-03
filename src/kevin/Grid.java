package kevin;

public class Grid {
	
	public Square[][] mainGrid;  // Declare a 2D array of Squares
	//mainGrid = new Square[4][4];

	
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
				System.out.print(mainGrid[i][j].value);
				System.out.print(" "); 
			}
			System.out.println("\n");
		}
	}
	
	// These methods will likely be used to move the squares around the grid
	public void moveLeft() {
		System.out.println("Moving left\n");
		printGrid();
		
	}
	
	public void moveRight() {
	    System.out.println("move right\n");
	    printGrid();
	}

	public void moveTop() {
	    System.out.println("move up\n");
	    printGrid();
	}

	public void moveDown() {
	    System.out.println("move down\n");
	    printGrid();
	}
}

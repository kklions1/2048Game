package kevin;

public class Square {
	public int[] value = {0, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};
	// This array holds all the values needed for the game to work, without having to calculate them on the fly
	
	public int currentValue;
	// Holds the current location in the above array that the square is at
	
	
	public int xPos;
	public int yPos;
	// Store the (x,y) location of in the grid.
	// This may be an unnecessary inclusion
	
	public Square() {
		// Default Constructor
		currentValue = 0;
		// Start the value array at index 0
	}
}

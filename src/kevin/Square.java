package kevin;

public class Square {
	public int value;
	/* The value will simply hold a number 0 - 11
	 * Each number will represent what number is rendered on 
	 * the final square in the finished product
	 * 0 will represent an empty square
	 * the number to be rendered on the square will simply be
	 * 2^value.
	 */
	
	public int xPos;
	public int yPos;
	// Store the (x,y) location of in the grid.
	// This may be an unnecessary inclusion
	
	public Square() {
		// Default Constructor
		value = 0;
	}
}

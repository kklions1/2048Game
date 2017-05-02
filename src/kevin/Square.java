package kevin;

/**
 * This is the Square class, it is the main unit in the game.
 * It holds a value, and can do a few simple operations on itself, and another square object
 */
public class Square {

	private int value;
	
	Square() {
		// Default Constructor
		value = 0;
	}
	
	// Accesses for private member value
	int getValue() { return this.value; }
	
	// Mutator for private member value
	void setValue(int value) { this.value = value; }
	
	
	// Used to determine if two squares are equal. 
	// Returns true if they are
	boolean isEqual(Square square) { return (this.getValue() == square.getValue()); }
	
	
	// Part of the move algorithm. 
	// Add the value of this square to the value of the parameter
	void merge(Square square) {
		this.setValue(value + square.getValue()); 
	}
	
	// Clear a square by setting its value to 0
	void clear() { this.setValue(0); }


	// convert a square's value into a string
	public String toString() { return (Integer.toString(this.getValue())); }
	
	
}

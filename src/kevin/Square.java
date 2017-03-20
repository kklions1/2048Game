package kevin;

public class Square {

	private int value;
	
	public Square() {
		// Default Constructor
		value = 0;
	}
	
	public Square(int param) {
		// Constructor for a specific value
		value = param;
	}
	
	
	// Accesses for private member value
	public int getValue() { return this.value; } 
	
	// Mutator for private member value
	public void setValue(int value) { this.value = value; } 
	
	
	// Used to determine if two squares are equal. 
	// Returns true if they are
	public boolean isEqual(Square square) {
		return (this.getValue() == square.getValue());
	}
	
	
	// Part of the move algorithm. 
	// Add the value of this square to the value of the parameter
	public void merge(Square square) {
		this.setValue(value + square.getValue()); 
	}
	
	// Clear a square by setting its value to 0
	public void clear() { this.setValue(0); }
	
	
	
}

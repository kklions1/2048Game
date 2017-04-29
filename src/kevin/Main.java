package kevin;


public class Main {

	public static void main(String[] args) {

		// Define the grid, as well as the main frame for the game
		Grid gameGrid = new Grid();
		GUIMain superFrame = new GUIMain();

		// Initialize a square, and send it over to the GUI
		gameGrid.generateSquare();
		superFrame.setMainGrid(gameGrid);


		while(true) {
			// continuously redraw the GUI
			// how exactly this part works is magic
			superFrame.displayGrid();
		}


	}
}	

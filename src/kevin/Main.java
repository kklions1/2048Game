package kevin;


public class Main {

	public static void main(String[] args) {

		Grid gameGrid = new Grid();

		GUIMain superFrame = new GUIMain();

		gameGrid.generateSquare();


		superFrame.setMainGrid(gameGrid);


		while(true) {
			superFrame.displayGrid();
		}


	}
}	

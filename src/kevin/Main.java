package kevin;


public class Main {

	public static void main(String[] args) {
		
		System.out.println("Initial Grid print\n");
		
		Grid gameGrid = new Grid();

		GUIMain superFrame = new GUIMain(gameGrid);

		superFrame.displayGrid(gameGrid);

        for(int j = 0; j < 10; ++j) {
			for (int i = 0; i < 5; ++i) {
				gameGrid.generateSquare();
			}
			//gameGrid.generateSquare();

			superFrame.displayGrid(gameGrid);


			gameGrid.move(Direction.LEFT);

			superFrame.displayGrid(gameGrid);

		}
		if(!gameGrid.gameOver()) {
			System.out.println("game on");

		}




	}
}	

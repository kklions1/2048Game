package kevin;


public class Main {

	public static void main(String[] args) {
		
		System.out.println("Initial Grid print\n");
		
		Grid gameGrid = new Grid();

		GUIMain superFrame = new GUIMain(gameGrid);

		superFrame.displayGrid(gameGrid);


		while(true) {
			superFrame.displayGrid(gameGrid);
		}






	}
}	

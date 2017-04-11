package kevin;


public class Main {

	public static void main(String[] args) {
		
		System.out.println("Initial Grid print\n");
		
		Grid gameGrid = new Grid();
		
		gameGrid.printGrid();

		if(!gameGrid.gameOver()) {
			System.out.println("game on");

		}




	}
}	

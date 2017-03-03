package kevin;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		System.out.println("Initial Grid print\n");
		
		Grid gameGrid = new Grid();
		
		gameGrid.printGrid();
		
		Scanner keyPress = new Scanner(System.in);

			
		
		while(true) { // start a simple shell
			/* TODO implement console input
			 * Then if the string is up, left, down, or right,
			 * call the correct method from the Grid class
			 * and if the string is "exit" then terminate the loop
			 * and quit the program
			 */ 
			
			
			if(keyPress.next() == "a")
				gameGrid.moveLeft();
			
			else { 
				System.out.println("invalid input, Terminating");
				break;
			}
			
			keyPress.close();

			
			
		}
	}

}

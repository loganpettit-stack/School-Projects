package WumpusWorldGame;
import java.util.*;

public class Project3 {
 
	public static void main (String [] args) {
		
		Scanner input = new Scanner(System.in);
		
		String ans,
			yes = "YES",
			no = "NO";
		
				System.out.println("Welcome to wumpus world! This is a 4x4 grid game that you will traverse \n"
						+ "by using N to move North, E to move east, S to move south, and W to \n"
						+ "move west. The goal of this game is to discover gold while avoiding \n"
						+ "pits and the wumpus. Keep a close eye out for the stench that iminates \n"
						+ "from the Wumpus and the breezes that the pits produce (Press c to display the board)");
		System.out.println("Enter your first move! (N,E,S,W)\n");
		
		/* do while loop re runs game*/
	do {
		
		 boolean flag = true;
		 
		WumpusWorld game = new WumpusWorld();
		
		game.checkStart();
		
		/*While loop will run game until wumpus worlds 
		 * private boolean variable death changes to false*/
		while ( flag == game.getDeath() ) {
		
		String move = input.nextLine();
		game.movePlayer(move);
		
		/*if statement cheat*/
		if (move.contains("c"))	
			game.printGame();
		
		}
		
		System.out.println("Would you like to try again? (Yes/No) ");
		ans = input.nextLine();
		
	}while(ans.toUpperCase().equals(yes));
	
	if(ans.toUpperCase().equals(no));
	{
		System.out.println("\nThank you for playing Wumpus World. ");
 	}
		

	}
	
}

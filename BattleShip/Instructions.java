//Imports
import java.util.Scanner;

public class Instructions {
	
	//Constructor
	Instructions()
	{
		exampleGrid = new GameGrid(10,10);
		exampleGrid.populateGrid();
		keyboard = new Scanner(System.in);
		response = "";
	}
	
	public void printIntroInstructions()
	{
		System.out.println("\t\t\tWelcome to the game of battleship!!! \n In this game there are 2 players. And "
				+ "there are 6 battleships to destroy - \n 3 small battleships, 2 medium battleships"
				+ " and 1 large battleship. During the course of the game \n each player will take it in turn to try"
				+ " and destroy the battleships. The players can do this by entering \n in the coordinates"
				+ " of the position on the game grid that they would like to target next: \n");
		
		//Print example grid
		exampleGrid.printGrid();
		
		//Now print symbols
		System.out.println("\n - This symbol indicates that either player has not yet fired at this location on the grid."
				+ "\n O - This symbol indicates that one of the players has fired at this location but has not hit anything."
				+ "\n X - This symbol indicates that one of the players has fired at this position and hit one of the enemy battleships.");
		
	}
	
	//Enter intro answer (Y/N)
	public String enterIntroAnswer()
	{
		System.out.println("Good Luck!! Would you like to begin the game? Y/N:"); 
		response = keyboard.next();
		return response;
	}
	
	public int introAnswerRepeat(String indicator)
	{
		int start = 0;
		if(indicator.equals("Y"))
		{
			System.out.println("Please proceed with playing the game!!");
			start = 2;
		}
		else if(indicator.equals("N"))
		{
			System.out.println("You have indicated you do not want to play the game. Goodbye.");
			start = 1;
		}
		else
		{
			System.out.println("Please enter Y or N");
		}
		
		return start;
	}
	
	//Prints out a message not to fire on own ships
	public void dontFireOnOwn()
	{
		System.out.println("Please don't fire on your own ship!!!!");
	}
	
	//Prints out a message warning that this position has already been shot at
	public void alreadyFired()
	{
		System.out.println("This position has already been fired upon!! Please choose another position!!!");
	}
	
	//Prints out a message to indicate that the player missed the enemy ships
	public void missFired()
	{
		System.out.println("Nice shot but you missed the enemy's ships!!!");
	}
	
	//Prints out a message congratulating the player on a direct hit
	public void directHit(Player aPlayer)
	{
		System.out.println("Well done " + aPlayer.getplayerName() +
				" You have made a direct hit on an enemy ship!!!");
	}
	
	//Prints out a message congratulating the player on winning the game
	public void playerWinner(Player aPlayer)
	{
		System.out.println("Well done " + aPlayer.getplayerName() +
				" You have won the game!!!");
	}
	
	//Prints out a message congratulating both players on drawing the game
	public void playerWinnerDraw(Player playerO, Player playerT)
	{
		System.out.println("Well done " + playerO.getplayerName() + " and " + playerT.getplayerName() +
				" You have both drawn the game!!!");
	}
	
	public void printGameplayInstructions(String currPlayer)
	{
		
	}
	
	//Game grid variable for illustration purposes
	GameGrid exampleGrid;
	String response;
	Scanner keyboard;

}

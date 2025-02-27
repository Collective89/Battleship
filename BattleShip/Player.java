//Imports
import java.util.Scanner;

public class Player {

	//Constructor
	Player(String name, int ID)
	{
		playerName = name;
		playerID = ID;
		keyboard = new Scanner(System.in);
		playerScore = 0;
			 				
	}					
	
	//Getters
	String getplayerName() {return playerName;}
	int getPlayerID() {return playerID;}
	int getRow() {return row;}
	int getColumn() {return column;}
	int getPlayerScore() {return playerScore;}
	
	//Setters
	//Enter the player's name
	public void enterName(String playerNo)
	{
		System.out.println(playerNo + " please enter your name: ");
		playerName = keyboard.next();
	}
	
	//Initialise the player
	public void initialisePlayer(String playerNo)
	{
		//Initialise the player's name
		enterName(playerNo);
		
	}
	
	//Functions to provide functionality to the player
	//Takes input from the player that are the coordinates of the next position that they
	//are going to shoot at
	public void makeMove()
	{
		System.out.println(playerName + " please enter in the coordinates of the position on the game grid you'd like to shoot: ");
		row = keyboard.nextInt();
		column = keyboard.nextInt();
		if(row>9||row<0||column>9||column<0)
		{
			System.out.println(playerName + " please enter row and column values that are not greater than 9 and not less than 0.");
			makeMove();
		}
	}
	
	//If the player hits a target successfully, their score must be incremented
	public void incrementScore()
	{
		playerScore++;
	}
	

	private String playerName;
	private int playerID;				//A numerical player ID
	private int row, column;			//A row and a column variable to store the player's current move
	private int playerScore;
	Scanner keyboard;					//We need a scanner to read in the row and column of the player's move
	
}

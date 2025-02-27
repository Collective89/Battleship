//Imports

public class GameController 
{
	GameController()
	{
		playerOne = new Player("Player 1", 1);
		playerTwo = new Player("Player 2", 2);
		theGameGrid = new GameGrid(10,10);
		theShadowGrid = new ShadowGrid(10,10);
		gameControlLoop = true;
		currentPlayer = 1;
		theInstructions = new Instructions();
		
		//Within the constructor initialise the players ships array storing the players ships to be 
		//size 6 to store 3 small ships, 2 medium ships and 1 large ship
		theShips = new Ship[6];
		
	}
	
	//Getters
	public ShadowGrid getShadowGrid() {return theShadowGrid;} 
	public boolean getGameControlLoop() {return gameControlLoop;}
	public Ship[] getShips() {return theShips;}
	
	//Functions to display the instructions for initiating the game
	public void dispInstrctions()
	{
		theInstructions.printIntroInstructions();
		String reply = theInstructions.enterIntroAnswer();
		int answer = theInstructions.introAnswerRepeat(reply);
		while(answer==0)
		{
			reply = theInstructions.enterIntroAnswer();
			answer = theInstructions.introAnswerRepeat(reply); 					
		}
		if(answer==1)
			gameControlLoop = false;
		else if(answer==2)
			gameControlLoop = true;
		
	}
	
	//Initialise the ships
	public void initialiseShips()
	{
		for(int i=0; i<theShips.length; i++)
		{
			//Place the small ships
			if(i==0||i==1||i==2)
			{
				theShips[i] = new SmallShip();
			}
			//Place the medium ships
			else if(i==3||i==4)
			{
				theShips[i] = new MediumShip();
			}
			//Place the large ship
			else
				theShips[i] = new LargeShip();
		}
	}
	
	//Function to initialise all of the class member variables in preparation for running the game
	public void initialiseGame()
	{
		//Initialise the ships
		initialiseShips();
		
		//Initialise the game grid
		theGameGrid.populateGrid();
		
		//Initialise the shadow grid which stores the positions of the ships
		theShadowGrid.populateGrid();
		
		//Initialise the players
		playerOne.initialisePlayer("Player 1");
		playerTwo.initialisePlayer("Player 2");
		
		//Place the ships at random empty places on the grid
		theShadowGrid.arrangePlayersShips(theShips);
	}
	
	
	public void checkShipHit(Player aPlayer)
	{
		boolean shipIsHit = false;
		
		//Now find the ship that has been hit and lower its score
		for(int i = 0; i<theShips.length; i++)
		{
			//If it is a small ship
			if(theShips[i].getShipID()==1&&(theShips[i].getShipHealth()!=0))
			{
				SmallShip currShip = (SmallShip)theShips[i];
				shipIsHit = currShip.checkFire(aPlayer.getRow(), aPlayer.getColumn());
				//If the ship is the ship fired on - lower its' health and increase this player's score
				if(shipIsHit)
				{
					currShip.lowerShipHealth();
					//If the ship has been destroyed
					if(theShips[i].getShipHealth()==0)
						aPlayer.incrementScore();					//Increment the player's score
				}
			}
			//If it is a medium ship
			else if(theShips[i].getShipID()==2&&(theShips[i].getShipHealth()!=0))
			{
				MediumShip currShip = (MediumShip)theShips[i];
				shipIsHit = currShip.checkFire(aPlayer.getRow(), aPlayer.getColumn());
				//If the ship is the ship fired on - lower its' health and increase this player's score
				if(shipIsHit)
				{
					currShip.lowerShipHealth();
					//If the ship has been destroyed
					if(theShips[i].getShipHealth()==0)
						aPlayer.incrementScore();					//Increment the player's score
					
				}
			}
			//If it is a large ship
			else if(theShips[i].getShipID()==3&&(theShips[i].getShipHealth()!=0))
			{
				LargeShip currShip = (LargeShip)theShips[i];
				shipIsHit = currShip.checkFire(aPlayer.getRow(), aPlayer.getColumn());
				//If the ship is the ship fired on - lower its' health and increase this player's score
				if(shipIsHit)
				{
					currShip.lowerShipHealth();
					//If the ship has been destroyed
					if(theShips[i].getShipHealth()==0)
						aPlayer.incrementScore();					//Increment the player's score
					
				}
			}
		}
	}
	
	//A function to check whether the player's current move is valid - has the player fired on the ships?
	public boolean checkFireOnShips(Player aPlayer)
	{
		boolean check = false;
		
		//Look at the shadow grid and see if the player has hit a ship
		if(theShadowGrid.getGameGrid()[aPlayer.getRow()][aPlayer.getColumn()].equals("P"))
		{
			
			//If the position has already been fired upon
			if(theGameGrid.getGameGrid()[aPlayer.getRow()][aPlayer.getColumn()].equals("X")||
			(theGameGrid.getGameGrid()[aPlayer.getRow()][aPlayer.getColumn()].equals("O")))
			{
				//Print a message saying that they have already fired on this position
				theInstructions.alreadyFired();
			}
			//Otherwise it is a direct hit
			else
			{
				//Change the game grid at the position the player fired at to indicate that the player has scored a direct hit
				theGameGrid.directHit(aPlayer.getRow(), aPlayer.getColumn());
				theInstructions.directHit(aPlayer);
				
				//Now lower the health of the ship that was hit
				checkShipHit(aPlayer);
				
			}
				
			
		}
		//If they have not hit a space with the ship in it
		else
		{
			//If the location hasn't been fired upon before
			if((theGameGrid.getGameGrid()[aPlayer.getRow()][aPlayer.getColumn()].equals("-")))
			{
				//Change the game grid at the position the player fired at to indicate that they player fired and missed
				theGameGrid.missFire(aPlayer.getRow(), aPlayer.getColumn());
				theInstructions.missFired();
			}
			//If it has
			else
			{
				//Print a message saying they have already fired on this position
				theInstructions.alreadyFired();
			}
		}
		return check;
	}
	
	public void checkIfPlayerWon()
	{
		int sumShipHealth = 0;
		for(int i = 0; i<theShips.length; i++)
		{
			sumShipHealth+=theShips[i].getShipHealth();
		}
		
		//Test - check health of ships
		System.out.println("The total health of the ships in the game is: " + sumShipHealth);
		
		//If all the ships have been completely sunk - then determine which player is the winner or if it is a draw
		if((sumShipHealth==0)&&(playerOne.getPlayerScore()>playerTwo.getPlayerScore()))
		{
			//If player one has won the game print a congratulatory message and end the game
			theInstructions.playerWinner(playerOne);
			gameControlLoop = false;
		}
		else if((sumShipHealth==0)&&(playerTwo.getPlayerScore()>playerOne.getPlayerScore()))
		{
			//If player two has won the game print a congratulatory message and end the game
			theInstructions.playerWinner(playerTwo);
			gameControlLoop = false;
		}
		else if((sumShipHealth==0)&&(playerTwo.getPlayerScore()==playerOne.getPlayerScore()))
		{
			theInstructions.playerWinnerDraw(playerOne, playerTwo);
			gameControlLoop = false;
		}
	}
	
	
	public void playGame()
	{
		if(currentPlayer == 1)
		{
			//The current player - Player 1 enters in the coordinates of their next shot
			playerOne.makeMove();
			
			//Check the player's fire
			checkFireOnShips(playerOne);
		
			//Change the current player to player two
			currentPlayer = 2;
			theGameGrid.printGrid();
			
			//Check if player 1 has won
			checkIfPlayerWon();
			

		}
		else
		{
			//The current player - Player 2 enters in the coordinates of their next shot
			playerTwo.makeMove();
			
			//Check the player's fire
			checkFireOnShips(playerTwo);
		
			//Change the current player to player two
			currentPlayer = 1;
			theGameGrid.printGrid();
			
			//Check if player 2 has won
			checkIfPlayerWon();

		}
	}
	
	//Private member variables
	private Player playerOne;						//Player 1
	private Player playerTwo;						//Player 2
	private GameGrid theGameGrid;					//Battleship Board
	private ShadowGrid theShadowGrid;				//A shadow grid storing the positions of all the ships in the game
	private Instructions theInstructions;			//Instructions both at the intro and also during the game
	private Ship[] theShips;						//The ships that the players are trying to sink
	boolean gameControlLoop;
	int currentPlayer;
	
}

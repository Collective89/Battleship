//Includes

/*This class is a subclass of the GameGrid class, its purpose is to secretly
store the positions of the battleships for reference so that when a move is
made - this grid is the one that is checked to see if there is a direct hit on one of the battleships.
It also provides the functionality to populate the game grid with the battleships by providing functions
which check whether a ship is being placed out of bounds vertically or horizontally and also checking
to make sure that the other ships aren't being placed at the same location of a ship already placed
on the game grid.*/
public class ShadowGrid extends GameGrid {

	//Constructor
	ShadowGrid(int rows, int columns) {
		super(rows, columns);
		
	}
	
	//Functions to populate various battleships on the shadow game grid
	//Place a small ship on an empty place on the shadow grid
	public void populateSmallShip(SmallShip theShip)
	{
		//While the position that this small ship is being placed in already has a ship placed there - keep trying
		//to place the ship until an empty space is found
		while(getGameGrid()[theShip.getFirstRowCoord()][theShip.getFirstColCoord()].equals("P"))
		{
			theShip.positionShip();
		}
		//Now place ship at available place
		getGameGrid()[theShip.getFirstRowCoord()][theShip.getFirstColCoord()]="P";
		/*System.out.println("The row position of this small ship is:  " + theShip.getFirstRowCoord() + " and"
				+ " the column position of this small ship is: " + theShip.getFirstColCoord());*/
	}
	
	//Place a medium ship on an empty place on the shadow grid
	public void populateMediumShip(MediumShip theShip)
	{
		//If the ship is aligned horizontally
		if(theShip.getAlignment()== false)
		{
			//While any 1 of the 2 spaces horizontally have another ship already placed there - keep trying to
			//place the ship until 2 empty spaces are found
			while((getGameGrid()[theShip.getFirstRowCoord()][theShip.getFirstColCoord()].equals("P"))||
				  (getGameGrid()[theShip.getFirstRowCoord()][theShip.getSecColCoord()].equals("P")))
			{
				theShip.positionShip();
			}
			
			//Now place the ship at the available place
			getGameGrid()[theShip.getFirstRowCoord()][theShip.getFirstColCoord()] = "P";
		  	getGameGrid()[theShip.getFirstRowCoord()][theShip.getSecColCoord()] = "P";
		  	/*System.out.println("The row that this medium ship occupies is:  " + theShip.getFirstRowCoord());
			System.out.println("The furthest left column position that this medium ship occupies is:  " + theShip.getFirstColCoord());
			System.out.println("The 2nd column position to the right that this medium ship occupies is:  " + theShip.getSecColCoord());*/
		}
		//If the ship is aligned vertically
		else
		{
			//While any 1 of the 2 spaces vertically have another ship already placed there - keep trying to
			//place the ship until 2 empty spaces are found
			while((getGameGrid()[theShip.getFirstRowCoord()][theShip.getFirstColCoord()].equals("P"))||
				  (getGameGrid()[theShip.getSecRowCoord()][theShip.getFirstColCoord()].equals("P")))
			{
				theShip.positionShip();
			}
			
			//Now place the ship at the available place
			getGameGrid()[theShip.getFirstRowCoord()][theShip.getFirstColCoord()] = "P";
		  	getGameGrid()[theShip.getSecRowCoord()][theShip.getFirstColCoord()] = "P";
		  	/*System.out.println("The row furthest down that this medium ship occupies is:  " + theShip.getFirstRowCoord());
			System.out.println("The 2nd row position higher up(lower) that this medium ship occupies is:  " + theShip.getSecRowCoord());
			System.out.println("The column that this medium ship occupies is:  " + theShip.getFirstColCoord());*/
		}
	}
	
	//Place a large ship on an empty place on the shadow grid
	public void populateLargeShip(LargeShip theShip)
	{
		//If the ship is aligned horizontally
		if(theShip.getAlignment()== false)
		{
			//While any 1 of the 3 spaces horizontally have another ship already placed there - keep trying to
			//place the ship until 3 empty spaces are found
			while((getGameGrid()[theShip.getFirstRowCoord()][theShip.getFirstColCoord()].equals("P"))||
				  (getGameGrid()[theShip.getFirstRowCoord()][theShip.getSecColCoord()].equals("P")||
				  (getGameGrid()[theShip.getFirstRowCoord()][theShip.getThirdColCoord()].equals("P"))))
			{
				theShip.positionShip();
			}
			
			//Now place the ship at the available space
			getGameGrid()[theShip.getFirstRowCoord()][theShip.getFirstColCoord()] = "P";
		  	getGameGrid()[theShip.getFirstRowCoord()][theShip.getSecColCoord()] = "P";
		  	getGameGrid()[theShip.getFirstRowCoord()][theShip.getThirdColCoord()] = "P";
		  	/*System.out.println("The row that this large ship occupies is:  " + theShip.getFirstRowCoord());
			System.out.println("The furthest left column position that this large ship occupies is:  " + theShip.getFirstColCoord());
			System.out.println("The 2nd column position to the right that this large ship occupies is:  " + theShip.getSecColCoord());
			System.out.println("The 3rd column position to the right that this large ship occupies is:  " + theShip.getThirdColCoord());*/
		}
		//If the ship is aligned vertically
		else
		{
			//While any 1 of the 3 spaces vertically have another ship already placed there - keep trying to
			//place the ship until 3 empty spaces are found
			while((getGameGrid()[theShip.getFirstRowCoord()][theShip.getFirstColCoord()].equals("P"))||
				  (getGameGrid()[theShip.getSecRowCoord()][theShip.getFirstColCoord()].equals("P"))||
				  (getGameGrid()[theShip.getThirdRowCoord()][theShip.getFirstColCoord()].equals("P")))
			{
				theShip.positionShip();
			}
			
			//Now place the ship at the available space
			getGameGrid()[theShip.getFirstRowCoord()][theShip.getFirstColCoord()] = "P";
			getGameGrid()[theShip.getSecRowCoord()][theShip.getFirstColCoord()] = "P";
			getGameGrid()[theShip.getThirdRowCoord()][theShip.getFirstColCoord()] = "P";
			/*System.out.println("The row furthest down that this large ship occupies is:  " + theShip.getFirstRowCoord());
			System.out.println("The 2nd row position higher up(lower) that this large ship occupies is:  " + theShip.getSecRowCoord());
			System.out.println("The 3rd row position higher up(lower) that this large ship occupies is:  " + theShip.getThirdRowCoord());
			System.out.println("The column that this large ship occupies is:  " + theShip.getFirstColCoord());*/
		}
	}
	
	//Place all of the ships in suitable random places that are unoccupied
	public void arrangePlayersShips(Ship[] theShips)
	{
		//Iterate through all of a player's ships
		for(int i=0; i<theShips.length; i++)
		{
			//If it is a small ship
			if(theShips[i].getShipID()==1)
			{
				populateSmallShip((SmallShip)theShips[i]);
			}
			//If it is a medium ship
			else if(theShips[i].getShipID()==2)
			{
				populateMediumShip((MediumShip)theShips[i]);
			}
			//If it is a large ship
			else if(theShips[i].getShipID()==3)
			{
				populateLargeShip((LargeShip)theShips[i]);
			}
		}
	}

}

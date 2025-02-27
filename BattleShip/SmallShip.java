
public class SmallShip extends Ship{
	
	//Constructor
	SmallShip()
	{
		super.setShipID(1);
		super.setShipHealth(1);
		
		//Set the alignment to be randomly vertical or horizontal - doesn't matter with small ship 
		//as it only takes up one place
		super.setAlignment(getRandomAlignment());
	}
	
	//Getters
	
	//Setters
	
	//Functions providing specific functionality to this subclass
	//Align this small ship which only takes up a single space on the grid
	public void positionShip()
	{
		setFirstRowCoord(getRandomStartRow(10));
		setFirstColCoord(getRandomStartColumn(10));
	}
	
	//A function to check whether the coordinates of a players fire are the same as on on this ship
	public boolean checkFire(int checkRow, int checkColumn)
	{
		boolean isHit = false;
		if((checkRow==getFirstRowCoord())&&(checkColumn==getFirstColCoord()))
			isHit = true;
		else
			isHit = false;
		return isHit;
	}


}

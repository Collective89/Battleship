
public class MediumShip extends Ship {
	
	//Constructor
	MediumShip()
	{
		super.setShipID(2);
		super.setShipHealth(2);
		
		//Set the alignment to be randomly vertical or horizontal
		super.setAlignment(getRandomAlignment());
	}
	
	//Getters
	int getSecColCoord() {return secColCoord;}			//Get the column coordinate of the second position
	int getSecRowCoord() {return secRowCoord;}			//Get the row coordinate of the second position
	
	//Setters
	
	//Functions providing specific functionality to this subclass
	public void positionShip()
	{
			//If the alignment is horizontal - the starting vertical coordinate for a medium 
			//ship can be any number(inclusive) between 0 and 9 (2 spaces horizontally)
			//The starting column coordinate must be 8 or less as a further position to the right horizontally
			//will be taken up by the ship as it is 2 places in size
			if(getAlignment()==false)
			{
				//Set the row coordinates
				int startRow = getRandomStartRow(10);
				setFirstRowCoord(startRow);
				secRowCoord = startRow;				//If horizontal, the row of the second position is the same
				
				//Set the column coordinates
				int startColumn = getRandomStartColumn(10);
				if(startColumn == 9)
					startColumn--;
				setFirstColCoord(startColumn);
				secColCoord = startColumn+1;		//If horizontal, the column of the second position is 1 place higher on the board
			
			}
			//If however the ship is aligned vertically - the acceptable row can only be any number(inclusive)
			//between 1 and 9 as there will be 2 spaces vertically that the ship will occupy
			//There will only be a single column number for the coordinates of the ship as it only occupies a 
			//single column.
			else
			{
				//Set the row coordinates
				int startRow = getRandomStartRow(10);
				if(startRow == 0)
					startRow++;
				setFirstRowCoord(startRow);
				secRowCoord = startRow-1;		//If vertical, the row of the second position is 1 place lower(higher) on the board
				
				//Set the column coordinates
				int startColumn = getRandomStartColumn(10);
				setFirstColCoord(startColumn);
				secColCoord = startColumn;				//If vertical, the column of the second position is the same
			}
		
	}
	
	//A function to check whether the coordinates of a players fire are the same as on on this ship
	public boolean checkFire(int checkRow, int checkColumn)
	{
		boolean isHit = false;
		if((checkRow==getFirstRowCoord())&&(checkColumn==getFirstColCoord())||
				(checkRow==secRowCoord)&&(checkColumn==secColCoord))
			isHit = true;
		else
			isHit = false;
		return isHit;
	}
	
	//Private member variables
	private int secColCoord, secRowCoord;			//The coordinates of the second position that the ship occupies

}


public class LargeShip extends Ship {
	
	//Constructor
	LargeShip()
	{
		super.setShipID(3);
		super.setShipHealth(3);
		
		//Set the alignment to be randomly vertical or horizontal
		super.setAlignment(getRandomAlignment());
	}
	
	//Getters
	int getSecColCoord() {return secColCoord;}			//Get the column coordinate of the second position
	int getSecRowCoord() {return secRowCoord;}			//Get the row coordinate of the second position
	int getThirdColCoord() {return thirdColCoord;}		//Get the column coordinate of the third position
	int getThirdRowCoord() {return thirdRowCoord;}		//Get the row coordinate of the third position
	
	//Setters
	
	//Functions providing specific functionality to this subclass
	public void positionShip()
	{
		//If the alignment is horizontal - the starting vertical coordinate for a large 
		//ship can be any number(inclusive) between 0 and 9 (3 spaces horizontally)
		//The starting column coordinate must be 7 or less as a further 2 positions to the right horizontally
		//will be taken up by the ship as it is 3 places in size
		if(getAlignment()==false)
		{
			//Set the row coordinates
			int startRow = getRandomStartRow(10);
			setFirstRowCoord(startRow);
			secRowCoord = startRow;				//If horizontal, the row of the second position is the same
			thirdRowCoord = startRow;			//If horizontal, the row of the third position is the same
			
			//Set the column coordinates
			int startColumn = getRandomStartColumn(10);
			if((startColumn == 8)||(startColumn==9))
				startColumn-=3;
			setFirstColCoord(startColumn);
			secColCoord = startColumn+1;		//If horizontal, the column of the second position is 1 place higher on the board
			thirdColCoord = startColumn+2;		//If horizontal, the column of the third position is 2 places higher on the board
		}
		//If however the ship is aligned vertically - the acceptable row can only be any number(inclusive)
		//between 2 and 9 as there will be 3 spaces vertically that the ship will occupy
		//There will only be a single column number for the coordinates of the ship as it only occupies a 
		//single column.
		else
		{	
			//Set the row coordinates
			int startRow = getRandomStartRow(10);
			if((startRow == 0)||(startRow==1))
				startRow+=2;
			setFirstRowCoord(startRow);
			secRowCoord = startRow-1;		//If vertical, the row of the second position is 1 place lower(higher) on the board
			thirdRowCoord = startRow-2;	//If vertical, the row of the third position is 2 places lower(higher) on the board
			
			//Set the column coordinates
			int startColumn = getRandomStartColumn(10);
			setFirstColCoord(startColumn);
			secColCoord = startColumn;				//If vertical, the column of the second position is the same
			thirdColCoord = startColumn;			//If vertical, the column of the third position is the same
		}
	}
	
	//A function to check whether the coordinates of a players fire are the same as on on this ship
	public boolean checkFire(int checkRow, int checkColumn)
	{
		boolean isHit = false;
		if((checkRow==getFirstRowCoord())&&(checkColumn==getFirstColCoord())||
				(checkRow==secRowCoord)&&(checkColumn==secColCoord)||
				(checkRow==thirdRowCoord)&&(checkColumn==thirdColCoord))
			isHit = true;
		else
			isHit = false;
		return isHit;
	}
	
	//Private member variables
	private int secColCoord, thirdColCoord, secRowCoord, thirdRowCoord;//The coordinates of the rest of the positions that the ship occupies
			
}

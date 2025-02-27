
public class BattleShipMain {

	public static void main(String[] args) {
		GameController theGame = new GameController();
		theGame.dispInstrctions();
		if(theGame.getGameControlLoop()==true)
		{
			theGame.initialiseGame();
			theGame.getShadowGrid().printGrid();
		}
		while(theGame.getGameControlLoop())
		{
			theGame.playGame();
		}
		
		
		
		
		//TESTING PURPOSES
		/*MediumShip aShip = new MediumShip();
		//theGame.getShadowGrid().populateMediumShip(aShip);
		aShip.positionShip();
		System.out.println("The alignment of this ship is:  " + aShip.getAlignment());
		boolean alignment = aShip.getAlignment();
		if(!alignment)			//If horizontal 
		{
			System.out.println("The row that this ship occupies is:  " + aShip.getFirstRowCoord());
			System.out.println("The furthest left column position that this ship occupies is:  " + aShip.getFirstColCoord());
			System.out.println("The 2nd column position to the right that this ship occupies is:  " + (aShip.getFirstColCoord()+1));
		}
		//Else if vertical
		else
		{
			System.out.println("The row furthest down that this ship occupies is:  " + aShip.getFirstRowCoord());
			System.out.println("The 2nd row position higher up(lower) that this ship occupies is:  " + (aShip.getFirstRowCoord()-1));
			System.out.println("The column that this ship occupies is:  " + aShip.getFirstColCoord());
			
		}*/
		
		
	}

}

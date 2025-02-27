//Imports
import java.util.Random;

public class Ship {
	
	//Constructor
	Ship()
	{

	}
	
	//Getters
	public int getShipID() {return shipID;}
	public int getShipHealth() {return shipHealth;}
	public boolean getAlignment() {return alignment;}
	public int getFirstRowCoord() {return firstRowCoord;}
	public int getFirstColCoord() {return firstColCoord;}
	
	//Setters
	public void setShipID(int ID) {this.shipID = ID;}
	public void setShipHealth(int health) {this.shipHealth = health;}
	public void setAlignment(boolean orientation) {this.alignment = orientation;}
	public void setFirstRowCoord(int fRCoord) {this.firstRowCoord = fRCoord;}
	public void setFirstColCoord(int fCCoord) {this.firstColCoord = fCCoord;}

	//Functions to generate a random row and column as well as vertical/horizontal alignnment for to position a ship in
	//Random row
	public int getRandomStartRow(int limit)
	{
		Random r = new Random();
		int startRow = r.nextInt(limit);
		return startRow;
	}
	
	//Random column
	public int getRandomStartColumn(int limit)
	{
		Random r = new Random();
		int startColumn = r.nextInt(limit);
		return startColumn;
	}
	
	//Random alignment - vertical or horizontal
	public boolean getRandomAlignment()
	{
		Random r = new Random();
		boolean orientation = r.nextBoolean();
		return orientation;
	}
	
	//Function to decrement the ships health
	public void lowerShipHealth()
	{
		this.shipHealth--;
	}
	
	
	//Private member variables
	private int shipID;
	private int shipHealth;
	private boolean alignment;					//With the alignment boolean - false = horizontal and true = vertical
	private int firstRowCoord, firstColCoord;	//The coordinates of the first segment representing the ship
}

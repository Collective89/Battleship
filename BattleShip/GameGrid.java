
public class GameGrid {
	
	//Public member functions
		//Constructor
		GameGrid(int rows, int columns)
		{
			gameGrid = new String[rows][columns];
			theRows = rows;
			theColumns = columns;
		}
		
		//Getters
		String[][] getGameGrid() {return gameGrid;}
		
		//Computational Functions
		public void directHit(int row, int column)
		{
			gameGrid[row][column] = "X";
		}
		
		public void missFire(int row, int column)
		{
			gameGrid[row][column] = "O";
		}
		
		//Populates the game grid on startup to be full of empty spaces (-)
		public void populateGrid()
		{
			for(int i = 0 ; i<theRows; i++)
			{
				for(int j = 0; j<theColumns; j++)
				{
					gameGrid[i][j] = "-";
				}
			}
		}
		
		//Prints out the game grid
		public void printGrid()
		{
			for(int i = 0; i<theRows; i++)
			{
				for(int j = 0; j<theColumns; j++)
				{
					if(j<(theColumns-1))
						System.out.print("" + gameGrid[i][j] + "  ");
					else
						System.out.print("" + gameGrid[i][j] + "\n");
				}
			}
		}
				
			
		//Private member variables
		private String[][] gameGrid;
		private int theRows;
		private int theColumns;

}

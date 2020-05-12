package methods;

import controll.Tile;

public class Copy {

	//kopierar en tile array 
	
	public static Tile[][] copy(Tile[][] grid){
		Tile[][] newgrid = new Tile[grid.length][grid[0].length];
		
		for (int i = 0; i < newgrid.length; i++) {
			for (int j = 0; j < newgrid[i].length; j++) {
				if (grid[i][j] != null) {
					newgrid[i][j] = new Tile();
					newgrid[i][j].setup(grid[i][j].getIncreases());
				}
			}
		}
		
		return newgrid;
	}
	
}

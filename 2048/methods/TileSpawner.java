package methods;

import java.util.ArrayList;

import controll.Tile;

public class TileSpawner {

	//tar in tile array och skapar en ny tile på slumpmässig tom ruta.
	 
	public static Tile[][] spawn(Tile[][] grid) {

		ArrayList<Integer> Col = new ArrayList<Integer>();

		ArrayList<Integer> Row = new ArrayList<Integer>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == null) {
					Col.add(j);
					Row.add(i);
				}
			}
		}

		int index = (int) (Math.random() * Col.size());

		grid[Row.get(index)][Col.get(index)] = new Tile();

		grid[Row.get(index)][Col.get(index)].randomSize();

		return grid;

	}
	
}

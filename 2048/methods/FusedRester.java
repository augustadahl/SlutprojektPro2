package methods;

import controll.Tile;

public class FusedRester {

	//nollst�ller fused variabeln inf�r n�sta drag
	
	public static Tile[][] reset(Tile[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != null && grid[i][j].getFuse()) {
					grid[i][j].switchFuse();
				}
			}
		}

		return grid;
	}
}

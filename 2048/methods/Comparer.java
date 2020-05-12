package methods;

import controll.Tile;

// kollar om 2 olika Tile arrayer �r olika varandra. Detta f�r att p� s� s�tt veta om f�r�ndring skett sen senaste draget.

public class Comparer {
public static boolean compare(Tile[][] grid, Tile[][] comparer) {
		
		boolean different = false;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != null && comparer[i][j] != null) {
					if (grid[i][j].getValue() != comparer[i][j].getValue()) {
						different = true;
					}
				}
				
				if ((grid[i][j] != null && comparer[i][j] == null) || (grid[i][j] == null && comparer[i][j] != null)) {
					different = true;
				}
			}
		}
		
		return different;
		
		
		
	}
}

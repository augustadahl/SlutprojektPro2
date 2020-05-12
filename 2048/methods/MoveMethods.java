package methods;

import controll.Tile;
import javafx.scene.input.KeyCode;

public class MoveMethods {

	public Tile[][] left(Tile[][] grid) {

	
			for (int row = 0; row < grid.length; row++) {

				for (int rep = 0; rep < 3; rep++) {

					for (int col = 1; col < grid[row].length; col++) {

						// sätta samman lika tiles
						if (grid[row][col] != null && grid[row][col - 1] != null) {

							if (grid[row][col].getValue() == grid[row][col - 1].getValue()
									&& !grid[row][col - 1].getFuse() && !grid[row][col].getFuse()) {

								System.out.println("svetsade");

								grid[row][col - 1].increase();
								grid[row][col] = null;
								grid[row][col - 1].switchFuse();

							}
						}

						if (grid[row][col - 1] == null && grid[row][col] != null) {

							System.out.println("to empty"); // temp

							grid[row][col - 1] = new Tile();
							grid[row][col - 1].setup(grid[row][col].getIncreases());
							grid[row][col] = null;
						}
					}
				}
			}
			
			
		return grid;
		
	}
	
	public Tile[][] right(Tile[][] grid) {

		for (int row = 0; row < grid.length; row++) {

			for (int rep = 0; rep < 3; rep++) {

				for (int col = 2; col >= 0; col--) {

					// sätta samman lika tiles
					if (grid[row][col] != null && grid[row][col + 1] != null) {

						if (grid[row][col].getValue() == grid[row][col + 1].getValue() && !grid[row][col + 1].getFuse()
								&& !grid[row][col].getFuse()) {

							System.out.println("svetsade");

							grid[row][col + 1].increase();
							grid[row][col] = null;
							grid[row][col + 1].switchFuse();

						}
					}

					if (grid[row][col + 1] == null && grid[row][col] != null) {

						System.out.println("to empty"); // temp

						grid[row][col + 1] = new Tile();
						grid[row][col + 1].setup(grid[row][col].getIncreases());
						grid[row][col] = null;
					}
				}
			}
		}

		return grid;

	}
	
	
public Tile[][] up(Tile[][] grid) {

		
	for (int col = 0; col < 4; col++) {

		for (int rep = 0; rep < 3; rep++) {

			for (int row = 1; row < 4; row++) {

				// sätta samman lika tiles
				if (grid[row][col] != null && grid[row - 1][col] != null) {

					if (grid[row][col].getValue() == grid[row - 1][col].getValue()
							&& !grid[row - 1][col].getFuse() && !grid[row][col].getFuse()) {

						System.out.println("svetsade");

						grid[row - 1][col].increase();
						grid[row][col] = null;
						grid[row - 1][col].switchFuse();

					}
				}

				if (grid[row - 1][col] == null && grid[row][col] != null) {

					System.out.println("to empty"); // temp

					grid[row - 1][col] = new Tile();
					grid[row - 1][col].setup(grid[row][col].getIncreases());
					grid[row][col] = null;
				}
			}
		}
	}
		
		
	return grid;
	
}
	
	
	
public Tile[][] down(Tile[][] grid) {

	
	for (int col = 0; col < 4; col++) {

		for (int rep = 0; rep < 3; rep++) {

			for (int row = 2; row >= 0; row--) {

				// sätta samman lika tiles
				if (grid[row][col] != null && grid[row + 1][col] != null) {

					if (grid[row][col].getValue() == grid[row + 1][col].getValue()
							&& !grid[row + 1][col].getFuse() && !grid[row][col].getFuse()) {

						System.out.println("svetsade");

						grid[row + 1][col].increase();
						grid[row][col] = null;
						grid[row + 1][col].switchFuse();

					}
				}

				if (grid[row + 1][col] == null && grid[row][col] != null) {

					System.out.println("to empty"); // temp

					grid[row + 1][col] = new Tile();
					grid[row + 1][col].setup(grid[row][col].getIncreases());
					grid[row][col] = null;
				}
			}
		}
	}
	
	
	
return grid;

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package methods;

import controll.Tile;

//tar in en tile array och beroende p� vilken riktning s� utf�rs ett enda drag i den riktningen. kommer enbart kommentera en av metoderna men de e samma p� alla

public class MoveMethods {

//	flyttar en ruta i taget. Kollar f�rst om n�sta ruta �r tom, vid svar ja flyttas rutan dit. Vid svar nej kollar den om 2 rutor har samma v�rde och sl�r is�fall ihop dem f�rutsatt att detta inte redan gjorts p� en av dem.

	public static Tile[][] left(Tile[][] grid) {

		for (int row = 0; row < grid.length; row++) {

			for (int rep = 0; rep < 3; rep++) {

				for (int col = 1; col < grid[row].length; col++) {

					// s�tta samman lika tiles
					if (grid[row][col] != null && grid[row][col - 1] != null) {

						if (grid[row][col].getValue() == grid[row][col - 1].getValue() && !grid[row][col - 1].getFuse()
								&& !grid[row][col].getFuse()) {

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

		FusedRester.reset(grid);

		return grid;

	}

	public static Tile[][] right(Tile[][] grid) {

		for (int row = 0; row < grid.length; row++) {

			for (int rep = 0; rep < 3; rep++) {

				for (int col = 2; col >= 0; col--) {

					// s�tta samman lika tiles
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

		FusedRester.reset(grid);

		return grid;

	}

	public static Tile[][] up(Tile[][] grid) {

		for (int col = 0; col < 4; col++) {

			for (int rep = 0; rep < 3; rep++) {

				for (int row = 1; row < 4; row++) {

					// s�tta samman lika tiles
					if (grid[row][col] != null && grid[row - 1][col] != null) {

						if (grid[row][col].getValue() == grid[row - 1][col].getValue() && !grid[row - 1][col].getFuse()
								&& !grid[row][col].getFuse()) {

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

		FusedRester.reset(grid);

		return grid;

	}

	public static Tile[][] down(Tile[][] grid) {

		for (int col = 0; col < 4; col++) {

			for (int rep = 0; rep < 3; rep++) {

				for (int row = 2; row >= 0; row--) {

					// s�tta samman lika tiles
					if (grid[row][col] != null && grid[row + 1][col] != null) {

						if (grid[row][col].getValue() == grid[row + 1][col].getValue() && !grid[row + 1][col].getFuse()
								&& !grid[row][col].getFuse()) {

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

		FusedRester.reset(grid);

		return grid;

	}

}

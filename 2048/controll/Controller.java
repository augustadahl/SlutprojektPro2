package controll;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import methods.Comparer;
import methods.Copy;
import methods.GameStatusTester;
import methods.MoveMethods;
import methods.TileSpawner;
import visuals.Endscreen;

//Controller är mellanhanden mellan Mainklassen och metoderna. Controller reagerar på input och skickar vidare den för behandling innan den returnerar resultatet.

//När controller skapas så skapar den ett grid för tiles och fyller den med 2 tiles.
public class Controller {

	Tile[][] grid = new Tile[4][4];

	public Controller() {

		TileSpawner.spawn(grid);
		TileSpawner.spawn(grid);

	}

	//när piltangent har tryckts ner så aktiverar denna klassen rätt metod samt kollar om det är nödvänligt att skapa en ny tile.
	public void move(KeyCode key) {

		Tile[][] comparer = Copy.copy(grid);

		switch (key) {
		case UP:
			MoveMethods.up(grid);
			break;
		case DOWN:
			MoveMethods.down(grid);
			break;
		case RIGHT:
			MoveMethods.right(grid);
			break;
		case LEFT:
			MoveMethods.left(grid);
			break;
		default:
			break;
		}

		
		if (Comparer.compare(grid, comparer)) {
			TileSpawner.spawn(grid);
		}
		
	}

	//tar och lägger till samt placerar ut tiles på rätt positioner i gruppen
	public Group position(Group root) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != null) {
					grid[i][j].setTranslateX(10 + (j * 110));
					grid[i][j].setTranslateY(10 + (i * 110));
					root.getChildren().add(grid[i][j]);
				}
			}
		}

		return root;

	}
	
	//tar bort alla tiles inför nästa drag
	public Group remove(Group root) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != null) {
					root.getChildren().remove(grid[i][j]);
				}
			}
		}

		return root;

	}
	
	//skickar iväg grid på analys kring spelets körbarhet. Om spelaren kört fast så kallar den på slutskärmen och returnerar gruppen.
	public Group status(Group root) {
		if (!GameStatusTester.TestMoveable(grid)) {
			Endscreen.display(root);
			return root;
		}
		return root;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

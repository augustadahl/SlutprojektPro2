package controll;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import methods.Comparer;
import methods.Copy;
import methods.GameStatusTester;
import methods.MoveMethods;
import methods.TileSpawner;
import visuals.Endscreen;

//Controller �r mellanhanden mellan Mainklassen och metoderna. Controller reagerar p� input och skickar vidare den f�r behandling innan den returnerar resultatet.

//N�r controller skapas s� skapar den ett grid f�r tiles och fyller den med 2 tiles.
public class Controller {

	Tile[][] grid = new Tile[4][4];

	public Controller() {

		TileSpawner.spawn(grid);
		TileSpawner.spawn(grid);

	}

	//n�r piltangent har tryckts ner s� aktiverar denna klassen r�tt metod samt kollar om det �r n�dv�nligt att skapa en ny tile.
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

	//tar och l�gger till samt placerar ut tiles p� r�tt positioner i gruppen
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
	
	//tar bort alla tiles inf�r n�sta drag
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
	
	//skickar iv�g grid p� analys kring spelets k�rbarhet. Om spelaren k�rt fast s� kallar den p� slutsk�rmen och returnerar gruppen.
	public Group status(Group root) {
		if (!GameStatusTester.TestMoveable(grid)) {
			Endscreen.display(root);
			return root;
		}
		return root;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

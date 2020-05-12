package controll;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import methods.Comparer;
import methods.Copy;
import methods.GameStatusTester;
import methods.MoveMethods;
import methods.TileSpawner;

public class Controller {

	Tile[][] grid = new Tile[4][4];

	public Controller() {

		TileSpawner.spawn(grid);
		TileSpawner.spawn(grid);

	}

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
	
	public Group status(Group root) {
		if (!GameStatusTester.TestMoveable(grid)) {
			Rectangle front = new Rectangle();
			front.setWidth(110 * 4 + 10);
			front.setHeight(110 * 4 + 10);
			front.setFill(Color.rgb(0, 0, 0, 0.5));
			root.getChildren().add(front);
			
			Text lose = new Text(225, 225, "Game Over");
			lose.setFont(Font.font("Verdana", FontWeight.BOLD, 55));
			lose.setFill(Color.WHITE);
			
			lose.setTranslateX(-lose.getBoundsInLocal().getWidth() / 2);
			lose.setTranslateY(lose.getBoundsInLocal().getHeight() / 4);
			root.getChildren().add(lose);
			return root;
		}
		return root;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

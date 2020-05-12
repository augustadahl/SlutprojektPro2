package controll;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import visuals.Background;

//Main klassen tar in input och gör om det till output med hjälp av objektet controller.

public class Main extends Application {

	public static int WindowWidth = 450;
	public static int WindowHeight = 450;
	boolean FullBoard = false;

	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("2048");
		
		Group root = new Group();
		Scene scene = new Scene(root, WindowWidth, WindowHeight, Color.SKYBLUE);

		primaryStage.setScene(scene);
		primaryStage.show();

		Background back = new Background(4);
		root.getChildren().add(back);
		
		Controller controller = new Controller();
		
		controller.position(root);

		//ett drag aktiveras om en piltangent tryckts ner.
		
		scene.setOnKeyPressed(e -> {

			
			
				KeyCode key = e.getCode();
				if (key == KeyCode.LEFT || key == KeyCode.RIGHT || key == KeyCode.UP || key == KeyCode.DOWN) {
					
				controller.remove(root);
				controller.move(key);
				controller.position(root);
				controller.status(root);
				
				
				}
		});
	}

	public static void main(String[] args) {
		launch();
	}

}
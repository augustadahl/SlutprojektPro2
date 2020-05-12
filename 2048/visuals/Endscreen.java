package visuals;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

//Skapas för att markera spelets slut.
public class Endscreen {

	public static Group display(Group root) {
	
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
	
}

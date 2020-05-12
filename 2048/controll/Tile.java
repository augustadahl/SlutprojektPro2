package controll;

import interfaces.ITile;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

//Varje enskilld tile definieras som ett objekt genom denna klassen. 

public class Tile extends Group implements ITile{

	int increases = 0;
	boolean fused = false;
	int value = 2;
	double fontsize = 55;
	Rectangle background = new Rectangle();
	Text number = new Text(50, 55, Integer.toString(value));

	//Det visuella ställs in
	public Tile() {

		background.setWidth(100);
		background.setHeight(100);
		background.setFill(Color.BEIGE);
		background.setArcHeight(15);
		background.setArcWidth(15);

		number.setFont(Font.font("Verdana", FontWeight.BOLD, fontsize));
		number.setFill(Color.DIMGRAY);

		number.setTranslateX(-number.getBoundsInLocal().getWidth() / 2);
		number.setTranslateY(number.getBoundsInLocal().getHeight() / 4);
			
			this.getChildren().addAll(background, number);
		
	}
	
	//bestämmer om rutan ska starta som en 2a eller 4a
	public void randomSize() {

		if ((int) (Math.random() * 10) + 1 == 1) {
			increase();
		}
	}

	//ökar värdet på rutan och justerar dess utseende efter det.
	public void increase() {
		value += value;
		increases++;

		double oldwidth = number.getBoundsInLocal().getWidth();

		number.setText(Integer.toString(value));

		if (number.getBoundsInLocal().getWidth() > oldwidth) {
			fontsize -= fontsize * 0.18;
			number.setFont(Font.font("Verdana", FontWeight.BOLD, fontsize));
		}

		number.setTranslateX(-number.getBoundsInLocal().getWidth() / 2);
		number.setTranslateY(number.getBoundsInLocal().getHeight() / 4);

		switch (value) {
		case 4:
			background.setFill(Color.BISQUE);
			break;
		case 8:
			background.setFill(Color.ORANGE);
			number.setFill(Color.WHITE);
			break;
		case 16:
			background.setFill(Color.DARKORANGE);
			break;
		case 32:
			background.setFill(Color.ORANGERED);
			break;
		case 64:
			background.setFill(Color.BLACK);
			break;
		default:
			break;
		}

	}

//ger värdet på rutan (så den kan jämföras)
	public int getValue() {

		return value;
	}

	//kollar om utan redan har satts ihop detta draget
	public boolean getFuse() {
		return fused;
	}
	
	//växlar boolean fused.
	public void switchFuse() {
		if (fused) {
			fused = false;
		} else {
			fused = true;
		}
	}
	
	//kollar hur många gånger den har ökat
	public int getIncreases() {
		return increases;
	}
	
	//När en ruta har flyttats så måst den skapas på nytt och denna gör värdet rätt
	public void setup(int amount) {
		for (int i = 0; i < amount; i++) {
			increase();
		}
	}
	
	
}
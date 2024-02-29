package ayub.planets_game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * @author ayub
 *
 */
public class Satellite extends GameObject{
	
	private Circle satellite;
	public Satellite(GraphicsContext gc, double x, double y, Pane root) {
		super(gc, x, y);
		// TODO Auto-generated constructor stub
		//set satellites on the screen
		satellite = new Circle(10);
		satellite.setLayoutX(x);
		satellite.setLayoutY(y);
		img=new Image(Planet.class.getResource("satellite22.png").toExternalForm());
		
		satellite.setFill(new ImagePattern(img));
		root.getChildren().add(this.satellite);
		
	}
	/**
	 * @return the satellite
	 */
	public Circle getSatellite() {
		return satellite;
	}

}

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
public class Spaceship extends GameObject{

	//the shape of the spaceship
	private Circle spaceship;
	/**
	 * 
	 * @param gc
	 * @param x
	 * @param y
	 */
	public Spaceship(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		// TODO Auto-generated constructor stub

	}

	/**
	 * default constructor for When the spaceship is built by the singleton class 
	 */
	public Spaceship() {
		super(null, 0,0);
	}
	/**
	 * sets the spaceship on the screen to a specific position
	 * @param x
	 * @param y
	 * @param gc
	 * @param root
	 */

	public void setSpaceship(double x, double y, GraphicsContext gc, Pane root) { 
		this.x = x;
		this.y = y;
		//this.root = root;		
		spaceship = new Circle(30);
		spaceship.setLayoutX(x);
		spaceship.setLayoutY(y);
		img=new Image(Spaceship.class.getResource("spaceShipp.png").toExternalForm());
		spaceship.setFill(new ImagePattern(img));
		root.getChildren().add(spaceship);
	}
	/**
	 * updates the position of the spaceship
	 * @param direction
	 */
	public void updatePosition(String direction) {

		switch(direction) {
		case "UP":
			if(y > 50) {
	            y -= 10;
	        }
			break;
		case "DOWN":
			if(y < 380) {
	            y += 10;
	        }
			break;
		case "LEFT":
			if(x > 20) {
	            x -= 10;
	        }
			break;
		default:
			if(x < 870) {
	            x += 10;
	        }
		}
		spaceship.setLayoutX(x);
		spaceship.setLayoutY(y);

	}

	/**
	 * @return the spaceship
	 */
	public Circle getSpaceship() {
		return spaceship;
	}

}

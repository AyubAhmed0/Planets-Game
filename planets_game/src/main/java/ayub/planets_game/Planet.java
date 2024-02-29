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
public class Planet extends GameObject{
	private Circle planet;
	private String nameOfThePlanet;

	public Planet(GraphicsContext gc, String nameOfPlanet, double x, double y, Pane root) {
		super(gc, x, y);
		// TODO Auto-generated constructor stub
		this.nameOfThePlanet = nameOfPlanet;
		//set planets on the screen
		planet = new Circle(40);
		planet.setLayoutX(x);
		planet.setLayoutY(y);
		if(nameOfPlanet.equals("earth"))
		{
			img=new Image(Planet.class.getResource("earth.png").toExternalForm());
		} 
		else if(nameOfPlanet.equals("mars"))
		{
		     img=new Image(Planet.class.getResource("mars.png").toExternalForm());
		}
		else if(nameOfPlanet.equals("venus"))
		{
			img=new Image(Planet.class.getResource("venus.png").toExternalForm());
		}
		else if(nameOfPlanet.equals("jupiter"))
		{
			img=new Image(Planet.class.getResource("jupiter.png").toExternalForm());
		}
		else if(nameOfPlanet.equals("mercury"))
		{
			img=new Image(Planet.class.getResource("mercury.png").toExternalForm());
		}
		planet.setFill(new ImagePattern(img));
		root.getChildren().add(planet);
	}
	
	/**
	 * @return get planet name
	 */
	public String getPlanetName() {
		return nameOfThePlanet;
	}

	/**
	 * @return the planet
	 */
	public Circle getPlanet() {
		return planet;
	}
	

}

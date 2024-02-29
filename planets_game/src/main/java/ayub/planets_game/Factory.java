package ayub.planets_game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

/**
 * @author ayub
 *
 */
public class Factory implements FactoryIF{
	private GraphicsContext gc;
	private Pane root;
	public Factory(GraphicsContext gc, Pane root)
	{
		super();
		this.gc = gc;
		this.root = root;
	}
	/**
	 * Creates an object depending on the discrim provided
	 * @param discrim
	 * @param nameOfPlanet
	 * @param x
	 * @param y
	 */
	@Override
	public GameObject createProduct(String discrim, String nameOfPlanet, double x, double y) {
		// TODO Auto-generated method stub
		if(discrim.equals("planet"))
			return new Planet(gc,nameOfPlanet,x,y, root);
		else if (discrim.equals("satellite"))
			return new Satellite(gc,x,y,root);
		return null;
	}
}

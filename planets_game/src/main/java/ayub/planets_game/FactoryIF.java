package ayub.planets_game;


/**
 * @author ayub
 *
 */
public interface FactoryIF {
	GameObject createProduct(String discrim, String nameOfPlanet, double x, double y);
}

package ayub.planets_game;



/**
 * @author ayub
 *
 */
public class Singleton {
	
	private static Spaceship instance = null;

	/**
	 * a private constructor for the class
	 */
	private Singleton() {
		// TODO Auto-generated constructor stub
		instance = new Spaceship();
	}

	/**
	 * creates spaceship if it is not created
	 * @return spaceship
	 */
	public static Spaceship getInstance() {
		
		if (instance == null) {
			new Singleton();
		}
		
			return instance;
	}

}

package ayub.planets_game;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
//import javafx.scene.media.AudioClip;


/**
 * @author ayub
 *
 */
public class Model {
	// list of satellites
	private ArrayList<Satellite> satelliteList = new ArrayList<Satellite>();
	// is spaceship created
	private boolean spaceshipCreated;
	//  a field to hold the single spaceship
	private Spaceship spaceship;	
	// did the game begin
	private boolean gameStarted;
	// list of planets
	private ArrayList<Planet> planets;
	//background music
	//private AudioClip backgroundMusic = new AudioClip(this.getClass().getResource("gameBackgroundMusic.mp3").toExternalForm());
	//array with planet names
	private String[] planetNames;
	/*
	 * constructor of the class
	 */
	public Model() {
		planetNames = new String[]{"earth","mercury","jupiter","venus","mars"};
		spaceship = Singleton.getInstance();
		planets = new ArrayList<Planet>();
		spaceshipCreated = false;
		gameStarted = false;

	}
	/**
	 * sets the spaceship on the screen to a specific position
	 * @param gc
	 * @param root
	 */
	public void setSpaceship(GraphicsContext gc, Pane root)
	{
		spaceship.setSpaceship(50, 195, gc, root);
		spaceshipCreated = true;
	}
	/**
	 * @return the satellitList
	 */
	public ArrayList<Satellite> getSatelliteList() {
		return satelliteList;
	}
	/**
	 * @param satellitList the satellitList to set
	 */
	public void setSatelliteList(Satellite satellite) {
		satelliteList.add(satellite);
	}
	/**
	 * @return the spaceshipCreated
	 */
	public boolean isSpaceshipCreated() {
		return spaceshipCreated;
	}
	/**
	 * @param spaceshipCreated the spaceshipCreated to set
	 */
	public void setSpaceshipCreated(boolean spaceshipCreated) {
		this.spaceshipCreated = spaceshipCreated;
	}
	/**
	 * @return the spaceship
	 */
	public Spaceship getSpaceship() {
		return spaceship;
	}
	/**
	 * @param spaceship the spaceship to set
	 */
	public void setSpaceship(Spaceship spaceship) {
		this.spaceship = spaceship;
	}
	/**
	 * @return the gameStarted
	 */
	public boolean isGameStarted() {
		return gameStarted;
	}
	/**
	 * @param gameStarted the gameStarted to set
	 */
	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}
	/**
	 * @return the planets
	 */
	public ArrayList<Planet> getPlanets() {
		return planets;
	}
	/**
	 * @param planets the planets to set
	 */
	public void setPlanets(Planet planet) {
		this.planets.add(planet);
	}
	/**
	 * @return the backgroundMusic
	 */
//	public AudioClip getBackgroundMusic() {
//		return backgroundMusic;
//	}

	/**
	 * @return the planetNames
	 */
	public String[] getPlanetNames() {
		return planetNames;
	}



}

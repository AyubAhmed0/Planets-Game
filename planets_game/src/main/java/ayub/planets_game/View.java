package ayub.planets_game;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * @author ayub
 *
 */
public class View {
	private Pane root;
	private Model model;
	private Factory factory;
	private GraphicsContext gc;
	private Canvas canvas;
	private Button beginGameButton;
	private Button startGameButton = new Button("begin game");
	private Button instructionButton;
	private Button quitButton;
	private Button tryAgain = new Button("tryAgain");
	private Button gotIt = new Button("got it");
	private Scene scene;
	private BackgroundImage bgImage;

	/**
	 * @param root
	 * @param model
	 * @param gc
	 * @param canvas
	 * @param scene
	 */
	public View(Pane root, GraphicsContext gc,Canvas canvas, Model model, Scene scene) {
		super();
		this.root = root;
		this.model = model;
		this.scene = scene;
		this.factory = new Factory(this.gc, root);
		this.gc = gc;
		this.canvas = canvas;
		this.factory = new Factory(this.gc, root);
	   // model.getBackgroundMusic().play();
		menu();

	}
	/**
	 * sets the menu of the game
	 */
	public void menu()
	{

		//set background image of the menu page
		bgImage= new BackgroundImage(new Image(Planet.class.getResource("home.png").toExternalForm(),0,0,false,true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		root.setBackground(new Background(bgImage));


		//set begin game button to begin the game
		beginGameButton = new Button("Begin Game");
		beginGameButton.setStyle("-fx-background-color: #ac47aa; -fx-text-fill: white; -fx-font: bold italic 20pt \"Arial\"; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-pref-width: 200px");
		beginGameButton.setLayoutX(370);
		beginGameButton.setLayoutY(203);

		//set instruction button 
		instructionButton = new Button("Instructions");
		instructionButton.setStyle("-fx-background-color: #ac47aa; -fx-text-fill: white; -fx-font: bold italic 20pt \"Arial\"; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-pref-width: 200px");
		instructionButton.setLayoutX(370);
		instructionButton.setLayoutY(265);

		//set quit game button to quit the game
		quitButton = new Button("Quit Game");
		quitButton.setStyle("-fx-background-color: #ac47aa; -fx-text-fill: white; -fx-font: bold italic 20pt \"Arial\"; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-pref-width: 200px");
		quitButton.setLayoutX(370);
		quitButton.setLayoutY(327);
		root.getChildren().addAll(beginGameButton, instructionButton, quitButton);

	}
	/**
	 * sets the game up
	 */
	public void game() {

		// Clear things on the screen
		this.root.getChildren().clear();
		//set background image of the game page
		bgImage = new BackgroundImage(new Image(Planet.class.getResource("gameBG.png").toExternalForm()),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		root.setBackground(new Background(bgImage));

		createPlanet();
		createSatellite();
	}
	/**
	 * sets the instruction page 
	 */
	public void instructions() {
		// Clear things on the screen
		root.getChildren().clear();
		//set background image of the instructions page
		bgImage= new BackgroundImage(new Image(Planet.class.getResource("gameControls.png").toExternalForm()),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		root.setBackground(new Background(bgImage));
		//set start game button
		startGameButton.setStyle("-fx-background-color: #ac47aa; -fx-text-fill: white; -fx-font: bold italic 20pt \"Arial\"; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-pref-width: 200px");
		startGameButton.setLayoutX(350);
		startGameButton.setLayoutY(337);
		root.getChildren().add(startGameButton);
	}
	
	/**
	 * sets the try again page when the user hits a satellite
	 */
	public void tryAgain()
	{
		root.getChildren().clear();
		//set try again button
		tryAgain.setStyle("-fx-background-color: #ad1337; -fx-text-fill: white; -fx-font: bold italic 20pt \"Arial\"; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-pref-width: 200px");
		tryAgain.setLayoutX(360);
		tryAgain.setLayoutY(227);

		//set try again message
		Text homeTitle = new Text("Oh no you hit a satellite");
		homeTitle.setStyle("-fx-font: 57px Tahoma; -fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black; -fx-stroke-width: 1;");
		homeTitle.setLayoutX(130);
		homeTitle.setLayoutY(190);

		root.getChildren().addAll(homeTitle, tryAgain);
	}
	/**
	 * provides information about each planet
	 */
	public void planetInformation(String plannetName)
	{
		// Clear things on the screen
		root.getChildren().clear();
		// show user correct information according to the planet they have landed
		if(plannetName.equals("earth")) {
			bgImage= new BackgroundImage(new Image(Planet.class.getResource("imEarth.png").toExternalForm()),
					BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			gotIt.setStyle("-fx-background-color: #51ee70; -fx-text-fill: black; -fx-font: bold italic 20pt \"Arial\"; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-pref-width: 200px");
		} 
		else if (plannetName.equals("mercury"))
		{
			bgImage= new BackgroundImage(new Image(Planet.class.getResource("imMercury.png").toExternalForm()),
					BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			gotIt.setStyle("-fx-background-color: #ffe4b5; -fx-text-fill: black; -fx-font: bold italic 20pt \"Arial\"; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-pref-width: 200px");

		}
		else if (plannetName.equals("jupiter"))
		{
			bgImage= new BackgroundImage(new Image(Planet.class.getResource("imJupiter.png").toExternalForm()),
					BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			gotIt.setStyle("-fx-background-color: #ffe461; -fx-text-fill: black; -fx-font: bold italic 20pt \"Arial\"; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-pref-width: 200px");

		}
		else if (plannetName.equals("venus"))
		{
			bgImage= new BackgroundImage(new Image(Planet.class.getResource("imVenus.png").toExternalForm()),
					BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			gotIt.setStyle("-fx-background-color: #fee980; -fx-text-fill: black; -fx-font: bold italic 20pt \"Arial\"; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-pref-width: 200px");

		}
		else if (plannetName.equals("mars"))
		{
			bgImage= new BackgroundImage(new Image(Planet.class.getResource("imMars.png").toExternalForm()),
					BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			gotIt.setStyle("-fx-background-color: #ff973f; -fx-text-fill: black; -fx-font: bold italic 20pt \"Arial\"; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );-fx-pref-width: 200px");

		}
		gotIt.setLayoutX(370);
		gotIt.setLayoutY(327);
		root.setBackground(new Background(bgImage));
		root.getChildren().addAll(gotIt);
	}
	/**
	 * creates planets
	 */
	public void createPlanet() {
		//create 5 planets
		int x = 300;
		for(int i=0;i<5;i++)
		{
			GameObject planet = factory.createProduct("planet", model.getPlanetNames()[i], x, 210);
			this.model.setPlanets((Planet)planet);
			x+=100;

		}

	}
	/**
	 * creates satellites
	 */
	public void createSatellite()
	{
		int x = 100;
		int y = 70;
		//create satellites 
		for(int i=0;i<3;i++) 
			for(int j=0;j<5;j++)
			{
				GameObject satellite = factory.createProduct("satellite",null, x, j*y);
				this.model.setSatelliteList((Satellite)satellite);
				x+=50;
				y+=11;

			}
	}
	
	/**
	 * updates the view by calling the game method
	 */
	
	public void updateView()
	{
		game();

	}
	/**
	 * @return the root
	 */
	public Pane getRoot() {
		return root;
	}
	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}
	/**
	 * @return the gc
	 */
	public GraphicsContext getGc() {
		return gc;
	}
	/**
	 * @return the canvas
	 */
	public Canvas getCanvas() {
		return canvas;
	}
	/**
	 * @return the beginGameButton
	 */
	public Button getBeginGameButton() {
		return beginGameButton;
	}
	/**
	 * @return the startGameButton
	 */
	public Button getStartGameButton() {
		return startGameButton;
	}
	/**
	 * @return the instructionButton
	 */
	public Button getInstructionButton() {
		return instructionButton;
	}
	/**
	 * @return the quitButton
	 */
	public Button getQuitButton() {
		return quitButton;
	}
	/**
	 * @return the tryAgain
	 */
	public Button getTryAgain() {
		return tryAgain;
	}
	/**
	 * @return the gotIt
	 */
	public Button getGotIt() {
		return gotIt;
	}
	/**
	 * @return the scene
	 */
	public Scene getScene() {
		return scene;
	}

}

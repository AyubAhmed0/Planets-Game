package ayub.planets_game;

import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * @author ayub
 * the is the controller class
 *
 */
public class Controller implements EventHandler{
	private Model model;
	private View view;
	private GraphicsContext gc;
	private Canvas canvas;

	public Controller(Model model, View view,GraphicsContext gc, Canvas canvas) {
		super();
		this.model = model;
		this.view = view;
		this.gc = gc;
		this.canvas = canvas;
		this.view.getBeginGameButton().setOnAction(this);
		this.view.getTryAgain().setOnAction(this);
		this.view.getGotIt().setOnAction(this);
		this.view.getQuitButton().setOnAction(this);
		this.view.getInstructionButton().setOnAction(this);
		this.view.getStartGameButton().setOnAction(this);

	}

	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		// handle the events 
		if(event.getSource()==this.view.getBeginGameButton() || event.getSource()==this.view.getTryAgain() || event.getSource()==this.view.getGotIt()
				|| event.getSource()==this.view.getStartGameButton()) {
			//start timer
			timer.start();
			//set game started to true
			this.model.setGameStarted(true);
			//update the view to the game view
			view.updateView();
		}
		else if (event.getSource()==this.view.getQuitButton())
		{
			//exit the game
			System.exit(0);
		}

		else if (event.getSource()==this.view.getInstructionButton())
		{
			//show the instruction page
			view.instructions();
			
		}
	}

	// if any keys are pressed
	EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {

			// check which key is pressed and update the position of the spaceship accordingly 
			if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W)
			{
				model.getSpaceship().updatePosition("UP");
			} 
			else if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) 
			{
				model.getSpaceship().updatePosition("DOWN");
			} 
			else if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) 
			{
				model.getSpaceship().updatePosition("LEFT");
			}
			else if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) 
			{
				model.getSpaceship().updatePosition("RIGHT");
			} 

		}
	};




	AnimationTimer timer = new AnimationTimer() {
		@Override
		public void handle(long now) {
			//if the game started run body
			if (model.isGameStarted() == true) {
				// if the spaceship is not created call the setSpaceship method in model
				if (model.isSpaceshipCreated() == false) {
					model.setSpaceship(view.getGc(), view.getRoot());
				}

				// Go to the key Handler if a key is clicked.
				view.getScene().setOnKeyPressed(keyHandler);
				
				//go through the list of planets
				for (Planet planet : model.getPlanets()) {
					//if the spaceship and planet intersect run the body
					if (model.getSpaceship().getSpaceship().getBoundsInParent().intersects(planet.getPlanet().getBoundsInParent())) {
						//set spaceship created to false
						model.setSpaceshipCreated(false);
						//set game started to false
						model.setGameStarted(false);
						//show the planet information
						view.planetInformation(planet.getPlanetName());

					}
				}
				//loop through the list of satellites
				for (int i = 0; i < model.getSatelliteList().size(); i++) {
					Satellite satellite = model.getSatelliteList().get(i);
					//if the spaceship intersects with satellite run the body
					if (model.getSpaceship().getSpaceship().getBoundsInParent().intersects(satellite.getSatellite().getBoundsInParent())) {
						//set spaceship created to false
						model.setSpaceshipCreated(false);
						//set game started to false
						model.setGameStarted(false);
						//show try again message
						view.tryAgain();
					}

				}

			}

		}};

}

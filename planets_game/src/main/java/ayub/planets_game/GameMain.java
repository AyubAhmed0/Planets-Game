package ayub.planets_game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author ayub
 * @version 05/04/2022
 * This class is the main class of the application
 *
 */
public class GameMain extends Application{

	private Pane root;
	private Scene scene;
	private Canvas canvas;
	private GraphicsContext gc;
	private Controller controller;
	private Model model;
	private View view;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		//create a Pane
		root = new Pane();
		//create a scene
		scene = new Scene(root,900,500); 
		//Create a canvas
		canvas = new Canvas(900,500);
		//Initialise graphicsContext
		gc = canvas.getGraphicsContext2D(); 
		//set scene
		primaryStage.setScene(scene); 
		//set title
		primaryStage.setTitle("land on planets");
		//set height
		primaryStage.setHeight(450);
		//set resizable to false
		primaryStage.setResizable(false);
		//show scene
		primaryStage.show();
		//Add canvas to scene
		root.getChildren().add(canvas);
		//Initialise model
		model = new Model();
		//Initialise view
		view = new View(root,gc,canvas, model, scene);
		//Initialise controller
		controller = new Controller(model, view, gc, canvas);
	}
}

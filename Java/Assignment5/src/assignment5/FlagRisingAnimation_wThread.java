//Jason Rutledge
//Assignment 5
//Purpose: Implement multithreading in raising a flag

package assignment5;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimation_wThread extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		
		
// Create a pane
		Pane pane = new Pane();
// Add an image view and add it to pane
		ImageView imageView = new ImageView("image/us.gif");
		pane.getChildren().add(imageView);
		
		class RaiseFlag implements Runnable {
			@Override
			public void run() {
				PathTransition pt = new PathTransition(Duration.millis(10000), new Line(100, 200, 100, 0), imageView);
				pt.setCycleCount(5);
				pt.play();
			}
		}
		
// Create a path transition
		Thread t = new Thread(new RaiseFlag());
		t.start();
		// Start animation
// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 500, 400);
		primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line.
	 */
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
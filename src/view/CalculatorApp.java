package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This will be there main class where the Business Logic will be.
 * @author zacharyishmael
 *
 */
public class CalculatorApp extends Application {

	/**
	 * An overridden method from the application class.
	 * Used to 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Calculator App");
		Parent root = FXMLLoader.load(getClass().getResource("/resources/CalculatorMain.fxml"));
		Scene scene = new Scene(root, 726, 480);
		primaryStage.setWidth(726);
		primaryStage.setHeight(480);
		primaryStage.setMinWidth(400);
		primaryStage.setMinHeight(370);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * The main method of the application.
	 * The place from which the arguments are launched
	 * @param args - arguments of the main method (other methods)
	 */
	public static void main (String [] args) {
		launch(args);
	}

	/**
	 * Loads the scene where Present Value may be worked out.
	 * This scene takes user input parameters in order
	 * to then work out the present value of assets.
	 */
	public void loadPV (Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/resources/CalculatorPV.fxml"));
		Scene scene = new Scene (root, 600, 400);
		primaryStage.setScene(scene);
	}
	/**
	 * Loads the scene where Present Value may be worked out.
	 * This scene takes user input parameters in order
	 * to then work out the present value of assets.
	 */
	public void loadFV (Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/resources/CalculatorFV.fxml"));
		Scene scene = new Scene (root, 600, 400);
		primaryStage.setScene(scene);
	}
	
}

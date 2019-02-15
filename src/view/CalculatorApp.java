package view;

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

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Calculator App");
		Parent root = FXMLLoader.load(getClass().getResource("/view/CalculatorMain.fxml"));
		Scene scene = new Scene(root, 600, 400);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main (String [] args) {
		launch(args);
	}

	
	
}

package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This will be there main class where the Business Logic will be.
 * @author zacharyishmael
 *
 */
public class CalculatorApp extends Application {

	static Stage primaryStage = new Stage();
	/**
	 * An overridden method from the application class.
	 * Used to 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		CalculatorApp.primaryStage.setTitle("Calculator App");
		Parent root = FXMLLoader.load(CalculatorApp.class.getResource("/resources/CalculatorMain.fxml"));
		Scene scene = new Scene(root, 726, 480);
		CalculatorApp.primaryStage.setWidth(726);
		CalculatorApp.primaryStage.setHeight(480);
		CalculatorApp.primaryStage.setMinWidth(400);
		CalculatorApp.primaryStage.setMinHeight(370);
		//CalculatorApp.primaryStage.initModality(Modality.APPLICATION_MODAL);
		CalculatorApp.primaryStage.setScene(scene);
		CalculatorApp.primaryStage.show();
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
	public static void loadPV () throws IOException {
		Parent root = FXMLLoader.load(CalculatorApp.class.getResource("/resources/PV.fxml"));
		Scene scene = new Scene (root, 600, 400);
		primaryStage.setScene(scene);
	}
	/**
	 * Loads the scene where Present Value may be worked out.
	 * This scene takes user input parameters in order
	 * to then work out the present value of assets.
	 */
	public static void loadFV () throws IOException {
		Parent root = FXMLLoader.load(CalculatorApp.class.getResource("/resources/FV.fxml"));
		Scene scene = new Scene (root, 600, 400);
		primaryStage.setScene(scene);
	}
	
	/**
	 * Loads Main scene - fomr which the about section is visible
	 * @throws IOException
	 */
	public static void loadMain () throws IOException {
		Parent root = FXMLLoader.load(CalculatorApp.class.getResource("/resources/CalculatorMain.fxml"));
		Scene scene = new Scene (root, 600, 400);
		primaryStage.setScene(scene);
	}
	
	/**
	 * Loads the Current Ratio Scene (CurrentRatio.fxml).
	 * From this scene you can work out the current ratio
	 * @throws IOException
	 */
	public static void loadCurrentRatio () throws IOException {
		Parent root = FXMLLoader.load(CalculatorApp.class.getResource("/resources/CurrentRatio.fxml"));
		Scene scene = new Scene (root, 600, 400);
		primaryStage.setScene(scene);
	}
	
	/**
	 * Loads the Debt Equity Scene.
	 * From this scene you can work out Debt Equity
	 * @throws IOException
	 */
	public static void loadDebtEquity () throws IOException {
		Parent root = FXMLLoader.load(CalculatorApp.class.getResource("/resources/DebtEquity.fxml"));
		Scene scene = new Scene (root, 600, 400);
		primaryStage.setScene(scene);
	}
	
	/**
	 * Loads the Capital Work Scene.
	 * From this scene you can work out 
	 * @throws IOException
	 */
	public static void loadCapitalWork () throws IOException {
		Parent root = FXMLLoader.load(CalculatorApp.class.getResource("/resources/CapitalWork.fxml"));
		Scene scene = new Scene (root, 600, 400);
		primaryStage.setScene(scene);
	}
	
	/**
	 * Loads the Gross Profit Scene.
	 * From this scene you can calculate Gross Profit
	 * @throws IOException
	 */
	public static void loadGrossProfit () throws IOException {
		Parent root = FXMLLoader.load(CalculatorApp.class.getResource("/resources/GrossProfit.fxml"));
		Scene scene = new Scene (root, 600, 400);
		primaryStage.setScene(scene);
	}
	/**
	 * Get Primary Stage.
	 * used to access the primary stage from other classes
	 */
	public Stage getPS() {
		return CalculatorApp.primaryStage;
	}
}

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.CalculatorApp;

public class FxController {
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="moneyImageView"
    private ImageView moneyImageView; // Value injected by FXMLLoader

    @FXML // fx:id="hboxTop"
    private HBox hboxTop; // Value injected by FXMLLoader

    @FXML // fx:id="pvImageView1"
    private ImageView pvImageView1; // Value injected by FXMLLoader

    @FXML // fx:id="pvImageView"
    private ImageView pvImageView; // Value injected by FXMLLoader

    @FXML // fx:id="hboxButtonKey"
    private HBox hboxButtonKey; // Value injected by FXMLLoader

    @FXML // fx:id="hboxLeft"
    private VBox hboxLeft; // Value injected by FXMLLoader
    
	@FXML
    private TextField textFieldFV;
     
    @FXML
    private TextField textFieldYears;

    @FXML
    private TextField textFieldInterest;

    /**
     * An instance of the class value.
     * Used to work out present and future value
     */
    Value value = new Value();
  
    /**
     * Submit inout from user to controller.
     * Then changes text to doubles and worksas out the present value.
     * @return double presentValue (or zero if no valid input)
     */
    @FXML
    public double submitPV() {
    	boolean valid = true; // turns false when textFields are empty
    	if (textFieldFV.getText().isEmpty()) {/*do something*/ System.out.println("textFieldFV is empty"); valid = false;} // should show warning message (int textfield???) that will disappear when you enter new data
    	if (textFieldInterest.getText().isEmpty()) {/*do something*/ System.out.println("textFieldInterest is empty"); valid = false;}
    	if (textFieldYears.getText().isEmpty()) {/*do something*/System.out.println("textFieldYears is empty"); valid = false;}
    	
    	if (valid) { 
    	double futureValue = Double.parseDouble(textFieldFV.getText());
    	double interestRate = Double.parseDouble(textFieldInterest.getText());
    	double n = Double.parseDouble(textFieldYears.getText());
    	double pv = value.workOutPv(futureValue, interestRate, n);
    	
    	System.out.println("Future Value: "+futureValue + " Interest Rate: "+ interestRate + " Years: " + n + "\nPresent Value: " + pv);
    	return	pv;
    	}
    	return 0.0;
    }

    /**
     * Changes scene to Present Value Scene.
     * @throws IOException
     */
    @FXML
    public void pvImageViewClicked () throws IOException {
    	CalculatorApp.loadPV();
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert moneyImageView != null : "fx:id=\"moneyImageView\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert hboxTop != null : "fx:id=\"hboxTop\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert pvImageView1 != null : "fx:id=\"pvImageView1\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert pvImageView != null : "fx:id=\"pvImageView\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert hboxButtonKey != null : "fx:id=\"hboxButtonKey\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert hboxLeft != null : "fx:id=\"hboxLeft\" was not injected: check your FXML file 'CalculatorMain.fxml'.";

    }
}

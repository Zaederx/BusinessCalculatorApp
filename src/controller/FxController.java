package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.CalculatorApp;
import controller.Ratio;

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

    @FXML // fx:id="fvImageView"
    private ImageView fvImageView; // Value injected by FXMLLoader
    
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
    
    @FXML
    private TextField textFieldAmountInvested;
    
    @FXML
    private Label labelResult;
    
    @FXML
    private ImageView ratiosImageView;
    
    @FXML
    private TextField textFieldTotalDebt;
    
    @FXML 
    private TextField textFieldTotalEquity;
    

    @FXML
    private Button subButtonDebtEquityClicked;
    
    @FXML
    private TextField textFieldCurrentAsset;
    
    @FXML
    private TextField textFieldCurrentLiabilities;
    
    @FXML
    private TextField textErrorAmountInvested;
    
    
    
    @FXML
    private Label labelErrorFV;
    
    @FXML
    private Label labelErrorInterest;
    
    @FXML
    private Label labelErrorYears;
    
    
    
//    @FXML
//    private Label error1;
//    
//    @FXML
//    private Label error2;
//    
//    @FXML
//    private Label error3;
//    
    
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
    	double futureValue = 0;
    	double interestRate = 0;
    	double n = 0;
    	double pv = 0.0;
    	if (textFieldFV.getText().isEmpty()) {/*do something*/ System.out.println("textFieldFV is empty"); labelErrorFV.setVisible(true); valid = false;} // should show warning message (int textfield???) that will disappear when you enter new data
    	
    	if (textFieldInterest.getText().isEmpty()) {/*do something*/ System.out.println("textFieldInterest is empty"); labelErrorInterest.setVisible(true); valid = false;}
    	
    	if (textFieldYears.getText().isEmpty()) {/*do something*/System.out.println("textFieldYears is empty"); labelErrorYears.setVisible(true); valid = false;}
 
    	if (valid) { 
    		labelErrorFV.setVisible(false);
    		labelErrorInterest.setVisible(false);
    		labelErrorYears.setVisible(false);
    	
    		try {
    	futureValue = Double.parseDouble(textFieldFV.getText());
    		}
    		catch (Exception e) {
    		labelErrorFV.setVisible(true);
    		valid = false;
    		}
    		try {
    	interestRate = Double.parseDouble(textFieldInterest.getText());
    		}
    		catch (Exception e) {
    		labelErrorInterest.setVisible(true);
    		valid = false;
    		}
    		try {
    			n = Double.parseDouble(textFieldYears.getText());
    		}
    		catch (Exception e) {
    		labelErrorYears.setVisible(true);
    		valid = false;
    		}
    	
    	if(valid) {
    	pv = value.workOutPv(futureValue, interestRate, n);
    	displayResult(pv);
    	System.out.println("Future Value: "+futureValue + " Interest Rate: "+ interestRate + " Years: " + n + "\nPresent Value: " + pv);
    	}
    	
    
    	
    	return	pv;
    	}
    	return 0.0;
    }
    
    /**
     * 
     * @return double fv - future value (or 0.0 if no valid input is given)
     */
    @FXML
    public double submitFV() {
    	boolean valid = true; // turns false when textFields are empty
    	try {
    	if (textFieldAmountInvested.getText().isEmpty()) {/*do something*/ System.out.println("textFieldFV is empty"); valid = false;} // should show warning message (int textfield???) that will disappear when you enter new data
    	}
    	catch (Exception e) {
    	
    	}
    	try {
    	if (textFieldInterest.getText().isEmpty()) {/*do something*/ System.out.println("textFieldInterest is empty");  valid = false;}
    	}
    	catch (Exception e) {
    	
    	}
    	try {
    	if (textFieldYears.getText().isEmpty()) {/*do something*/System.out.println("textFieldYears is empty");  valid = false;}
    	}
    	catch (Exception e) {
    		
    	}
    	if (valid) { 
    		
    		
    	double futureValue = Double.parseDouble(textFieldAmountInvested.getText());
    	double interestRate = Double.parseDouble(textFieldInterest.getText());
    	double n = Double.parseDouble(textFieldYears.getText());
    	double fv = value.workOutPv(futureValue, interestRate, n);
    	displayResult(fv);
    	System.out.println("Future Value: "+ textFieldAmountInvested + " Interest Rate: "+ interestRate + " Years: " + n + "\nPresent Value: " + fv);
    	return	fv;
    	}
    	return 0.0;
    }

    @FXML
    public double submitDebtEquityRatios() {
    	boolean valid = true; // turns false when textFields are empty
    	if (textFieldTotalDebt.getText().isEmpty()) {/*do something*/ System.out.println("textFieldTotalDebt is empty"); valid = false;} // should show warning message (int textfield???) that will disappear when you enter new data
    	if (textFieldTotalEquity.getText().isEmpty()) {/*do something*/ System.out.println("textFieldTotalEquity is empty"); valid = false;}
    	
    	
    	if (valid) { 
    	double totalDebt = Double.parseDouble(textFieldTotalDebt.getText());
    	double totalEquity = Double.parseDouble(textFieldTotalEquity.getText());
    	
    	double debtEquity = Ratio.debtEquityRatio(totalDebt, totalEquity);
    	displayResult(debtEquity);
    	System.out.println("Total Debt:"+ totalDebt + " Total Equity: "+ totalEquity + "\nDebt Equity Ratio: " + debtEquity);
    	return	debtEquity;
    	}
    	return 0.0;
    }
    
    public double submitWorkingCapital () {
    	boolean valid = true;
    	if (textFieldCurrentAsset.getText().isEmpty()) {/*do something*/ System.out.println("textFieldCurrentAsset is empty");  valid = false;} // should show warning message (int textfield???) that will disappear when you enter new data
    	if (textFieldCurrentLiabilities.getText().isEmpty()) {/*do something*/ System.out.println("textFieldCurrentLiabilities is empty");  valid = false;}
    	if (valid) {
    	double currentAsset = Double.parseDouble(textFieldCurrentAsset.getText());
    	double currentLiabilities = Double.parseDouble(textFieldCurrentLiabilities.getText());
    	double workingCapital = Ratio.workingCaptialRatio(currentAsset, currentLiabilities);
    	return workingCapital;
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
    
    /**
     * Changes scene to Future Value (FV.fxml) Scene.
     * @throws IOException
     */
    @FXML
    public void fvImageViewClicked () throws IOException {
    	CalculatorApp.loadFV();
    }
    
    /**
     * Loads the CurrentRatio.fxml scene
     * @throws IOException
     */
    @FXML
    public void ratiosImageViewClicked () throws IOException {
    	CalculatorApp.loadCurrentRatio();
    }
    
    /**
     * Changes the view back to the main
     * @throws IOException
     */
    @FXML
    public void moneyImageViewClicked() throws IOException {
    	CalculatorApp.loadMain();
    }
    
    public void workingCapitalClicked() throws IOException {
    	CalculatorApp.loadCapitalWork();
    }
    
    public void debtEquityClicked() throws IOException {
    	CalculatorApp.loadDebtEquity();
    }
    
    public void currentRatioClicked() throws IOException {
    	CalculatorApp.loadCurrentRatio();
    }
   
    public void grossProfitClicked() throws IOException {
    	CalculatorApp.loadGrossProfit();
    }
    /**
     * Set the text of the PV OR FV label to the result work out fomr their respective functions
     * @param result
     */
    @FXML
    public void displayResult(double result) {
    	String resultString = ":"+result;
    	labelResult.setText(resultString);
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert moneyImageView != null : "fx:id=\"moneyImageView\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert hboxTop != null : "fx:id=\"hboxTop\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert pvImageView1 != null : "fx:id=\"pvImageView1\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert pvImageView != null : "fx:id=\"pvImageView\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert hboxButtonKey != null : "fx:id=\"hboxButtonKey\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert hboxLeft != null : "fx:id=\"hboxLeft\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
      
            
	    assert textFieldFV != null : "fx:id=\"textFieldFV\" was not injected: check your FXML file 'PV.fxml'.";
	    assert textFieldYears != null : "fx:id=\"textFieldYears\" was not injected: check your FXML file 'PV.fxml'.";
	    assert labelResult != null : "fx:id=\"labelResult\" was not injected: check your FXML file 'PV.fxml'.";
	    assert textFieldInterest != null : "fx:id=\"textFieldInterest\" was not injected: check your FXML file 'PV.fxml'.";
            

        

    }
}

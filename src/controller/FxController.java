package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Ratios;
import model.Ratios.CurrentRatio;
import model.Ratios.DebtEquityRatio;
import model.Ratios.GrossProfitMarginRatio;
import model.Ratios.WorkingCapitalRatio;
import model.Value.PresentValue;
import model.Value.FutureValue;
import model.Calculation;
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

    @FXML // fx:id="fvImageView"
    private ImageView fvImageView; // Value injected by FXMLLoader
    
    @FXML // fx:id="hboxButtonKey"
    private HBox hboxButtonKey; // Value injected by FXMLLoader

    @FXML // fx:id="hboxLeft"
    private VBox hboxLeft; // Value injected by FXMLLoader
    

    
    //****************************
    //textFields[1,2,3] from left to right 
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    
//    private TextField [] textFields = {textField1,textField2,textField3};
    
    //hidden error label[1,2,3] from left to right 
    @FXML
    private Label labelError1;
    
    @FXML
    private Label labelError2;
    
    @FXML
    private Label labelError3;
    
    
    Label [] labelErrors;
   
    
    /**
     * An instance of the class value.
     * Used to work out present and future value
     */
    Calculation value = new Calculation();

	private Label labelResult;

	
  
    /**
     * Submit inout from user to controller.
     * Then changes text to doubles and worksas out the present value.
     * @return double presentValue (or zero if no valid input)
     */
//    @FXML
//    public double submitPV() {
//    	boolean valid = true; // turns false when textFields are empty
//    	double futureValue = 0;
//    	double interestRate = 0;
//    	double n = 0;
//    	double pv = 0.0;
//    	
//    	//check if text fields are empty - if they are empty - they are not valid (valid = false)
//    	if (textFieldFV.getText().isEmpty()) {/*do something*/ System.out.println("textFieldFV is empty"); labelErrorFV.setVisible(true); valid = false;} // should show warning message (int textfield???) that will disappear when you enter new data
//    	
//    	if (textFieldInterest.getText().isEmpty()) {/*do something*/ System.out.println("textFieldInterest is empty"); labelErrorInterest.setVisible(true); valid = false;}
//    	
//    	if (textFieldYears.getText().isEmpty()) {/*do something*/System.out.println("textFieldYears is empty"); labelErrorYears.setVisible(true); valid = false;}
// 
//    	//check if they are valid (whether they contain text)
//    	if (valid) { 
//    		labelErrorFV.setVisible(false);//if valid - no longer display error label
//    		labelErrorInterest.setVisible(false);
//    		labelErrorYears.setVisible(false);
//    	
//    		try {
//    			futureValue = Double.parseDouble(textFieldFV.getText());
//    		}
//    		catch (Exception e) {
//    		labelErrorFV.setVisible(true);
//    		valid = false;
//    		}
//    		try {
//    			interestRate = Double.parseDouble(textFieldInterest.getText());
//    		}
//    		catch (Exception e) {
//    			labelErrorInterest.setVisible(true);
//    			valid = false;
//    		}
//    		try {
//    			n = Double.parseDouble(textFieldYears.getText());
//    		}
//    		catch (Exception e) {
//    			labelErrorYears.setVisible(true);
//    			valid = false;
//    		}
//    	
//    	if(valid) {
//    		pv = value.workOutPv(futureValue, interestRate, n);
//    		displayResult(pv);
//    		System.out.println("Future Value: "+futureValue + " Interest Rate: "+ interestRate + " Years: " + n + "\nPresent Value: " + pv);
//    	}
//    	
//    
//    	
//    	return	pv;
//    	}
//    	return 0.0;
//    }
//    
//    /**
//     * 
//     * @return double fv - future value (or 0.0 if no valid input is given)
//     */
//    @FXML
//    public double submitFV() {
//    	boolean valid = true; // turns false when textFields are empty
//    	double futureValue = 0.0;
//    	double interestRate = 0.0;
//    	double n = 0.0;
//    	double fv = 0.0;
//    	if (textFieldAmountInvested.getText().isEmpty()) {/*do something*/ System.out.println("textFieldFV is empty"); valid = false; labelErrorAmountInvested.setVisible(true);} // should show warning message (int textfield???) that will disappear when you enter new data
//    	if (textFieldInterest.getText().isEmpty()) {/*do something*/ System.out.println("textFieldInterest is empty");  valid = false; labelErrorInterest.setVisible(true);}
//    	if (textFieldYears.getText().isEmpty()) {/*do something*/System.out.println("textFieldYears is empty");  valid = false; labelErrorYears.setVisible(true);}
//    	
//    	if (valid) { 
//    		labelErrorAmountInvested.setVisible(false);
//    		labelErrorInterest.setVisible(false);
//    		labelErrorYears.setVisible(false);
////    		todo ...
////    		- synchronise variable names 
////    		- add fxml injectable variables to suit
////    		- followed the muster of the submit pv method ()also for conformity purposes
//    		
//    		try {
//    			futureValue = Double.parseDouble(textFieldAmountInvested.getText());
//    			
//    		}
//    		catch(Exception e) {
//    			labelErrorAmountInvested.setVisible(true);
//    			System.out.println("The submitFV textFieldAmountiNVESTEDfAILE");
//    		}
//    		
//    		try {
//    			interestRate = Double.parseDouble(textFieldInterest.getText());
//    		}
//    		catch (Exception e) {
//    			labelErrorInterest.setVisible(true);
//    			System.out.println("The submitFV Interest - try catch  failed ");
//    		}
//    		try {
//    			
//    			n = Double.parseDouble(textFieldYears.getText());
//    		}
//    		catch (Exception e) {
//    			labelErrorYears.setVisible(true);
//    			System.out.println("the submitFV - textFieldYears try catch failed");
//    			
//    		}
//    	try {
//    			fv = value.workOutPv(futureValue, interestRate, n);
//    	}
//    	catch (Exception e) {
//    		
//    	}
//    	displayResult(fv);
//    	System.out.println("Future Value: "+ textFieldAmountInvested + " Interest Rate: "+ interestRate + " Years: " + n + "\nPresent Value: " + fv);
//    	return	fv;
//    	}
//    	return 0.0;
//    }
//
//    @FXML
//    public double submitDebtEquityRatio() {
//    	boolean valid = true; // turns false when textFields are empty
//    	if (textFieldTotalDebt.getText().isEmpty()) {/*do something*/ System.out.println("textFieldTotalDebt is empty"); valid = false; labelErrorTotalDebt.setVisible(true);} // should show warning message (int textfield???) that will disappear when you enter new data
//    	if (textFieldTotalEquity.getText().isEmpty()) {/*do something*/ System.out.println("textFieldTotalEquity is empty"); valid = false; labelErrorTotalEquity.setVisible(true);}
//    	double totalDebt = 0.0;
//    	double totalEquity = 0.0;
//    	double debtEquityRatio = 0.0;
//    	
//    	if (valid) { 
//    		labelErrorTotalDebt.setVisible(false);
//    		labelErrorTotalEquity.setVisible(false);
//    		try {
//	    	totalDebt = Double.parseDouble(textFieldTotalDebt.getText());
//    		}
//    		catch (Exception e) {
//    			labelErrorTotalDebt.setVisible(true);
//    		}
//    		try {
//    			totalEquity = Double.parseDouble(textFieldTotalEquity.getText());
//    		}
//    		catch (Exception e) {
//    			labelErrorTotalEquity.setVisible(true);
//    		}
//    		
//	    	debtEquityRatio = Ratio.debtEquityRatio(totalDebt, totalEquity);
//	    	displayResult(debtEquityRatio);
//	    	System.out.println("Total Debt:"+ totalDebt + " Total Equity: "+ totalEquity + "\nDebt Equity Ratio: " + debtEquityRatio);
//	    	return	debtEquityRatio;
//    	}
//    	return 0.0;
//    }
//    
//    
//    public double submitCurrentRatio () {
//    	boolean valid = true; // turns false when textFields are empty
//    	if (textFieldCurrentAsset.getText().isEmpty()) {/*do something*/ System.out.println("textFieldCurrent is empty"); valid = false; labelErrorCurrentAsset.setVisible(true);} // should show warning message (int textfield???) that will disappear when you enter new data
//    	if (textFieldCurrentLiabilities.getText().isEmpty()) {/*do something*/ System.out.println("textFieldTotalEquity is empty"); valid = false; labelErrorCurrentLiabilities.setVisible(true);}
//    	double totalDebt = 0.0;
//    	double totalEquity = 0.0;
//    	double debtEquityRatio = 0.0;
//    	
//    	if (valid) { 
//    		//make validation error message disappear when..
//    		//...input is valid 
//    		labelErrorCurrentAsset.setVisible(false); 
//    		labelErrorCurrentLiabilities.setVisible(false);
//    		try {
//	    	totalDebt = Double.parseDouble(textFieldTotalDebt.getText());
//    		}
//    		catch (Exception e) {
//    			labelErrorTotalDebt.setVisible(true);
//    		}
//    		try {
//    			totalEquity = Double.parseDouble(textFieldTotalEquity.getText());
//    		}
//    		catch (Exception e) {
//    			labelErrorTotalEquity.setVisible(true);
//    		}
//    		
//	    	debtEquityRatio = Ratio.debtEquityRatio(totalDebt, totalEquity);
//	    	displayResult(debtEquityRatio);
//	    	System.out.println("Total Debt:"+ totalDebt + " Total Equity: "+ totalEquity + "\nDebt Equity Ratio: " + debtEquityRatio);
//	    	return	debtEquityRatio;
//    	}
//    	return 0.0;
//    }
//    
//    public double submitWorkingCapital () {
//    	boolean valid = true;
//    	if (textFieldCurrentAsset.getText().isEmpty()) {/*do something*/ System.out.println("textFieldCurrentAsset is empty");  valid = false; } // should show warning message (int textfield???) that will disappear when you enter new data
//    	if (textFieldCurrentLiabilities.getText().isEmpty()) {/*do something*/ System.out.println("textFieldCurrentLiabilities is empty");  valid = false;}
//    	if (valid) {
//    	double currentAsset = Double.parseDouble(textFieldCurrentAsset.getText());
//    	double currentLiabilities = Double.parseDouble(textFieldCurrentLiabilities.getText());
//    	double workingCapital = Ratio.workingCaptialRatio(currentAsset, currentLiabilities);
//    	return workingCapital;
//    	}
//    	return 0.0;
//    }
//    
    
    public double submitFV () {
    	Calculation futureValue = new FutureValue();
    	return submit(futureValue, textField1,textField2,textField3);
    }
    public double submitPV () {
    	Calculation presentValue = new PresentValue();
    	return submit(presentValue, textField1,textField2,textField3 );
    }
    public double submitCurrentRatio () {
    	Calculation currentRatio = new CurrentRatio();
    	return submit(currentRatio, textField1,textField2,textField3 );
    }
    public double submitWorkingCapital () {
    	Calculation workingCapital = new WorkingCapitalRatio();
    	return submit(workingCapital, textField1,textField2,textField3 );
    }
    
    public double submitDebtEquity () {
    	Calculation debtEquity = new DebtEquityRatio();
    	return submit(debtEquity, textField1,textField2,textField3 );
    }
    
    public double submitGrossProfit () {
    	Calculation grossProfit = new GrossProfitMarginRatio();
    	return submit(grossProfit, textField1,textField2,textField3 );
    }
    /**
     * A more generic submit function.
     * A allows the code to be less dense
     * ...makes it also easier to extend functionality later on
     * as submit will just need the field and not a whole new function 
     * each time.
     * @param textFields
     * @return
     */
    public double submit(Calculation calculation , TextField ...textFields) {
    	int errorLabelNum = 0;
    	double totalDebt = 0.0;
    	double totalEquity = 0.0;
    	double debtEquityRatio = 0.0;
    	int valCount = 0;
    	//for loop checks each field so see if it has valid input
    	//error labels appear if text is not valid
    	//checks one textField at a time and decides if valid or not
    	for (TextField  textField: textFields ){
    	// turns false when textFields are empty - needs to stay in the loop
    	boolean valid = true; 
    	// should show warning message (int textfield???) that will disappear when you enter new data
    	if (textField.getText().isEmpty()) {/*do something*/ System.out.println(textField.getId()+" is empty"); valid = false; labelErrors[errorLabelNum].setVisible(true); }
    	if (valid) { 
    		valCount++;
    		//make validation error message disappear when..
    		//...input is valid 
    		labelErrors[errorLabelNum].setVisible(false);
    		try {
	    	totalDebt = Double.parseDouble(textField.getText());
    		}
    		catch (Exception e) {
    			labelErrors[errorLabelNum].setVisible(true);
    		}
    	}
    	//incerement errorNum in prep to set next error message visible
    	//if box has error
    	errorLabelNum++;
    	}//end of for loop
    	//if all textFields are valid - calculate
    	if (valCount == errorLabelNum) {
    	debtEquityRatio = calculation.performCalc(totalDebt, totalEquity);
    	displayResult(debtEquityRatio);
    	System.out.println("Total Debt:"+ totalDebt + " Total Equity: "+ totalEquity + "\nDebt Equity Ratio: " + debtEquityRatio);
    	}
    	return	debtEquityRatio;
    }
    
    public double submitDebtGrossProfit() {
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
//        assert pvImageView1 != null : "fx:id=\"pvImageView1\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert pvImageView != null : "fx:id=\"pvImageView\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert hboxButtonKey != null : "fx:id=\"hboxButtonKey\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
        assert hboxLeft != null : "fx:id=\"hboxLeft\" was not injected: check your FXML file 'CalculatorMain.fxml'.";
 
	    assert labelResult != null : "fx:id=\"labelResult\" was not injected: check your FXML file 'PV.fxml'.";
	    assert labelError1 != null : "fx:id=\"labelError1\" was not injected: check your FXML file 'PV.fxml'.";
	    assert labelError2 != null : "fx:id=\"labelError2\" was not injected: check your FXML file 'PV.fxml'.";
	    assert labelError3 != null : "fx:id=\"labelError3\" was not injected: check your FXML file 'PV.fxml'.";
	    assert textField1  != null : "fx:id=\"textField1\" was not injected: check your FXML file 'PV.fxml'.";
	    assert textField2  != null : "fx:id=\"textField1\" was not injected: check your FXML file 'PV.fxml'.";
	    assert textField3  != null : "fx:id=\"textField1\" was not injected: check your FXML file 'PV.fxml'.";

	    //at the point of initialisation - fxml objects are injected 
	    //at this point labelErrors can be initialised with the injected labels
	    labelErrors = new Label [] {labelError1,labelError2,labelError3};
    }
}

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import model.Ratios.CurrentRatio;
import model.Ratios.DebtEquityRatio;
import model.Ratios.GrossProfitMarginRatio;
import model.Ratios.WorkingCapitalRatio;
import model.Values.PresentValue;
import model.Values.FutureValue;
import model.Calculation;
import view.CalculatorApp;

/**
 * The FxController Class - used to handler events from fxml scenes
 * @author zacharyishmael
 *
 */
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
    
    Label [] labelErrors;//needed for submit function
   
    @FXML
	private Label labelResult;
	
	/**
	 * submit function applied to Future Value.
	 * @return
	 */
    public double submitFV () {
    	Calculation futureValue = new FutureValue();
    	return submit(futureValue, textField1,textField2,textField3);
    }
    
    /**
	 * submit function applied to Present Value.
	 * @return
	 */
    public double submitPV () {
    	Calculation presentValue = new PresentValue();
    	return submit(presentValue, textField1,textField2,textField3 );
    }
    
    /**
	 * submit function applied to CurrentRatio
	 * @return
	 */
    public double submitCurrentRatio () {
    	Calculation currentRatio = new CurrentRatio();
    	return submit(currentRatio, textField1,textField2);
    }
    
    /**
	 * submit function applied to Working Capital
	 * @return
	 */
    public double submitWorkingCapital () {
    	Calculation workingCapital = new WorkingCapitalRatio();
    	return submit(workingCapital, textField1,textField2);
    }
    
    /**
	 * submit function applied to Debt Equity
	 * @return
	 */
    public double submitDebtEquityRatio () {
    	Calculation debtEquity = new DebtEquityRatio();
    	return submit(debtEquity, textField1,textField2);
    }
    
    /**
	 * submit function applied to Gross Profit
	 * @return
	 */
    public double submitGrossProfit () {
    	Calculation grossProfit = new GrossProfitMarginRatio();
    	return submit(grossProfit, textField1,textField2);
    }
    /**
     * A more generic submit function - a basis all other submitFunctions.
     * It allows the code to be less dense than first approach - more heavily OOP this time
     * ...makes it also easier to extend functionality later on
     * as submit will just need the field and not a whole new function 
     * each time.
     * @param calculation
     * @param textFields
     * @return not needed, but there if ever reqiured (e.g for persistence)
     */
    public double submit(Calculation calculation , TextField ...textFields) {
    	double result = 0.0;
//    	boolean valid = true;
    	int errorLabelNum = 0;
    	double [] vars = new double [textFields.length];
    	int textCount = 0; 
    	int valCount = 0;
    	//for loop checks each field so see if it has valid input
    	//error labels appear if text is not valid
    	//checks one textField at a time and decides if valid or not
    	for (TextField  textField: textFields ){
    	// turns false when textFields are empty - needs to stay in the loop
    	boolean hasText = true; 
    	// should show warning message (int textfield???) that will disappear when you enter new data
    	if (textField.getText().isEmpty()) {/*do something*/ System.out.println(textField.getId()+" is empty"); hasText = false; labelErrors[errorLabelNum].setVisible(true);}
    	
    	//make validation error message disappear when..
		//...input is valid 
    	if (hasText) { 
    		textCount++;
    		//hides error message (if it has been already visible)
    		labelErrors[errorLabelNum].setVisible(false);
    		try {
	    	vars[errorLabelNum] = Double.parseDouble(textField.getText());
	    	valCount++;//vaildationCounter - how many fields are valid numbers
    		}
    		catch (Exception e) {
    			labelErrors[errorLabelNum].setVisible(true);
    		}
    	}
    	//incerement errorNum in prep to set next error message visible
    	errorLabelNum++;
    	}//end of for loop
    	//if all textFields are valid - calculate
    	System.out.println("textCount="+textCount + "/"+ errorLabelNum +"  valCount="+ valCount + "/"+ errorLabelNum  +"  totalFieldsChecked= " + errorLabelNum+ "/"+textFields.length);
    	if (valCount == errorLabelNum) {//if all three have text && are valid doubles (numbers) proceed
    	result = calculation.performCalc(vars);
    	displayResult(result);
    	System.out.println(calculation.getName()+"="+result);
    	}
    	return	result;
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
    
    /**
     * Changes the view to CaptialWork
     * @throws IOException
     */
    public void workingCapitalClicked() throws IOException {
    	CalculatorApp.loadCapitalWork();
    }
    
    /**
     * Changes the view to Debt Equity
     * @throws IOException
     */
    public void debtEquityClicked() throws IOException {
    	CalculatorApp.loadDebtEquity();
    }
    
    /**
     * Changes the view to Current Ratio Clicked
     * @throws IOException
     */
    public void currentRatioClicked() throws IOException {
    	CalculatorApp.loadCurrentRatio();
    }
   
    /**
     * Changes the view to Gross Profit Clicked
     * @throws IOException
     */
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

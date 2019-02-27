package model;
/**
 * A class used to work out the present and future value
 * of a given amount over time.
 * @author zacharyishmael
 *
 */

public class Value {


	 /**
	  * Present Value = Future Value/ (1+Interest_Rate)N
	  */
	
	public double workOutPv(double futureValue, double interestRate, double n) {
	 double pv = futureValue/Math.pow((1+interestRate), n);
	 return pv;
 }
 
	/**
	 * Future Value = Amount Invested * (1+Interest_Rate)N
	 */

	public double workOutFv(double amountInvested, double interestRate, double n) {
	double fv = amountInvested*Math.pow((1+interestRate), n);
	return fv;
}

}

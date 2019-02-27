package controller;
/**
 * This class will be used to provide the ratio and formulas
 * business logic that wil be needed to run the 
 * CalculatorApp.
 * @author zacharyishmael
 *
 */
public class Ratio {

	/**
	 * Method to find out currentRatio
	 * @param currentAsset - the assest currently available 
	 * @param currentLiabilities - the liabilities of the present time
	 * @return double currentRatio - a liquidity ratio to measure the ability to meet short term liabilities 
	 */
	public double currentRatio(double currentAsset, double currentLiabilities) {
		double currentRatio = currentAsset / currentLiabilities;
		return currentRatio;
	}
	
	/**
	 * Used to work out the working capital ratio
	 * @param currentAsset - all the assets you presently posses
	 * @param currentLiabilities - all the liabilities you presently have
	 * @return double workingCaptialRatio - the result of cA - cL
	 */
	public static double workingCaptialRatio(double currentAsset, double currentLiabilities) {
		double workingCapitalRatio = currentAsset - currentLiabilities;
		return workingCapitalRatio;
	}
	
	/**
	 * Used to work out the Debt Equity given the following parmeters.
	 * @param totalDebt
	 * @param totalEquity
	 * @return double debtEquity - a solvency ratio (shows ability to meet long term obligations)
	 */
	public static double debtEquityRatio(double totalDebt, double totalEquity) {
		double debtEquity = totalDebt/totalEquity;
		return debtEquity;
	}
	
	/**
	 * Used to work out the Gross Profit Margin
	 * @param grossProfit - overall profit 
	 * @param revenue - all income
	 * @return double grossProfitMarginRatio - the 
	 */
	public double grossProfitMarginRatio(double grossProfit, double revenue) {
		double grossProfitMarginRatio = grossProfit / revenue;
		return grossProfitMarginRatio;
	}
}

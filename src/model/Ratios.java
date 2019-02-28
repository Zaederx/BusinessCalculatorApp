package model;
/**
 * This class will be used to provide the ratio business logic / formulas.
 * It contains methods that hide's [similiar to overriding] the top-most SuperClass's Method: Caclculation.performCalc().
 * The classes nested inside of of Ratios contain their on specific implementation
 * of the performCalc method.
 *  business logic that wil be needed to run the 
 * This allows methods to accept many specific calculations under SuperClass of Calculation.
 * <h5> see FxController.submit() </h5>
 * @author zacharyishmael
 *
 */
public class Ratios extends Calculation {
		
	public static class CurrentRatio extends Ratios {
		
		/**
		 * @param vars - double [] vars = new double {currentAsset, currentLiabilties}
		 * @return
		 */
		public double performCalc(double ...vars) {
			double cA = vars[0]; //currentAsset
			double cL = vars[1]; //currentLiabilities
			return currentRatio(cA,cL);
		}
		/**
		 * Method to find out currentRatio
		 * @param currentAsset - the assest currently available 
		 * @param currentLiabilities - the liabilities of the present time
		 * @return double currentRatio - a liquidity ratio to measure the ability to meet short term liabilities 
		 */
		public static double currentRatio(double currentAsset, double currentLiabilities) {
		double currentRatio = currentAsset / currentLiabilities;
		return currentRatio;
		}
	}
		//*************************************************
		
	public static class WorkingCapitalRatio extends Ratios {
		/**
		 * Specific case of performCalc 
		 * @param vars -double [] vars = new double {currentAsset, currentLiabilties}
		 * @return
		 */
		public  double performCalc(double ...vars) {
			double cA = vars[0]; //currentAsset
			double cL = vars[1]; //currentLiabilities
			return workingCapitalRatio(cA,cL);
		}
		/**
		 * Used to work out the working capital ratio
		 * @param currentAsset - all the assets you presently posses
		 * @param currentLiabilities - all the liabilities you presently have
		 * @return double workingCaptialRatio - the result of cA - cL
		 */
		public static double workingCapitalRatio(double currentAsset, double currentLiabilities) {
			double workingCapitalRatio = currentAsset - currentLiabilities;
			return workingCapitalRatio;
			}
		}
	//*************************************************
	
	public static class DebtEquityRatio extends Ratios {
		
		/**
		 * A specific implementation of SuperClassperformCal
		 * @param vars - double [] vars = new double {totalDebt, totalEquity}
		 * @return
		 */
		public double performCalc(double ...vars) {
			double totalDebt = vars[0]; //currentAsset
			double totalEquity = vars[1]; //currentLiabilities
			return debtEquityRatio(totalDebt,totalEquity);
		}
	/**
	 * Used to work out the Debt Equity given the following parameters.
	 * @param totalDebt
	 * @param totalEquity
	 * @return double debtEquity - a solvency ratio (shows ability to meet long term obligations)
	 */
	public static double debtEquityRatio(double totalDebt, double totalEquity) {
		double debtEquity = totalDebt/totalEquity;
		return debtEquity;
		}
	}
	//*************************************************
	/**
	 * Subclass of Ratios.
	 * Provides specific implementation of performCalc that hides [i.e. similar to overrides] performCalc()
	 * @author zacharyishmael
	 *
	 */
	public static class GrossProfitMarginRatio extends Ratios {
		public  double performCalc(double ...vars) {
			double totalDebt = vars[0]; //currentAsset
			double totalEquity = vars[1]; //currentLiabilities
			return grossProfitMarginRatio(totalDebt,totalEquity);
		}
	/**
	 * Used to work out the Gross Profit Margin
	 * @param grossProfit - overall profit 
	 * @param revenue - all income
	 * @return double grossProfitMarginRatio - the 
	 */
	public static double grossProfitMarginRatio(double grossProfit, double revenue) {
		double grossProfitMarginRatio = grossProfit / revenue;
		return grossProfitMarginRatio;
		}
	}
}

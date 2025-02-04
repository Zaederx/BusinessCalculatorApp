package model;
/**
 * This class will be used to provide the ratio business logic / formulas.
 * It contains classes with methods that override the top-most SuperClass's Method: Caclculation.performCalc().
 * The classes nested inside of of Ratios contain their on specific implementation
 * of the performCalc method.
 * 
 * This allows methods to accept many specific calculations under SuperClass of Calculation.
 * <h5> see FxController.submit() </h5>
 * @author zacharyishmael
 *
 */
public class Ratios extends Calculation {
		
	/**Subclass of Ratios.
	 * Class to help perform Cuurent Ratio calculation
	 * @author zacharyishmael
	 *
	 */
	public static class CurrentRatio extends Ratios {
		
		String name = "CurrentRatio";
		/**Overrides the Calculation performCalc(double ...doubles) method
		 * @param vars - double [] vars = new double {currentAsset, currentLiabilties}
		 * @return
		 */
		@Override //so that compiler alerts should the 
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
		
		/**Returns the name of the Calculation.
		 * @return String - name of the calculation being performed
		 * (specific calculation subclass name)
		 */
		public String getName() {
			return name;
		}
	}
		//*************************************************
		
	/**
	 * Subclass of Ratios.
	 * Class to help perform Working Capital Ratio calculation
	 * @author zacharyishmael
	 *
	 */
	public static class WorkingCapitalRatio extends Ratios {
		String name = "WorkingCapitalRatio";
		/**
		 * Specific case of performCalc 
		 * @param vars -double [] vars = new double {currentAsset, currentLiabilties}
		 * @return
		 */
		@Override
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
		/**Returns the name of the Calculation.
		 * @return String - name of the calculation being performed
		 * (specific calculation subclass name)
		 */
		public String getName() {
			return name;
		}
		}
	//*************************************************
	
	/**
	 * Subclass of Ratios.
	 * Class to help perform Debt Equity Ratio calculation
	 * @author zacharyishmael
	 *
	 */
	public static class DebtEquityRatio extends Ratios {
		String name = "DebtEquityRatio";
		/**
		 * A specific implementation of SuperClassperformCal
		 * @param vars - double [] vars = new double {totalDebt, totalEquity}
		 * @return
		 */
		@Override
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
		
		/**Returns the name of the Calculation.
		 * @return String - name of the calculation being performed
		 * (specific calculation subclass name)
		 */
		public String getName () {
			return name;
		}
	}
	//*************************************************
	/**
	 * Subclass of Ratios.
	 * Class to help perform Gross Profit Margin calculation
	 * @author zacharyishmael
	 *
	 */
	public static class GrossProfitMarginRatio extends Ratios {
		String name = "GrossProfitMarginRatio";
		
		@Override
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
		/**Returns the name of the Calculation.
		 * @return String - name of the calculation being performed
		 * (specific calculation subclass name)
		 */
		public String getName () {
			return name;
		}
	}
}

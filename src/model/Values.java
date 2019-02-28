package model;

public class Values extends Calculation {
	
	public static class PresentValue extends Values{
	
		public static double performCalc(double d1, double d2, double n) {
			return workOutPV(d1,d2,n);
		}
		/**
		 * Present Value = Future Value/ (1+Interest_Rate)N
		 */
		public static double workOutPV(double futureValue, double interestRate, double n) {
		 double pv = futureValue/Math.pow((1+interestRate), n);
		 return pv;
		}
	}
	
	public static class FutureValue extends Values {
		
		public static double performCalc(double d1, double d2,double n) {
			return workOutFV(d1,d2,n);
		}
		/**
		 * Future Value = Amount Invested * (1+Interest_Rate)N
		 */
	
		public static double workOutFV(double amountInvested, double interestRate, double n) {
		double fv = amountInvested*Math.pow((1+interestRate), n);
		return fv;
		}
	}
}

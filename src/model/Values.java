package model;

public class Values extends Calculation {
	
	public static class PresentValue extends Values{
	
		String name = "PresentValue";
		/**
		 * @param fv - future Value
		 * @param rate - interestRate
		 * @param n	- number of years
		 * @return
		 */
		@Override
		public double performCalc(double ...vars) {
			double fv = vars[0];
			double rate = vars[1];
			double n = vars[2];
			return workOutPV(fv,rate,n);
		}
		/**
		 * Present Value = Future Value/ (1+Interest_Rate)N
		 */
		public double workOutPV(double futureValue, double interestRate, double n) {
		 double pv = futureValue/Math.pow((1+interestRate), n);
		 System.out.println("futureValue:"+ futureValue + " interestRate: "+ interestRate + "\nYears: " + n+"\nPresentValue: " + pv);
		 return pv;
		}
		
		/**Returns the name of the Calculation.
		 * @return String - name of the calculation being performed
		 * (specific calculation subclass name)
		 */
		@Override
		public String getName() {
			return name;
		}
	}
	
	public static class FutureValue extends Values {
		
		String name = "FutureValue";
		/**
		 * Function 
		 * @param vars - an array containing amountInvested at vars[0], 
		 * interestRate vars[2] 
		 * and n (the number of year) vars[3]
		 * @return
		 */
		@Override
		public double performCalc(double ...vars) {
			double amount = vars[0];
			double rate = vars[1];
			double n = vars[2];
			return workOutFV(amount,rate,n);
		}
		
		/**
		 * Future Value = Amount Invested * (1+Interest_Rate)N
		 */
		public double workOutFV(double amountInvested, double interestRate, double n) {
		double fv = amountInvested*Math.pow((1+interestRate), n);
		System.out.println("amountInvested"+ amountInvested + " interestRate: "+ interestRate + "\nYears: " + n + "FutureValue: "+fv);
		return fv;
		}
		
		/**Returns the name of the Calculation.
		 * @return String - name of the calculation being performed
		 * (specific calculation subclass name)
		 */
		public String getName() {
			return name;
		}
	}
}

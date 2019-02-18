package controller;
/**
 * A class used to work out the present and future value
 * of a given amount over time.
 * @author zacharyishmael
 *
 */

public class Value {

/**
 * pv = present value
 * 
 */
 double pv = 0.0;
 
 /**
  * fv = future value
  */
 double fv = 0.0;

/* returns pv
 * @return double pv = present value
 */
public double getPv() {
	return pv;
}

/**
 * sets the value of pv.
 * @param pv
 */
public void setPv(double pv) {
	this.pv = pv;
}

/**
 * returns the value of pv.
 * @return int fv - future value
 */
public double getFv() {
	return fv;
}

/**
 * sets the value of fv.
 * @param fv - future value
 */
public void setFv(double fv) {
	this.fv = fv;
}
 
 
}

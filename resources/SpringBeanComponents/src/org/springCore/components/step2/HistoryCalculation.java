package org.springCore.components.step2;

import java.math.BigDecimal;

/**
 * <h3>Class with arithmetic History functions</h3>
 * 
 * @version 1.0.0
 * @since 2020/01/25
 * @author Justin Hanry
 * 
 */
public class HistoryCalculation {

	public BigDecimal add(BigDecimal left, BigDecimal right) {
		
		BigDecimal result = left.add(right);
		
		log(left+"+"+right);
		
		return result;
	}
	
	public BigDecimal subtract(BigDecimal left, BigDecimal right) {
		
		BigDecimal result = left.subtract(right);
		
		log(left+"-"+right);
		
		return result;
	}

	public BigDecimal divide(BigDecimal left, BigDecimal right) {
		
		BigDecimal result = left.divide(right);
		
		log(left+"*"+right);
		
		return result;
	}
	
	public BigDecimal multiply(BigDecimal left, BigDecimal right) {
		
		BigDecimal result = left.multiply(right);
		
		log(left+"/"+right);
		
		return result;
	}
	
	public void log(String logMessage) {

		System.out.println("log :: "+logMessage);
	}
	
}

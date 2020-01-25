package org.springCore.components.step1;

import java.math.BigDecimal;

/**
 * <h3>Class with arithmetic functions</h3>
 * 
 * @version 1.0.0
 * @since 2020/01/25
 * @author Justin Hanry
 * 
 */
public class Calculation {

	public BigDecimal add(BigDecimal left, BigDecimal right) {
		
		BigDecimal result = left.add(right);
		
		return result;
	}
	
	public BigDecimal subtract(BigDecimal left, BigDecimal right) {
		
		BigDecimal result = left.subtract(right);
		
		return result;
	}

	public BigDecimal divide(BigDecimal left, BigDecimal right) {
		
		BigDecimal result = left.divide(right);
		
		return result;
	}
	
	public BigDecimal multiply(BigDecimal left, BigDecimal right) {
		
		BigDecimal result = left.multiply(right);
		
		return result;
	}
	
}

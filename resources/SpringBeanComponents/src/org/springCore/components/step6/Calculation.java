package org.springCore.components.step6;

import java.math.BigDecimal;

/**
 * <h3>Class with arithmetic Interface</h3>
 * 
 * @version 1.0.0
 * @since 2020/01/25
 * @author Justin Hanry
 * 
 */
public interface Calculation {

	public BigDecimal add(BigDecimal left, BigDecimal right);
	public BigDecimal subtract(BigDecimal left, BigDecimal right);
	public BigDecimal divide(BigDecimal left, BigDecimal right);
	public BigDecimal multiply(BigDecimal left, BigDecimal right);
	
}

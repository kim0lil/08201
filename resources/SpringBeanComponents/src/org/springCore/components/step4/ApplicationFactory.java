package org.springCore.components.step4;

/**
 * <h3>Application factory to manage dependencies</h3>
 * 
 * @version 1.0.0
 * @since 2020/01/25
 * @author Justin Hanry
 * 
 */
public class ApplicationFactory {

	public static Calculator getCalculator() {

		return new Calculator(new SimpleCalculation());
	}
}

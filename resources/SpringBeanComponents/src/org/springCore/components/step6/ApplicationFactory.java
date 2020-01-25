package org.springCore.components.step6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <h3>Application factory to manage dependencies</h3>
 * 
 * @version 1.0.0
 * @since 2020/01/25
 * @author Justin Hanry
 * 
 */

public class ApplicationFactory {

	@Bean
	public Calculator getCalculator() {

		return new Calculator(new SimpleCalculation());
	}
}

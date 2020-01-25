package org.springCore.components.step6;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <h3>Calculator that takes inputs and calculates two values ​​using a calculation function</h3>
 * 
 * @version 1.0.0
 * @since 2020/01/25
 * @author Justin Hanry
 */

/** updated -> registration @Component annotation */ 
@Component
public class Calculator {
	
	/** Class to use calculation function : not Choice */
	private Calculation calculation;
	
	/** input-stream to receive input : accepts standard console input of System */
	private Scanner input;

	/** Dependencies are externally injected */
	public Calculator(Calculation calculation) {
		this.calculation = calculation;
		this.input       = new Scanner(System.in);
	}

	public static void main(String[] args) {

		// 1. register the bean using the context.
		AnnotationConfigApplicationContext context
			= new AnnotationConfigApplicationContext(ApplicationFactory.class);
		
		// 2. the dependency is set to retrieve the registered bean.
		
		// updated -> 2-1. Type reference 
		//Calculator calculator = (Calculator)context.getBean(Calculator.class);
		
		// updated -> 2-2. Name reference
		//Calculator calculator = (Calculator)context.getBean("getCalculator");
		
		// 2updated -> -3. Name && Type reference
		Calculator calculator = context.getBean("getCalculator", Calculator.class);
		
		calculator.on();
		calculator.off();
	}

	/**
	 * ---------------------------------
	 * Function to handle two operators
	 * ---------------------------------
	 * 1+1
	 * 2
	 * +3
	 * 5
	 * -1
	 * 4
	 * *2
	 * 8
	 * /4
	 * 2
	 * C
	 * 0
	 * exit
	 * 0
	 * ---------------------------------
	 */
	public void on() {
		String command;
		
		command = "start:";
		String[] mem;
		BigDecimal regist = BigDecimal.ZERO; 
		
		while(!command.equals("exit")) {
			
			command = this.input.nextLine();

			if(1==0) {}
			
			else if(command.contains("C")) {
				regist = BigDecimal.ZERO; 
			}
				
			else if(command.contains("+")) {
				mem = command.split("\\+");
				
				if(command.startsWith("+")) {
				
					regist = calculation.add(regist, new BigDecimal(mem[1]));
				} else {

					regist = calculation.add(new BigDecimal(mem[0]), new BigDecimal(mem[1]));
				}
			}
			else if(command.contains("-")) {
				mem = command.split("\\-");
				
				if(command.startsWith("-")) {
					
					regist = calculation.subtract(regist, new BigDecimal(mem[1]));
				} else {

					regist = calculation.subtract(new BigDecimal(mem[0]), new BigDecimal(mem[1]));
				}
			}
			else if(command.contains("*")) {
				mem = command.split("\\*");
				
				if(command.startsWith("*")) {
					
					regist = calculation.multiply(regist, new BigDecimal(mem[1]));
				} else {

					regist = calculation.multiply(new BigDecimal(mem[0]), new BigDecimal(mem[1]));
				}
			}
			else if(command.contains("/")) {
				mem = command.split("\\/");
				
				if(command.startsWith("/")) {
					
					regist = calculation.divide(regist, new BigDecimal(mem[1]));
				} else {

					regist = calculation.divide(new BigDecimal(mem[0]), new BigDecimal(mem[1]));
				}
			}
			
			System.out.println(regist.toPlainString());
		}
		
	}

	
	/**
	 * return the resources used by the system.
	 */
	public void off() {
		
		this.input.close();
	}
	
	
}

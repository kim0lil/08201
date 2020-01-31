package org.springCore.components.step7;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.annotation.Resource;

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
	
	/** updated -> registration @Resource Annotation and name of component to use */
	@Resource(name = "SimpleCalculation")
	private Calculation calculation;
	
	/** input-stream to receive input : accepts standard console input of System */
	private Scanner input;

	/** Dependencies are externally injected */
	public Calculator() {
		this.input       = new Scanner(System.in);
	}

	public static void main(String[] args) {

		// 1. register the bean using the context.
		AnnotationConfigApplicationContext context
			= new AnnotationConfigApplicationContext(ApplicationFactory.class);
		
		// 2. the dependency is set to retrieve the registered bean.
		Calculator calculator = (Calculator)context.getBean(Calculator.class);
		
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

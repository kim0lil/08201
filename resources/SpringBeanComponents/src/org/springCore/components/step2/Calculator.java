package org.springCore.components.step2;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * <h3>Calculator that takes inputs and calculates two values ​​using a calculation function</h3>
 * 
 * @version 1.0.0
 * @since 2020/01/25
 * @author Justin Hanry
 */
public class Calculator {
	
	/** updated -> Class to use calculation function : only (new HistoryCalculation()) */
	private HistoryCalculation calculation = new HistoryCalculation();
	
	/** input-stream to receive input : accepts standard console input of System */
	private Scanner input;
	
	public Calculator() {
		this.input = new Scanner(System.in);
	}

	public static void main(String[] args) {

		Calculator calculator = new Calculator();

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

package aop.around;

import org.springframework.stereotype.Component;

@Component
public class Addition {

	private int result = 0;
	
	public int addition(int left, int right) {

		this.result += (left + right);

		return this.result;
	}
}

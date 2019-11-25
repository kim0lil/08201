package aop.afterReturning;

import org.springframework.stereotype.Component;

@Component
public class Arithmetics {
	
	private int result;
	
	public int arithmetics(int x, int y, int z) {
		return (result = x + y + z);
	}

	public int getResult() {
		return result;
	}
}

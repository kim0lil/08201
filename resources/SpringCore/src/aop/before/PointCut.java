package aop.before;

import org.springframework.stereotype.Component;

@Component
public class PointCut {

	public int add(int left, int right) {
		return left + right;
	}
	
	public int sub(int left, int right) {
		return left - right;
	}
}

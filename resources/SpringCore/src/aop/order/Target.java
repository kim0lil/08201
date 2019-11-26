package aop.order;

import org.springframework.stereotype.Component;

@Component
public class Target {
	
	// Aspect를 실행항 지점
	public int result(int a) {
		return a;
	}
}

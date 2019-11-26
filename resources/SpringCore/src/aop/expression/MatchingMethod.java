package aop.expression;

import org.springframework.stereotype.Component;

@Component
public class MatchingMethod {
	
	public void method_1_run(ParamsObject o) {
		System.out.println("[MatchingMethod] method_1_Run is run");
	}
	
	public void method_2_run() {
		System.out.println("[MatchingMethod] method_2_Run is run");
	}
}

package aop.expression;

import org.springframework.stereotype.Component;

@Component
public class MatchingType {
	
	public void method_1_run(ParamsObject o) {
		System.out.println("[MatchingType] method_1_Run is run");
	}
	
	public void method_2_run() {
		System.out.println("[MatchingType] method_2_Run is run");
	}
}

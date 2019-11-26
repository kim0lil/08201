package aop.joinpoint;

import org.springframework.stereotype.Component;

@Component
public class Target {
	
	// 타겟이 될 조인포인트
	public int artMaker(int art, int pan) {
		
		return art + pan;
	}
	
	public void log(String message) {
		System.out.println(message+" resolvation target");
	}
}

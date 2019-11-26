package aop.expression;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {

	@Before("aop.expression.PointCut.method_1()")
	public void boforeAdvice_1() {
		System.out.println("<-- boforeAdvice_1");
	}
	
	@Before("aop.expression.PointCut.method_2()")
	public void boforeAdvice_2() {
		System.out.println("<-- boforeAdvice_2");
	}
	
	@Before("aop.expression.PointCut.type_1()")
	public void boforeAdvice_3() {
		System.out.println("<-- boforeAdvice_3");
	}
	
	@Before("aop.expression.PointCut.type_2()")
	public void boforeAdvice_4() {
		System.out.println("<-- boforeAdvice_4");
	}
	
	@Before("aop.expression.PointCut.mix_1()")
	public void boforeAdvice_5() {
		System.out.println("<-- boforeAdvice_5");
	}
	
	@Before("aop.expression.PointCut.mix_2()")
	public void boforeAdvice_6() {
		System.out.println("<-- boforeAdvice_6");
	}
	
	// 7. 파라미터를 참고 하여 처리
	@Before("aop.expression.PointCut.method_1() && args(o) && target(t)")
	public void boforeAdvice_7(Object o, Object t) {
		System.out.println("<-- boforeAdvice_7");
		System.out.println("--> { arguments : "+((ParamsObject)o).getValue()+" } and { target : +"+t+" } ");
	}
}

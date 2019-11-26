package aop.expression;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCut {
	
	// execution(*[반환값] *[전체매핑] ..[하위 패키지까지 전체 매핑] (파라미터 [int,String, ..[전체매핑]) 
	
	// 1. 파라미터를 사용하여 매칭
	@Pointcut("execution(* *.*(aop.expression.ParamsObject))")
	public void method_1() {}
	
	// 2. return값과 패키지 명을 사용하여 매칭
	@Pointcut("execution(void aop..method_2_run())")
	public void method_2() {}
	
	// 3. 클래스를 사용하여 매칭
	@Pointcut("within(aop.expression.MatchingType)")
	public void type_1() {}
	
	// 4. 클래스를 명칭을 사용하여 매칭
	@Pointcut("within(MatchingType)")
	public void type_2() {}
	
	// 5. 메소드 시그니처와 타입 시그니쳐를 믹싱하여 매핑 (or)
	@Pointcut("execution(* *.*()) || within(MatchingType)")
	public void mix_1() {}
	
	// 6. 메소드 시그니처와 타입 시그니쳐를 믹싱하여 매핑 (and)
	@Pointcut("within(MatchingType) && execution(* *.*())")
	public void mix_2() {}
	
	// 7. 파라미터를 참고 하는 방식은 Advice에서 계속 

}

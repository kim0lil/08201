package aop.joinpoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JoinpointInformation {
	
	@Pointcut("execution(* *.*(int,int))")
	public void pointcut() {}

	@Before("pointcut()")
	public void beforeAdvice(JoinPoint joinPoint) {

		showArguments(joinPoint.getArgs());        // 1
		showPointCutKind(joinPoint.getKind());     // 2
		showTarget((Target)joinPoint.getTarget()); // 3
		showSignature(joinPoint.getSignature());   // 4
	}
	

	// Around의 시그니쳐는 모두 동일하지만 실행가능한 기능이 추가로 있습니다.
	@Around("pointcut()")
	public Object aroundAdviceInformation(ProceedingJoinPoint joinPoint) throws Throwable {

		showArguments(joinPoint.getArgs());             // 1
		showPointCutKind(joinPoint.getKind());          // 2
		showTarget((Target)joinPoint.getTarget());      // 3
		showSignature(joinPoint.getSignature());        // 4
		
		return showReturningValue(joinPoint.proceed()); // 5
	}
	
	// 1. 인수 출력
	public void showArguments(Object[] args) {
		for(int i = 0 ; i < args.length ; i++) {
			System.out.println("{"+i+"} argument is "+args[i]);
		}
	}
	
	// 2. 조인포인트의 종류 출력
	public void showPointCutKind(String kind) {
		System.out.println("pointcut kine is "+kind);
	}
	
	// 3. getTarget 메서드를 사용하여 실행하려는 객체를 참조
	public void showTarget(Target o) {
		o.log("Hello");
	}
	
	// 4. 조인포인트와 매칭 매처의 구조를 출력
	public void showSignature(Signature signature) {
		System.out.println("typeName : "+signature.getDeclaringTypeName());
		System.out.println("methodName : "+signature.getName());
	}
	
	// 5. 메서드의 결과값을 출력
	public Object showReturningValue(Object o) {
		System.out.println("return : "+o);
		return o;
	}
	
}

package aop.afterReturning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningAdvice {
	
	private int result;
	private String methodName;
	
	@AfterReturning(pointcut = "execution(* aop..arith*(..))"
			, returning = "r")
	public void afterReturningAdvice(JoinPoint joinPoint, Object r) {
		this.methodName = joinPoint.getSignature().getName();
		this.result = (int)r;
	}

	public int getResult() {
		return result;
	}

	public String getMethodName() {
		return methodName;
	}
	
}

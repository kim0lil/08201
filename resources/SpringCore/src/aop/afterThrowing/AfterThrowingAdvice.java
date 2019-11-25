package aop.afterThrowing;

import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Component
public class AfterThrowingAdvice {
	
	private String ExceptionMessage = null;

	@Pointcut("execution(* *..d*(..))")
	public void basePointCut() {}
	
	@AfterThrowing(pointcut = "basePointCut()"
			, throwing = "e")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception e) {
		this.ExceptionMessage = e.getMessage();
	}

	public String getExceptionMessage() {
		return ExceptionMessage;
	}
	
	
}

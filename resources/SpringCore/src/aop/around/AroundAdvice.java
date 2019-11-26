package aop.around;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAdvice {

	@Pointcut("execution(int *..add*(int, int))")
	public void additionPointCut() {}
	
	@Around("additionPointCut()")
	public Object additionAdvice(ProceedingJoinPoint joinpoint) {
		
		Object o = null;
		int overNumber = 10;

		try {
			Object[] oList = joinpoint.getArgs();
			o = joinpoint.proceed(new Object[] {overNumber+(int)oList[0],(int)oList[1]});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return o;
	}
}

package aop.order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AdviceThird {

	@Around("JoinPoint.around()")
	public Object setting(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object args[] = joinPoint.getArgs();

		args[0] = (int)args[0] + 4;
		
		return joinPoint.proceed(args);
	}
}

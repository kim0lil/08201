package aop.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class JoinPoint {

	@Pointcut("execution(* *.*(..))")
	public void around() {}
}

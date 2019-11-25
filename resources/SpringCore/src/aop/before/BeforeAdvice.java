package aop.before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAdvice {
	
	@Autowired
	private StringBuilder stringBuilder;

	@Pointcut("execution(int *.a*d(int,int))")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void beforeAdvice(JoinPoint joinPoint) {
		stringBuilder.append(joinPoint.getArgs()[0]+","+joinPoint.getArgs()[1]);
	}
	
	public String getMessage() {
		return stringBuilder.toString();
	}
}

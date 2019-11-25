package aop.after;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAdvice {
	
	private int count = 0;

	@After("execution(void *.connect(..))")
	public void after() {
		count++;
	}

	public int getCount() {
		return count;
	}
}

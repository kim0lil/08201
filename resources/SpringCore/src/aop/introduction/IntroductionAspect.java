package aop.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IntroductionAspect {

	@DeclareParents(
		value = "aop.introduction.Logger",
		defaultImpl = SimpleDbLog.class
	)
	public LogDatabase dbLog;
	
	@DeclareParents(
		value = "aop.introduction.Logger",
		defaultImpl = SimpleTransactionLog.class
	)
	public LogTransaction txLog;
	
	
}

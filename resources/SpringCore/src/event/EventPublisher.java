package event;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventPublisher {
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Before("execution(* *(String)) && args(menuID)")
	public void log(String menuID) {
		applicationEventPublisher.publishEvent(new EventObject(this, menuID));
	}

}

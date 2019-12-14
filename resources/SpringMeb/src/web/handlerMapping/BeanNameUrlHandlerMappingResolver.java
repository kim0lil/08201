package web.handlerMapping;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

public class BeanNameUrlHandlerMappingResolver {
	
	public static HandlerMapping getBeanNameUrlHandlerMapping() {
		
		BeanNameUrlHandlerMapping mapping = new BeanNameUrlHandlerMapping();
		
		return mapping;
	}
}

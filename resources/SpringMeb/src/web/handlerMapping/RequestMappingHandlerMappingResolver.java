package web.handlerMapping;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class RequestMappingHandlerMappingResolver {
	
	public static HandlerMapping getRequestMappingHandlerMapping() {
		
		RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
		
		return mapping;
	}
}

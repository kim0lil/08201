package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import web.handlerMapping.BeanNameUrlHandlerMappingResolver;
import web.handlerMapping.RequestMappingHandlerMappingResolver;
import web.handlerMapping.SimpleUrlHandlerMappingResolve;
import web.viewResolver.BeanNameViewResolverView;


@ComponentScan({"web"})
public class WebConfiguration {
	
	// 1. 사용자 요청으로 부터 핸들러를 매핑하는 전략
	@Bean
	public HandlerMapping getHandlerMapping() {
		// 1. http://localhost:8080/mvc/getSimpleUrlHandler
		//return SimpleUrlHandlerMappingResolve.getSimpleUrlHandlerMapping(); 
		
		// 2. http://localhost:8080/mvc/simpleUrlHandler
		//return BeanNameUrlHandlerMappingResolver.getBeanNameUrlHandlerMapping();
		
		// 3. http://localhost:8080/mvc/simpleUrlHandler
		return RequestMappingHandlerMappingResolver.getRequestMappingHandlerMapping(); 
	}
	
	// 2. 요청을 처리 하는 뷰 리졸버를 사용하여 뷰를 매핑하는 전략
	public ViewResolver getViewResolver() {
		return BeanNameViewResolverView.getBeanNameViewResolverView();
	}
	
}

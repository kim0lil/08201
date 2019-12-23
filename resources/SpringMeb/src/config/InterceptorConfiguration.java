package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import web.interceptor.RootInterceptor;

@ComponentScan("web.interceptor")
public class InterceptorConfiguration extends WebMvcConfigurationSupport{
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new RootInterceptor())
		        .addPathPatterns("/");
	}
}

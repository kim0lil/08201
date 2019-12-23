package web.viewResolver;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;


public class BeanNameViewResolverView {
	
	public static ViewResolver getBeanNameViewResolverView() {
		BeanNameViewResolver viewResolver = new BeanNameViewResolver();
		
		return viewResolver;
	}
}

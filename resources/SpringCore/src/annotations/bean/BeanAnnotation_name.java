package annotations.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanAnnotation_name {


	@Bean(name= {"beanObj","objBean"})
	public BeanObject getBeanObject() {
		return new BeanObject();
	}
}

package annotations.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAnnotation_initMethod {


	@Bean(initMethod = "initMethod")
	public BeanObject getBeanObject() {
		return new BeanObject();
	}
}

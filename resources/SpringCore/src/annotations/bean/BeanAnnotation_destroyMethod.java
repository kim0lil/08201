package annotations.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAnnotation_destroyMethod {


	@Bean(destroyMethod = "destroyMethod")
	public BeanObject getBeanObject() {
		return new BeanObject();
	}
}

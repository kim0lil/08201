package annotations.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAnnotation_autowireCandidate {
	
	@Bean
	public BeanAutowired beanAutowired() {
		return new BeanAutowired();
	}

	@Bean(autowireCandidate = false) // 기본은 true로 되어 있으며 false로 변경시 autowire로 의존성이 등록 되지 않습니다.
	public BeanObject getBeanObject() {
		return new BeanObject();
	}
}

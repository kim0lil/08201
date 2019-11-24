package annotations.componentScan;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;

// 빈의 이름을 생성해 주는 클래스를 지정하여 빈명칭을 스프링의 default 명칭과는 다르게 등록 할 수 있다
@ComponentScan(
		basePackages = {"annotations.componentScan"}
	  , nameGenerator = CustomBeanNameGenerator.class
)
public class ComponentScanAnnotation_nameGenerator {
	
}

class CustomBeanNameGenerator implements BeanNameGenerator{

	final String singleton = "singleton";
	final String prototype = "prototype";
	
	@Override
	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {

		String beanName = "";

		// NoScan 빈은 Singleton으로 Scan 빈은 Prototype으로 설정
		if(definition.getBeanClassName().equals("annotations.componentScan.NoScan")) {

			beanName = "genNoScan";

		} else if(definition.getBeanClassName().equals("annotations.componentScan.Scan")) {

			beanName = "genScan";

		}

		// 확인을 위한 출력
		//System.out.println(definition.getBeanClassName()+" beanName is "+beanName);
		
		return beanName;
	}
	
}
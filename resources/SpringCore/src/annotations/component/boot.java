package annotations.component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"annotations.component"})
public class boot {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		ComponentAnnotation anno       = context.getBean(ComponentAnnotation.class);

		ComponentAnnotation_value annoValue 
		                               = context.getBean("annotationValue", ComponentAnnotation_value.class);
		
		ComponentAnnotation_controller controller
		                               = context.getBean(ComponentAnnotation_controller.class);
	
		ComponentAnnotation_repository repository = context.getBean(ComponentAnnotation_repository.class);
		
		ComponentAnnotation_service    service
		                               = context.getBean(ComponentAnnotation_service.class);

	}
}

package beanPostProcess;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("beanPostProcess")
public class boot {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		NonProcessingBean nonPost = context.getBean(NonProcessingBean.class);
		PostProcessingBean post   = context.getBean(PostProcessingBean.class);
		
		if(nonPost.getName() != null) {
			System.out.println("test expire");
			return;
		}
		if(!post.getName().equals("postProcessingBean")) {
			System.out.println("test expire");
			return;
		}
	}
}

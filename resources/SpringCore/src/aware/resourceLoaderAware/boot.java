package aware.resourceLoaderAware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("aware.resourceLoaderAware")
public class boot {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		ResourceLoaderInterface resourceLoader = context.getBean(ResourceLoaderInterface.class);
		
		String item1 = resourceLoader.getBenner().toString();
		if(!item1.equals("################\n"+
                         "# Hello Spring #\n"+
                         "################\n")) {

			System.out.println("test expire");
		};

	}
}

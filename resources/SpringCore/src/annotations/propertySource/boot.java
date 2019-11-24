package annotations.propertySource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.PropertySource;

public class boot {
	
	public static StringBuffer stdin = new StringBuffer();

	public static void main(String[] args) {
		AnnotationConfigApplicationContext values
			=	new AnnotationConfigApplicationContext(PropertySourceAnnotation_values.class);
		
		AnnotationConfigApplicationContext name
			=	new AnnotationConfigApplicationContext(PropertySourceAnnotation_name.class);
		
		AnnotationConfigApplicationContext encoding
			=	new AnnotationConfigApplicationContext(PropertySourceAnnotation_encoding.class);
		
		AnnotationConfigApplicationContext factory
		=	new AnnotationConfigApplicationContext(PropertySourceAnnotation_factory.class);
		try {
			AnnotationConfigApplicationContext ignoreResourceNotFound
			=	new AnnotationConfigApplicationContext(PropertySourceAnnotation_ignoreResourceNotFound.class);
		}catch(Exception e) {
			System.out.println("test expire");
		}
		PropertySource item1 = values.getEnvironment()
				                    .getPropertySources()
				                    .get("values");
		
		if(!item1.getProperty("url").equals("127.0.0.1")) {
			System.out.println("test expire");
			return;
		}
		
		PropertySource item2 = values.getEnvironment()
				.getPropertySources()
				.get("name");
		
		if(item1 == item2) {
			System.out.println("test expire");
			return;
		}
		
		
		PropertySource item3 = encoding.getEnvironment()
					                   .getPropertySources()
					                   .get("encoding");

		if(item3.getProperty("name").equals("이진혁")) {
			System.out.println("test expire");
			return;
		}
		
		PropertySource item4 = factory.getEnvironment()
						              .getPropertySources()
						              .get("factory");

		if(!stdin.toString().equals("name : factory")) {
			System.out.println("test expire");
			return;
		}

		stdin = new StringBuffer();

		item4.getProperty("url");
		
		if(!stdin.toString().equals("{url,127.0.0.1}")) {
			System.out.println("test expire");
			return;
		}
		
		stdin = new StringBuffer();
		
		item4.getProperty("password");

		if(!stdin.toString().equals("{password,admin}")) {
			System.out.println("test expire");
			return;
		}
	}
}

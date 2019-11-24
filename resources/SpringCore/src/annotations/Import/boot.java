package annotations.Import;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class boot {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(ImportAnnotation.class);
		
		ConnectionDriver Import = context.getBean(ConnectionDriver.class);
		
		if(! "admin is 127.0.0.1:8080 connected".equals(Import.getConnection())) {
			
			System.out.println("test expire");
		}
		
	}
}

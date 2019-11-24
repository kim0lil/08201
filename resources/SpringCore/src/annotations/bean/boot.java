package annotations.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "annotations.bean" })
public class boot {
	
	public static StringBuilder memory = new StringBuilder();
	
	public static OutputStream os = new OutputStream() {

		@Override
		public void write(int b) throws IOException {
			memory.append((char)b);
		}
	}; 

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext bean = new AnnotationConfigApplicationContext(BeanAnnotation.class);
		AnnotationConfigApplicationContext name = new AnnotationConfigApplicationContext(BeanAnnotation_name.class);
		AnnotationConfigApplicationContext initMethod = new AnnotationConfigApplicationContext(BeanAnnotation_initMethod.class);
		AnnotationConfigApplicationContext destroyMethod = new AnnotationConfigApplicationContext(BeanAnnotation_destroyMethod.class);
		AnnotationConfigApplicationContext autowireCandidate = new AnnotationConfigApplicationContext(BeanAnnotation_autowireCandidate.class);

		BeanObject item1 = bean.getBean(BeanObject.class);

		BeanObject item2 = name.getBean("beanObj",BeanObject.class);
		BeanObject item3 = name.getBean("objBean",BeanObject.class);

		if(item2 != item3) {
			System.out.println("test expire");
			return;
		}

		String item4 = boot.memory.toString();
		
		if(!item4.equals("<<init>>")) {

			System.out.println("test expire");
			return;
		} else {

			memory = new StringBuilder();
		}

		destroyMethod.destroy();
		String item5 = boot.memory.toString();
		
		if(!item5.equals("<<destroy>>")) {
			
			System.out.println("test expire");
			return;
		} else {
			
			memory = new StringBuilder();
		}

		BeanAutowired beanAutowired = autowireCandidate.getBean(BeanAutowired.class);
		
		if(beanAutowired.getBeanObject() != null) {
			System.out.println("test expire");
		}
		
		
	}
}

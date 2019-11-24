package annotations.componentScan;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class boot {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanAnnotation.class);
		AnnotationConfigApplicationContext basePackages = new AnnotationConfigApplicationContext(ComponentScanAnnotation_basePackages.class);
		AnnotationConfigApplicationContext basePackageClasses = new AnnotationConfigApplicationContext(ComponentScanAnnotation_basePackageClasses.class);
		AnnotationConfigApplicationContext excludeFilters = new AnnotationConfigApplicationContext(ComponentScanAnnotation_excludeFilters.class);
		AnnotationConfigApplicationContext includeFilters = new AnnotationConfigApplicationContext(ComponentScanAnnotation_includeFilters.class);
		AnnotationConfigApplicationContext lazyInit = new AnnotationConfigApplicationContext(ComponentScanAnnotation_lazyInit.class);
		AnnotationConfigApplicationContext scopeResolver = new AnnotationConfigApplicationContext(ComponentScanAnnotation_scopeResolver.class);
		AnnotationConfigApplicationContext nameGenerator = new AnnotationConfigApplicationContext(ComponentScanAnnotation_nameGenerator.class);
		
		Scan item1 = basePackages.getBean(Scan.class);
		Scan item2 = basePackageClasses.getBean(Scan.class);
		Scan item3 = excludeFilters.getBean(Scan.class);

		try {
			NoScan item4 = excludeFilters.getBean(NoScan.class);
			System.out.println("test expire");
		}catch(NoSuchBeanDefinitionException e) {
			
		}
		
		Scan item5 = includeFilters.getBean(Scan.class);
		try {
			NoScan item6 = includeFilters.getBean(NoScan.class);
			System.out.println("test expire");
		}catch(NoSuchBeanDefinitionException e) {
			
		}
		
		NoScan singleton_1 = scopeResolver.getBean(NoScan.class);
		NoScan singleton_2 = scopeResolver.getBean(NoScan.class);
		
		if(singleton_1 != singleton_2) {
			System.out.println("test expire");
			return;
		}
		
		Scan prototype_1 = scopeResolver.getBean(Scan.class);
		Scan prototype_2 = scopeResolver.getBean(Scan.class);
		
		if(prototype_1 == prototype_2) {
			System.out.println("test expire");
			return;
		}
		
		Scan   scan   = (Scan)  nameGenerator.getBean("genScan");
		NoScan noScan = (NoScan)nameGenerator.getBean("genNoScan");

	}
}

package event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"event"})
@EnableAspectJAutoProxy
public class boot {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		MenuOpen open = context.getBean(MenuOpen.class);
		open.menuOpen("MU1000");
	}
}

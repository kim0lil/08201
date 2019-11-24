package annotations.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
	ProfileAnnotation.class
	}
)
@ComponentScan("annotations.profile")
public class boot {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext profile = reload(new AnnotationConfigApplicationContext(), "profile");
		AnnotationConfigApplicationContext method  = reload(new AnnotationConfigApplicationContext(), "method");

		ProfileObject item1 = profile.getBean(ProfileObject.class);
		
		if(!item1.getName().equals("profile-이진혁")) {
			System.out.println("test expire");
			return;
		}
		
		ProfileObject item2 = method.getBean(ProfileObject.class);
		
		if(!item2.getName().equals("method-이진혁")) {
			System.out.println("test expire");
			return;
		}
		
		// @RuntimePlagboot에서 계속
	}
	
	public static AnnotationConfigApplicationContext reload(AnnotationConfigApplicationContext context
			, String profile) {
		context.getEnvironment().setActiveProfiles(profile);
		context.register(boot.class);
		context.refresh();
		return context;
	}
}

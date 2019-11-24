package annotations.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RuntimePlagBoot {
	public static void main(String[] args) {
		// 실행시에 VM 옵션으로 -Dspring.profiles.active=run 을 추가하여 실행한다
		AnnotationConfigApplicationContext run  = new AnnotationConfigApplicationContext(boot.class);
		
		ProfileObject item3 = run.getBean(ProfileObject.class);

		if(!item3.getName().equals("run-이진혁")) {
			System.out.println("test expire");
			return;
		}
	}
}

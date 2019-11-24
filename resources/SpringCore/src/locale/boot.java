package locale;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class boot {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context	
			= new AnnotationConfigApplicationContext(LocaleConfiguration.class);
		
		String engMessage = context.getMessage("alert.message", null, Locale.forLanguageTag("en"));
		String koMessage  = context.getMessage("alert.message", null, Locale.forLanguageTag("ko"));
		
		if(!engMessage.equals("validate error")
		|| !koMessage.equals("에러발생")) {
			System.out.println("test expire");
			return;
		}

		String engPrompt = context.getMessage("alert.promt", new Object[] {"restart"}, Locale.forLanguageTag("en"));
		String koPrompt  = context.getMessage("alert.promt", new Object[] {"재시작"}, Locale.forLanguageTag("ko"));
		
		if(!engPrompt.equals("do you restart?")
		|| !koPrompt.equals("재시작 하시겠습니까?")) {
			System.out.println("test expire");
			return;
		}
		
	}
}

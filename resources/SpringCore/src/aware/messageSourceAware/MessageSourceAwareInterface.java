package aware.messageSourceAware;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceAwareInterface implements MessageSourceAware{

	@Autowired
	private Locale locale;
	
	private String message;
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.message = messageSource.getMessage("name", null, locale);
	}

	public String getMessage() {
		return message;
	}

}

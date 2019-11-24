package annotations.Import;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class BeanConfiguration {
	
	@Autowired
	@Qualifier("user")
	private String userName;
	
	@Autowired
	@Qualifier("url")
	private String baseUrl;
	
	@Bean
	public ConnectionDriver connection() {

		return new ConnectionDriver(userName, baseUrl);
	}
}

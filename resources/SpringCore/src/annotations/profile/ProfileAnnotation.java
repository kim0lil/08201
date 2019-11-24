package annotations.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("profile")
public class ProfileAnnotation {
	

	@Bean
	public String name() {
		return "profile-이진혁";
	}
}

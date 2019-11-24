package annotations.dependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class DependsOnAnnotations {

	@Bean("second")
	@DependsOn("first")
	public String secondBean() {
		boot.stdinout.append("second");
		return "second";
	}

	@Bean("first")
	public String firstBean() {
		boot.stdinout.append("first-");
		return "first";
	}
	

}

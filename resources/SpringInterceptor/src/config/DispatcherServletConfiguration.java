package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("web")
@EnableWebMvc
public class DispatcherServletConfiguration {

}

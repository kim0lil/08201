package annotations.Import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
	PropertiesConfiguration.class
  , BeanConfiguration.class
 })
public class ImportAnnotation {

}

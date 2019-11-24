package annotations.propertySource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource(
    name = "factory"
  , value = {"classpath:annotations/propertySource/datasource.properties"}
  , factory = CustomPropertySourceFactory.class	
)
@ComponentScan // PropertySource를 사용하 ComponentScan을 필수로 등록 하여야 한다
public class PropertySourceAnnotation_factory {

}
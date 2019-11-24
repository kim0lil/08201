package annotations.propertySource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource(
	name = "encoding"
  , value = {"classpath:annotations/propertySource/isoEncoding.properties"}
  , encoding = "CP437"
)
@ComponentScan // PropertySource를 사용하 ComponentScan을 필수로 등록 하여야 한다
public class PropertySourceAnnotation_encoding {
	
}

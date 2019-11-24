package annotations.propertySource;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

public class CustomPropertySourceFactory implements PropertySourceFactory{

	@Override
	public PropertySource createPropertySource(String name, EncodedResource resource) throws IOException {

		Properties props = new Properties();
		props.load(resource.getInputStream());
		
		// 초기화 시 소스 명칭 추가
		boot.stdin.append("name : "+name);
		
		PropertySource prop = new PropertySource(name) {

			@Override
			public Object getProperty(String key) {
				
				// 속성을 불러올 경우 키:값 추가
				Object value = props.get(key);
				
				if(value != null) {
					boot.stdin.append("{"+key+","+value+"}");
				}
				return value;
			}
			
		};

		return prop;
	}
	
}

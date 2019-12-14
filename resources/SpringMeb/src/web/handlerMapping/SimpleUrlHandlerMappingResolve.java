package web.handlerMapping;

import java.io.IOException;
import java.util.Properties;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

public class SimpleUrlHandlerMappingResolve {
	
	public static HandlerMapping getSimpleUrlHandlerMapping() {
		
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();

		Properties prop = new Properties();
		
		try {
			prop.load(SimpleUrlHandlerMappingResolve.class.getResourceAsStream("urlMapping.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mapping.setMappings(prop);
		
		return mapping;
	}
}

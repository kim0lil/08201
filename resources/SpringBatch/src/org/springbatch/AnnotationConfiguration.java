package org.springbatch;

import org.springbatch.step3.BatchConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BatchConfiguration.class,WebConfiguration.class})
public class AnnotationConfiguration {

	
}

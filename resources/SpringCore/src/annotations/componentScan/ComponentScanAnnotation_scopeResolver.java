package annotations.componentScan;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;

// 빈의 스코프를 처리할 리졸버를 등록 합니다.
@ComponentScan(
		basePackages = {"annotations.componentScan"},
		scopeResolver = CustomScopeResolver.class
)
public class ComponentScanAnnotation_scopeResolver {
	
}
class CustomScopeResolver implements ScopeMetadataResolver{

	final String singleton = "singleton";
	final String prototype = "prototype";
	
	@Override
	public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {

		ScopeMetadata scope = new ScopeMetadata();
		String scopeName = "";

		// NoScan 빈은 Singleton으로 Scan 빈은 Prototype으로 설정
		if(definition.getBeanClassName().equals("annotations.componentScan.NoScan")) {

			scopeName = singleton;

		} else if(definition.getBeanClassName().equals("annotations.componentScan.Scan")) {

			scopeName = prototype;

		}
		
		scope.setScopeName(scopeName);

		// 확인을 위한 출력
		//System.out.println(definition.getBeanClassName()+" scope is "+scopeName);
		
		return scope;
	}
	
}
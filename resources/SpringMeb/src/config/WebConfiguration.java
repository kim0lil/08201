package config;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import web.handlerMapping.BeanNameUrlHandlerMappingResolver;
import web.handlerMapping.RequestMappingHandlerMappingResolver;
import web.handlerMapping.SimpleUrlHandlerMappingResolve;
import web.viewResolver.BeanNameViewResolverView;


@ComponentScan({"web"})
public class WebConfiguration {
	
	// 1. 사용자 요청으로 부터 핸들러를 매핑하는 전략
	@Bean
	public HandlerMapping getHandlerMapping() {
		// 1. http://localhost:8080/mvc/getSimpleUrlHandler
		//return SimpleUrlHandlerMappingResolve.getSimpleUrlHandlerMapping(); 
		
		// 2. http://localhost:8080/mvc/simpleUrlHandler
		//return BeanNameUrlHandlerMappingResolver.getBeanNameUrlHandlerMapping();
		
		// 3. http://localhost:8080/mvc/simpleUrlHandler
		return RequestMappingHandlerMappingResolver.getRequestMappingHandlerMapping(); 
	}
	
	// 2. 요청을 처리 하는 뷰 리졸버를 사용하여 뷰를 매핑하는 전략
	public ViewResolver getViewResolver() {
		return BeanNameViewResolverView.getBeanNameViewResolverView();
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		
		
			
		for(int i = 0 ; i < 100000000 ; i++) {
			final int x = i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
						try {
					URLConnection con = new URL("http://112.171.239.122:8080/kjh/user/register").openConnection();
					con.setDoOutput(true);	
					con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
					OutputStream stream = con.getOutputStream();
					DataOutputStream dos = new DataOutputStream(stream);
					dos.writeUTF("useriduserid=adazxcqedr"+x+"&password=asdasd123&isPassword=asdasd123&username=%EB%84%A4%EC%9D%B4%EB%A7%88&birthday=20010101&gender=M&email=121111%40asda.com&phone=010-1011-1231");
					dos.flush();
					System.out.println("---------------"+x);
					}catch(Exception e) {}
				}
			}).start();;
		}
	}
	
}

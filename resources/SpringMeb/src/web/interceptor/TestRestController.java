package web.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

	@GetMapping("/")
	public String helloInterceptor() {
		return "<h1>Hello Interceptor</h1>";
	}
}

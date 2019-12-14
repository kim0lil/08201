package web.handlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller("/simpleUrlHandler")
public class HandlerResolver extends AbstractController implements BeanNameAware{
	
	@RequestMapping("/simpleUrlHandler")
	public ModelAndView methodHandler() {
		System.out.println("methodHandler is running");
		
		ModelAndView mv = new ModelAndView("BeanNameViewResolverProcess");
		return mv;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("handleRequestInternal is running");

		ModelAndView mv = new ModelAndView("BeanNameViewResolverProcess");
		return mv;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println(name+" is bean loaded");
		
	}
	
}

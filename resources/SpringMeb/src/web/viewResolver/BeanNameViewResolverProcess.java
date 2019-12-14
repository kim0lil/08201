package web.viewResolver;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.AbstractView;

@Component
@RequestMapping("BeanNameViewResolverProcesss")
public class BeanNameViewResolverProcess extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.getWriter().write("end");
	}

	@RequestMapping("BeanNameViewResolverProcesss")
	public void get() {

	}

}

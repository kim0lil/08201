package aop.afterThrowing;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class ZeroDeviceSigniture {
	
	public int devide(int val, int div) {

		if(div == 0) {
			throw new RuntimeException("Zero Device Excpetion");
		}

		return val / div;
	}
}

package annotations.bean;

import java.io.IOException;

public class BeanObject {
	
	public void initMethod() {
		
		"<<init>>".chars().forEach(value -> {
			try {
				boot.os.write(value);
			} catch (IOException e) { }
		});
	}
	
	public void destroyMethod() {

		"<<destroy>>".chars().forEach(value -> {
			try {
				boot.os.write(value);
			} catch (IOException e) { }
		});
	}
}

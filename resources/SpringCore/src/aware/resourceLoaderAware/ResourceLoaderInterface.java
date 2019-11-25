package aware.resourceLoaderAware;

import java.io.DataInputStream;
import java.io.IOException;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ResourceLoaderInterface implements ResourceLoaderAware{
	
	private StringBuilder benner = new StringBuilder();
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		Resource r = resourceLoader.getResource("classpath:aware/resourceLoaderAware/benner.txt");
		
		try {
			DataInputStream dis = new DataInputStream(r.getInputStream());
			
			while(dis.available() > 0) {
				benner.append(dis.readLine()+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public StringBuilder getBenner() {
		return benner;
	}
}

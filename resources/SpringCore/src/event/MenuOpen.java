package event;

import org.springframework.stereotype.Component;

@Component
public class MenuOpen {

	public void menuOpen(String menuID) {
		System.out.println("--------------------------");
		System.out.println(menuID);
		System.out.println("--------------------------");
	}
}

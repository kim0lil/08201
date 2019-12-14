package event;

import org.springframework.context.ApplicationEvent;

public class EventObject extends ApplicationEvent{
	
	private String menuID;

	public EventObject(Object source, String menuID) {
		super(source);
		this.menuID = menuID;
	}

	public String getMenuID() {
		return menuID;
	}

}

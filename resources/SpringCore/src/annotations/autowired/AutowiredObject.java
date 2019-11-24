package annotations.autowired;

public class AutowiredObject {
	
	private String firstName;
	private String middleName;
	private String lastName;
	
	public AutowiredObject(String firstName, String middleName, String lastName) {
		this.firstName  = firstName;
		this.middleName = middleName;
		this.lastName   = lastName;
	}

	public String getName() {

		StringBuilder builder = new StringBuilder();
		
		builder.append(firstName);
		builder.append(" ");
		builder.append(middleName);
		builder.append(" ");
		builder.append(lastName);

		return builder.toString();
	}
	
}

package annotations.Import;

public class ConnectionDriver {
	
	private String userName;
	private String baseUrl;
	
	public ConnectionDriver(String userName, String baseUrl) {
		this.userName = userName;
		this.baseUrl = baseUrl;
	}
	
	public String getConnection() {

		return userName + " is " +baseUrl+" connected";
	}
	
}

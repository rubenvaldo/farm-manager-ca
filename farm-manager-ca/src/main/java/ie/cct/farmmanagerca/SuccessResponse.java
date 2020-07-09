package ie.cct.farmmanagerca;

public class SuccessResponse {
	
	private String message;
	
	
	
	public SuccessResponse(String message) {
		this.message = message;
	}
	
	

	// always generate  getters since it's the only way to access data
	public String getMessage() {
		return message;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	

}

package sbrest.model;

//A representation of what the server will return (only some details of request)
public class RequestStatusResponse {
	private Integer requestNumber;
	private String requestStatus;
	private String firstName;
	private String lastName;

	public RequestStatusResponse(Integer requestNumber, String requestStatus, String firstName, String lastName) {
		this.requestNumber = requestNumber;
		this.requestStatus = requestStatus;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(Integer requestNumber) {
		this.requestNumber = requestNumber;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
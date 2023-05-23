package API_Payload;

public class UpdateUser {

	private String name;
	private String phone;
	private String company;
	
	private String status;
	private boolean success;
	private String message;
	private LoggedinUserData data;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LoggedinUserData getData() {
		return data;
	}
	public void setData(LoggedinUserData data) {
		this.data = data;
	}
	
	
}

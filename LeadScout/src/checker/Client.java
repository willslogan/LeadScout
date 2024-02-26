package checker;

public class Client {
	private String firstName;
	private String lastName;
	private String email;
	
	public Client(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email.toLowerCase();
	}
	
	public String toString() {
		return "" + this.firstName + ","  + this.email + "\n";
	}
	
	public void clearInfo() {
		this.firstName = "";
		this.lastName = "";
		this.email = "";
	}
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(obj.getClass() != Client.class){
			return false;	
		}
		else if(((Client)obj).getEmail().equals(this.getEmail())) {
			return true;
		}
		else 
			return false;
	}
}

package spree;
public class Login {
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Login() {
		// TODO Auto-generated constructor stub
	}

	protected String username;
	protected String password;
	protected boolean isValid;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}



}
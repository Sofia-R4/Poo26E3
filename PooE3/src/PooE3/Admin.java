/**
 * 
 */
package PooE3;

/**
 * 
 */
public class Admin extends User{

	private String email;

	public Admin(String name, String email, String password) {
		super(name, password);
		// TODO Auto-generated constructor stub
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
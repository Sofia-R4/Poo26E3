/**
 * 
 */
package PooE3;

/**
 * 
 */
public class Employee extends User{
	private Specialty specialty;
	private String email;
	
	
	
	/**
	 * @param name
	 * @param password
	 */
	public Employee(String name, String email, String password, Specialty specialty) {
		super(name, password);
		// TODO Auto-generated constructor stub
		
		
	}



	public Specialty getSpecialty() {
		return specialty;
	}



	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	

}

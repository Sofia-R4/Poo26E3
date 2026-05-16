/**
 * 
 */
package PooE3;

/**
 * 
 */
public class AcademicUser extends User{
	
	private int userNumber;

	
	
	/**
	 * @param name
	 * @param password
	 */
	public AcademicUser(String name, int UserNumber, String password) {
		super(name, password);
		// TODO Auto-generated constructor stub
		this.userNumber = userNumber;
	}

	
	
}

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
	public AcademicUser(String name, int userNumber, String password) {
		super(name, password);
		// TODO Auto-generated constructor stub
		this.userNumber = userNumber;
	}



	public int getUserNumber() {
		return userNumber;
	}



	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	
	
}

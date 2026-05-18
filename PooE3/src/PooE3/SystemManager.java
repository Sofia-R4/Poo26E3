/**
 * 
 */
package PooE3;

/**
 * 
 */
import java.util.ArrayList;
import java.time.LocalDate;


public class SystemManager {
	
	private ArrayList<User> users;
	private ArrayList<Employee>employees;
	private ArrayList<Occurrence>occurrences;
	private ArrayList<OccurrenceType>types;
	private ArrayList<Specialty>specialties;
	
		
	/**
	 * @param users
	 * @param employees
	 * @param occurrences
	 * @param types
	 * @param specialties
	 */
	public SystemManager(ArrayList<User> users, ArrayList<Employee> employees, ArrayList<Occurrence> occurrences,
			ArrayList<OccurrenceType> types, ArrayList<Specialty> specialties) {
		super();
		this.users = users;
		this.employees = employees;
		this.occurrences = occurrences;
		this.types = types;
		this.specialties = specialties;
	}
	
	
	
	
	//add an user
	public void addUser(User user) {
		users.add(user);
		System.out.println("User add with succes!");
	}
	
	//test if password is vallid
	public boolean isPasswordValid(String password) {
		if(password.length()<8) {
			System.out.println("The password must have at least 8 characters.");
			return false;
		}
		
		else {
			return true;
		}
	}
	
	//login academic user with verification of password and number
	public User loginAcademicUser(String password, int number) {
		for (User us : users) {
			//the object in us is academicUSer?
			if (us instanceof AcademicUser) {
				//this user is an academic user
				AcademicUser au = (AcademicUser) us;
				
				if(au.getUserNumber() == number) {
					if(au.getPassword().equalsIgnoreCase(password)) {
						System.out.println("Logged in!");
					}
					
					else{
						System.out.println("Password is incorrect!");
						return null;
					}
				}
			}
		}
			System.out.println("Number is incorrect!");
			return null;
	}
	
	//login admin with verification of password and email
	public User loginAdmin(String password, String email) {
		for (User us : users) {
			//the object in us is Admin?
			if (us instanceof Admin) {
				//this user is an admin
				Admin adm = (Admin) us;
					
				if(adm.getEmail().equalsIgnoreCase(email)) {
					if(adm.getPassword().equalsIgnoreCase(password)) {
						System.out.println("Logged in!");
					}
						
					else{
						System.out.println("Password is incorrect!");
						return null;
					}
				}
			}
		}
			System.out.println("Email is incorrect!");
			return null;
	}
		
	//login employee with verification of password and email
	public User loginEmployee(String password, String email) {
		for (User us : users) {
			//the object in us is Employee?
			if (us instanceof Employee) {
				//this user is an employee
				Employee emp = (Employee) us;
							
				if(emp.getEmail().equalsIgnoreCase(email)) {
					if(emp.getPassword().equalsIgnoreCase(password)) {
						System.out.println("Logged in!");
					}
							
				else{
					System.out.println("Password is incorrect!");
					return null;
					}
				}
			}
		}
		System.out.println("Email is incorrect!");
		return null;
	}
	
	//add employee, only admin can do it
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
}

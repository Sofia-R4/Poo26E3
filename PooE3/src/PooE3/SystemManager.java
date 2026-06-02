/**
 * 
 */
package PooE3;

/**
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;


public class SystemManager {
	
	private ArrayList<User> users;
	private ArrayList<Employee>employees;
	private ArrayList<Occurrence>occurrences;
	private ArrayList<OccurrenceType>types;
	private ArrayList<Specialty>specialties;
	
		
	/**
	 */
	public SystemManager() {
		super();
		users = new ArrayList<>();
		employees = new ArrayList<>();
		occurrences = new ArrayList<>();
		types = new ArrayList<>();
		specialties = new ArrayList<>();
	}
	
	
	
	
	//add an user
	public void addUser(User user) {
		users.add(user);
		System.out.println("User add with success!");
	}
		
	//test if password is valid
	public boolean isPasswordValid(String password) {
		if(password.length()<8) {
			System.out.println("The password must have at least 8 characters.");
			return false;
		}
		
		else {
			return true;
		}
	}
	
	//test if the format of email is correct
	public boolean isEmailCorrect(String email) {
		if(email.contains("@")) {
			return true;
		}
		
		else {
			System.out.println("Email must contain @");
			return false;
		}
	}
	
	//login academic user with verification of password and number
	public void loginAcademicUser(String password, int number) {
		for (User us : users) {
			//the object in us is academicUSer?
			if (us instanceof AcademicUser) {
				//this user is an academic user
				AcademicUser au = (AcademicUser) us;
				
				if(au.getUserNumber() == number) {
					if(au.getPassword().equalsIgnoreCase(password)) {
						System.out.println("Logged in!");
						return;
					}
				}
			}
		}
			System.out.println("Number is incorrect!");
	}
	
	//login admin with verification of password and email
	public void loginAdmin(String password, String email) {
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
						return;
					}
				}
				System.out.println("Email is incorrect!");
				return;
			}
		}		
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
					return emp;
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
	
	
	
	
	
	// Method to get all occurrences

	public ArrayList<Occurrence> getOccurrences() {
		return new ArrayList<>(occurrences);
	}
	
	
	// Method to get all employees by specialty
	
	public ArrayList<Employee> getEmployeesBySpecialty(Specialty specialty){
		
		ArrayList<Employee> result = new ArrayList<>();
		
		if(specialty == null) {
			System.out.println("Specialty cannot be null!");
			return result;
		}
		
		for(Employee employee : employees) {
			if(employee.getSpecialty() !=  null && employee.getSpecialty().equals(specialty)) {
				result.add(employee);
			}
		}
		
		return result;
	}
	
	
	// Method to get all occurrence totals grouped by type
	public Map<OccurrenceType, Integer> getOccurrenceTotalsByType(){
		
		Map<OccurrenceType, Integer> totals = new HashMap<>();
		
		for(Occurrence occurrence : occurrences) {
			OccurrenceType type = occurrence.getType();
			
			if(type != null) {
				if(totals.containsKey(type)){
					totals.put(type, totals.get(type) + 1);
				} else {
					totals.put(type, 1);
				}
			}
		}
		
		return totals;
		
	}
	
	// Method to add a Specialty
	public void addSpecialty(Specialty specialty) {
		if(specialty == null) {
			System.out.println("Specialty cannot be null!");
			return;
		}
		
		specialties.add(specialty);
		System.out.println("Specialty added successfully");
	}
	
	public void getResolvedOccurrences() {
		for (Occurrence oc : occurrences) {
			if(oc.getStatus() == OccurrenceStatus.RESOLVED) {
				System.out.println("Resolved occurrences are:");
				System.out.println("Creation date: " + oc.getCreationDate());
				System.out.println("Resolution date: " + oc.getResolutionDate());
				System.out.println("Type: " + oc.getType());
			}
		}
	}
	
	public void addOccurrence(Occurrence occurrence) {
		
	    if (occurrence == null) {
	        System.out.println("Error: occurrence cannot be null.");
	        return;
	    }
		occurrences.add(occurrence);
	    System.out.println("Occurrence added successfully!");
	}
}

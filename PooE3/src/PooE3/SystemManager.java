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
	
	
	
	

	public void addUser(User user) {
		users.add(user);
		System.out.println("User add with success!");
	}
		

	public boolean isPasswordValid(String password) {
		if(password.length()<8) {
			System.out.println("The password must have at least 8 characters.");
			return false;
		}
		
		else {
			return true;
		}
	}
	

	public boolean isEmailCorrect(String email) {
		if(email.contains("@")) {
			return true;
		}
		
		else {
			System.out.println("Email must contain @");
			return false;
		}
	}

	public void loginAcademicUser(String password, int number) {
		for (User us : users) {

			if (us instanceof AcademicUser) {
		
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
	

	public void loginAdmin(String password, String email) {
		for (User us : users) {

			if (us instanceof Admin) {
	
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
		

	public User loginEmployee(String password, String email) {
		for (User us : users) {

			if (us instanceof Employee) {
	
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
	

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	
	
	
	
	
	
	


	public ArrayList<Occurrence> getOccurrences() {
		return new ArrayList<>(occurrences);
	}
	
	

	
	public ArrayList<Employee> getEmployeesBySpecialty(Specialty specialty){
		
		ArrayList<Employee> result = new ArrayList();
		
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
		occurrences.add(occurrence);
	}
	
}

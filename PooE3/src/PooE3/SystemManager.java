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
	private int nextSpecialtyId = 1;
		
	/**
	 */
	public SystemManager() {
		super();
		users = new ArrayList<>();
		employees = new ArrayList<>();
		occurrences = new ArrayList<>();
		types = new ArrayList<>();
		specialties = new ArrayList<>();
		
		

	    types.add(new OccurrenceType(1, "Limpeza", "Problema de limpeza ou higiene"));
	    types.add(new OccurrenceType(2, "Eletricidade", "Problema elétrico"));
	    types.add(new OccurrenceType(3, "Manutenção", "Problema geral de manutenção"));
	    types.add(new OccurrenceType(4, "Equipamento", "Equipamentos danificados ou com defeito"));
	    types.add(new OccurrenceType(5, "Outro", "Outro tipo de ocorrência"));
	}
	
	
	//create specialty in adm
	public int generateSpecialtyId() {
	    return nextSpecialtyId++;
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
	
	
	//general login method
	public User login(String credential, String password) {
	    if (credential == null || credential.isBlank()) {
	        System.out.println("Error: credential cannot be empty.");
	        return null;
	    }

	    if (password == null || password.isBlank()) {
	        System.out.println("Error: password cannot be empty.");
	        return null;
	    }

	    for (User user : users) {

	        if (user instanceof AcademicUser) {
	            AcademicUser academicUser = (AcademicUser) user;

	            String userNumberText = String.valueOf(academicUser.getUserNumber());

	            if (userNumberText.equals(credential)) {
	                if (academicUser.getPassword().equals(password)) {
	                    System.out.println("Logged in!");
	                    return academicUser;
	                } else {
	                    System.out.println("Password is incorrect!");
	                    return null;
	                }
	            }
	        }

	        if (user instanceof Admin) {
	            Admin admin = (Admin) user;

	            if (admin.getEmail().equalsIgnoreCase(credential)) {
	                if (admin.getPassword().equals(password)) {
	                    System.out.println("Logged in!");
	                    return admin;
	                } else {
	                    System.out.println("Password is incorrect!");
	                    return null;
	                }
	            }
	        }

	        if (user instanceof Employee) {
	            Employee employee = (Employee) user;

	            if (employee.getEmail().equalsIgnoreCase(credential)) {
	                if (employee.getPassword().equals(password)) {
	                    System.out.println("Logged in!");
	                    return employee;
	                } else {
	                    System.out.println("Password is incorrect!");
	                    return null;
	                }
	            }
	        }
	    }

	    System.out.println("Credentials not found!");
	    return null;
	}
	
	
	//add employee, only admin can do it
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	
	//method to get all occurrences
	public ArrayList<Occurrence> getOccurrences() {
		return new ArrayList<>(occurrences);
	}
	
	
	//method to get all employees by specialty
	public ArrayList<Employee> getEmployeesBySpecialty(Specialty specialty){
		
		ArrayList<Employee> result = new ArrayList<>();
		
		if(specialty == null) {
			System.out.println("Specialty cannot be null!");
			return result;
		}
		
		for(Employee employee : employees) {
			if(employee.getSpecialty() !=  null && employee.getSpecialty().equals(specialty)) {
				result.add(employee); //save this employee
			}
		}
		
		return result;
	}
	
	
	// Method to get all occurrence totals grouped by type
	public Map<OccurrenceType, Integer> getOccurrenceTotalsByType(){
		//create an empty map
		Map<OccurrenceType, Integer> totals = new HashMap<>();
		
		for(Occurrence occurrence : occurrences) {
			OccurrenceType type = occurrence.getType();
			
			if(type != null) {
				if(totals.containsKey(type)){ //if already exists
					totals.put(type, totals.get(type) + 1); //add to the current one
				} else {
					totals.put(type, 1); //start with 1
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
	
	//show resolved occurrences
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
	
	
	public ArrayList<Specialty> getSpecialties() {
	    return new ArrayList<>(specialties);
	}
	
	
	//find the specialty by id
	public Specialty findSpecialtyById(int id) {
	    for (Specialty specialty : specialties) {
	        if (specialty.getId() == id) {
	            return specialty;
	        }
	    }

	    return null;
	}
	
	//add an occurrence
	public void addOccurrence(Occurrence occurrence) {
		
	    if (occurrence == null) {
	        System.out.println("Error: occurrence cannot be null.");
	        return;
	    }
		occurrences.add(occurrence);
	    System.out.println("Occurrence added successfully!");
	}
	
	
	//find types by id
	public OccurrenceType findOccurrenceTypeById(int id) {

	    for (OccurrenceType type : types) {
	        if (type.getId() == id) {
	            return type;
	        }
	    }

	    return null;
	}
	
	
	//find occurrence by id
	public Occurrence findOccurrenceById(int id) {
	    for (Occurrence occurrence : occurrences) {
	        if (occurrence.getId() == id) {
	            return occurrence;
	        }
	    }

	    return null;
	}
	

	public ArrayList<OccurrenceType> getOccurrenceTypes() {
		return new ArrayList<>(types);
	}
	
	
	//register employes only for admins
	public void registerEmployee(String name, String email, String password, Specialty specialty) {

	    if (name == null || name.isBlank()) {
	        System.out.println("Error: name cannot be empty.");
	        return;
	    }

	    if (!isEmailCorrect(email)) {
	        return;
	    }

	    if (!isPasswordValid(password)) {
	        return;
	    }

	    if (specialty == null) {
	        System.out.println("Error: specialty cannot be null.");
	        return;
	    }

	    Employee emp = new Employee(name, email, password, specialty);

	    employees.add(emp);
	    users.add(emp);
	    if (specialty.getEmployees() != null) {
	        specialty.getEmployees().add(emp);
	    }

	    System.out.println("Employee created successfully!");
	}
	
	
}

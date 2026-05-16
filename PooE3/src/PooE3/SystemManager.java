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
	

	
}

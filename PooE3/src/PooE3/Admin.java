/**
 * 
 */
package PooE3;

import java.util.ArrayList;

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
	
	//method to add an employee
	public void registerEmployee(String name, String email, String password, Specialty specialty, SystemManager manage) {

	    manage.registerEmployee(name, email, password, specialty);
	}
	
	
	
	//remove occurrence method only for admins
	public void removeOccurrence(ArrayList<Occurrence>occurrences, int id) {
		for (int i = 0; i< occurrences.size(); i++) {
			
			Occurrence oc = occurrences.get(i);
			
			if (oc.getId() == id) {
				if(oc.getStatus() == OccurrenceStatus.PENDING) {
					occurrences.remove(oc);
					System.out.println("Occurrence removed with success!");				}
			}
			
			else {
				System.out.println("Occurrence status is not pending. Not possible to remove");
			}
			
			return;
		}
		System.out.println("Occurrence not found!");
		
		
	}

	
	// Update occurrence status
	public void updateOccurrenceStatus(Occurrence occurrence, OccurrenceStatus newStatus) {
	    if (occurrence == null) {
	        System.out.println("Error: occurrence cannot be null.");
	        return;
	    }

	    occurrence.updateStatus(newStatus);
	}
	
	
	
	
	// Assign occurrence to employee
	public void assignOccurrence(Occurrence occurrence, Employee employee) {
	    if (occurrence == null) {
	        System.out.println("Error: occurrence cannot be null.");
	        return;
	    }

	    if (employee == null) {
	        System.out.println("Error: employee cannot be null.");
	        return;
	    }

	    occurrence.assignEmployee(employee);
	}	
	
}
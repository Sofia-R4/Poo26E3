/**
 * 
 */
package PooE3;

import java.util.ArrayList;

/**
 * 
 */
public class Employee extends User{
	private Specialty specialty;
	private String email;
	private ArrayList<Occurrence>occurrences;
	
	
	
	/**
	 * @param name
	 * @param password
	 */
	public Employee(String name, String email, String password, Specialty specialty) {
		super(name, password);
		// TODO Auto-generated constructor stub
	    this.email = email;
	    this.specialty = specialty;
	    this.occurrences = new ArrayList<>();
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
	
	public void updateAssignedOccurrenceStatus(int id) {
		for (Occurrence oc : occurrences) {
			if(oc.getId() == id) {
				if(oc.getAssignedEmployee() == this) {
					if(oc.getStatus() == OccurrenceStatus.IN_PROGRESS) {
						oc.setStatus(OccurrenceStatus.RESOLVED);
						
						System.out.println("State was updated");
					}
					else {
						System.out.println("Occurrence is in progress so it can not be updated.");
					}
				}
				
				else {
					System.out.println("Select occurrence don't belong to you.");
				}
				
				return; //encontrou a ococrrencia correta entao acabou o for
			}
		}
		
		System.out.println("This occurrence doesn't exist.");
	}
	
	public void viewAssignedOccurrences() {
		for (Occurrence oc : occurrences) {		
			if(oc.getAssignedEmployee() == this) {
				System.out.println("Your occurrences:");
				System.out.println("Description: " + oc.getDescription());
				System.out.println("Status: " + oc.getStatus());
				System.out.println("Location: " + oc.getLocation());
				System.out.println("Priority: " + oc.getPriority());
				System.out.println("Creation date: " + oc.getCreationDate());
			}
		}
	}
	
	public void canAcceptOccurrence(Occurrence o) {
	    if (getAssignedOccurrenceCount() == 3) {
	       System.out.println("This employee can not have more occurrences.");
	    } 
	    else {
	          occurrences.add(o);
	          System.out.println("Employee can have more occurrences");
	    }
	}
	
	public int getAssignedOccurrenceCount() {
	    int count = 0;
	    for (Occurrence oc : occurrences) {
	        if (oc.getAssignedEmployee() == this) {
	            count++;
	        }
	    }
	    System.out.println("This employee has: " + count + "occurrences");
	    return count;	
	}
	
	
	public void addCommentToOccurrence(int id, String commentt) {

	    for (Occurrence oc : occurrences) {

	        if (oc.getId() == id && oc.getAssignedEmployee() == this) {

	            Comment comment = new Comment(commentt, this);

	            oc.addComment(comment);

	            System.out.println("Comment added!");
	            return;
	        }
	    }

	    System.out.println("Occurrence not found.");
	}
	 
}


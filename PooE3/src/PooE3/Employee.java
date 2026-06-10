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
	
	public boolean canAcceptOccurrence() {
	    int pendingCount = 0;

	    for (Occurrence occurrence : occurrences) {
	        if (occurrence.getStatus() == OccurrenceStatus.IN_PROGRESS) {
	            pendingCount++;
	        }
	    }
	    return pendingCount < 3;
	}
	
	
	public int getAssignedOccurrenceCount() {
	    int count = 0;
	    for (Occurrence oc : occurrences) {
	        if (oc.getAssignedEmployee() == this) {
	            count++;
	        }
	    }
	    return count;	
	}
	
	
	public void addAssignedOccurrence(Occurrence occurrence) {
	    if (occurrence == null) {
	        System.out.println("Error: occurrence cannot be null.");
	        return;
	    }

	    if (!canAcceptOccurrence()) {
	        System.out.println("Error: employee already has 3 assigned occurrences.");
	        return;
	    }

	    if (occurrences.contains(occurrence)) {
	        System.out.println("Error: occurrence is already assigned to this employee.");
	        return;
	    }

	    occurrences.add(occurrence);
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
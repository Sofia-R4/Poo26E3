package PooE3;

import java.time.LocalDate;
import java.util.ArrayList;
// Needed for Users can see their occurrences sorted.
import java.util.Collections;
import java.util.Comparator;


public class AcademicUser extends User {

	private int userNumber;
	private ArrayList<Occurrence> occurrences;

	public AcademicUser(String name, int userNumber, String password) {
		super(name, password);

		this.userNumber = userNumber;
		this.occurrences = new ArrayList<>();
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	
	public ArrayList<Occurrence> getOccurrences() {
		return new ArrayList<>(occurrences);
	}


	

	public Occurrence createOccurrence(String description, String location, OccurrenceType type, Priority priority, SystemManager systemManager) {
		
		//if null or blank
		if (description == null || description.isBlank()) {
			System.out.println("Error: Description cannot be empty!");
			return null;
		}
		
		//if null or blank
		if (location == null || location.isBlank()) {
	            System.out.println("Error: location cannot be empty.");
	            return null;
	        }

	    if (type == null) {
	            System.out.println("Error: occurrence type cannot be null.");
	            return null;
	        }
	    
	    if (priority == null) {
	        System.out.println("Error: priority cannot be null.");
	        return null;
	    }

	    if (systemManager == null) {
	            System.out.println("Error: system manager cannot be null.");
	            return null;
	        }

		Occurrence occurrence = new Occurrence(				//new object
				description,
				location,
				priority,
				OccurrenceStatus.PENDING,
				LocalDate.now(),							//current time
				null,										//doesn't have values yet
				null,
				new ArrayList<Comment>(),					//list of comments for that occurrence
				this,
				type,
				null
		);

		
		// Adding the occurrence to the local list of the academic user
		occurrences.add(occurrence);

		
		// Registering occurrence in the global list of occurrences
		systemManager.addOccurrence(occurrence);
		
		System.out.println("Occurrence created successfully!");
		
		return occurrence;
	}

	
	
	//edit an Occurrence
	public boolean editOccurrence(int id, String newDescription) {
		

	    if (newDescription == null || newDescription.isBlank()) {
	        System.out.println("Error: description cannot be empty.");
	        return false;
	    }

		for (Occurrence occurrence : occurrences) {

			if (occurrence.getId() == id && occurrence.canBeEdited()) {

				occurrence.setDescription(newDescription);

				return true;
			}
		}

		return false;
	}


	//remove an Occurrence
	public boolean removeOccurrence(int id, String reason) {
		
	    if (reason == null || reason.isBlank()) {
	        System.out.println("Error: removal reason cannot be empty.");
	        return false;
	    }

		for (Occurrence occurrence : occurrences) {
			
			if (occurrence.getId() == id){
				
				if(occurrence.canBeRemoved()) {
					occurrence.markAsRemoved(reason);
				return true;
				
			} else {
				System.out.println("Error: occurrence cannot be removed because it is not pending.");
				return false;
				}
			}
		}
		System.out.println("Error: occurrence not found");
		return false;
	}
	
	
	 //Helper method for the method viewOccurrences()
	private int getPriorityValue(Priority priority) {
	    if (priority == Priority.HIGH) {
	        return 1;
	    }

	    if (priority == Priority.MEDIUM) {
	        return 2;
	    }

	    return 3;
	}
	
	//Allows Academic Users to check their occurrences sorted
	public void viewOccurrences() {
		//create a copy of the list (just to not chance the origin
		ArrayList<Occurrence> sortedOccurrences = new ArrayList<>(occurrences); 
		
		//order the list and create a comparator method
		Collections.sort(sortedOccurrences, new Comparator<Occurrence>() {
			@Override
			public int compare(Occurrence o1, Occurrence o2) {
				
				//takes the priority and converts it to a number and compares the numbers
				int priorityComparison = Integer.compare(
						getPriorityValue(o1.getPriority()),
						getPriorityValue(o2.getPriority())
						);
				//if is not 0, do the priorityComparsion
				if (priorityComparison != 0) {
					return priorityComparison;
				}
				//if priority are the same, compare creationdate
				return o1.getCreationDate().compareTo(o2.getCreationDate());
			}
		});
		
		if (sortedOccurrences.isEmpty()) {
			System.out.println("You have not created any occurrences yet.");
			return;
		}
		
		System.out.println("--My Occurrences--");

	    for (Occurrence occurrence : sortedOccurrences) {
	        System.out.println("ID: " + occurrence.getId());
	        System.out.println("Description: " + occurrence.getDescription());
	        System.out.println("Location: " + occurrence.getLocation());
	        System.out.println("Type: " + occurrence.getType());
	        System.out.println("Priority: " + occurrence.getPriority());
	        System.out.println("Status: " + occurrence.getStatus());
	        System.out.println("Creation date: " + occurrence.getCreationDate());

	    }
	}
	
}


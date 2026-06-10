package PooE3;

import java.time.LocalDate;
import java.util.ArrayList;

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

		if (description == null || description.isBlank()) {
			System.out.println("Error: Description cannot be empty!");
			return null;
		}
		
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

		Occurrence occurrence = new Occurrence(
				description,
				location,
				priority,
				OccurrenceStatus.PENDING,
				LocalDate.now(),
				null,
				null,
				new ArrayList<Comment>(),
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


	public boolean removeOccurrence(int id) {

		for (Occurrence occurrence : occurrences) {

			if (occurrence.getId() == id && occurrence.canBeRemoved()) {

				occurrence.markAsRemoved();

				return true;
			}
		}

		return false;
	}
}
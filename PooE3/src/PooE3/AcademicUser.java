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

	
	public Occurrence createOccurrence(int id, String description, String location) {

		OccurrenceType type = new OccurrenceType(
				1,
				"Other",
				"Generic occurrence"
		);

		Occurrence occurrence = new Occurrence(
				id,
				description,
				location,
				Priority.LOW,
				OccurrenceStatus.PENDING,
				LocalDate.now(),
				null,
				null,
				new ArrayList<Comment>(),
				this,
				type,
				null
		);

		occurrences.add(occurrence);

		return occurrence;
	}


	public boolean editOccurrence(int id, String newDescription) {

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
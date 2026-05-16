/**
 * 
 */
package PooE3;

/**
 * 
 */
import java.util.ArrayList;
import java.time.LocalDate;

public class Occurrence {
	
		private int id;
		private String description;
		private String location;
		private Priority priority;
		private OccurrenceStatus status;
		private LocalDate creationDate;
		private LocalDate resolutionDate;
		private String removalReason;
		private ArrayList<Comment> comments;
		private User createdBy;
		private OccurrenceType type;
		private Employee assignedEmployee;
		

}

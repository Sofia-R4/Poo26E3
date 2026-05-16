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
		/**
		 * @param id
		 * @param description
		 * @param location
		 * @param priority
		 * @param status
		 * @param creationDate
		 * @param resolutionDate
		 * @param removalReason
		 * @param comments
		 * @param createdBy
		 * @param type
		 * @param assignedEmployee
		 */
		
		
		
		public Occurrence(int id, String description, String location, Priority priority, OccurrenceStatus status,
				LocalDate creationDate, LocalDate resolutionDate, String removalReason, ArrayList<Comment> comments,
				User createdBy, OccurrenceType type, Employee assignedEmployee) {
			super();
			this.id = id;
			this.description = description;
			this.location = location;
			this.priority = priority;
			this.status = status;
			this.creationDate = creationDate;
			this.resolutionDate = resolutionDate;
			this.removalReason = removalReason;
			this.comments = comments;
			this.createdBy = createdBy;
			this.type = type;
			this.assignedEmployee = assignedEmployee;
		}
		

		

}

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
		

		public OccurrenceType getType() {
			return type;
		}


		public void setType(OccurrenceType type) {
			this.type = type;
		}
		
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getLocation() {
			return location;
		}


		public void setLocation(String location) {
			this.location = location;
		}


		public Priority getPriority() {
			return priority;
		}


		public void setPriority(Priority priority) {
			this.priority = priority;
		}


		public OccurrenceStatus getStatus() {
			return status;
		}


		public void setStatus(OccurrenceStatus status) {
			this.status = status;
		}


		public LocalDate getCreationDate() {
			return creationDate;
		}


		public void setCreationDate(LocalDate creationDate) {
			this.creationDate = creationDate;
		}


		public LocalDate getResolutionDate() {
			return resolutionDate;
		}


		public void setResolutionDate(LocalDate resolutionDate) {
			this.resolutionDate = resolutionDate;
		}


		public String getRemovalReason() {
			return removalReason;
		}


		public void setRemovalReason(String removalReason) {
			this.removalReason = removalReason;
		}


		public ArrayList<Comment> getComments() {
			return comments;
		}


		public void setComments(ArrayList<Comment> comments) {
			this.comments = comments;
		}


		public User getCreatedBy() {
			return createdBy;
		}


		public void setCreatedBy(User createdBy) {
			this.createdBy = createdBy;
		}


		public Employee getAssignedEmployee() {
			return assignedEmployee;
		}


		public void setAssignedEmployee(Employee assignedEmployee) {
			this.assignedEmployee = assignedEmployee;
		}


		public boolean canBeEdited() {

			return status == OccurrenceStatus.PENDING;
		}


		public boolean canBeRemoved() {

			return status == OccurrenceStatus.PENDING;
		}

	
		public void markAsRemoved() {

			this.removalReason = "Removed";
		}
	
		public void addComment(Comment comment) {
			comments.add(comment);
		}

}

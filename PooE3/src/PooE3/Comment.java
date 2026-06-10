/**
 * 
 */
package PooE3;

/**
 * 
 */
import java.time.LocalDate;

public class Comment {
	private int id;
	private static int nextId = 1;	
	private String text;
	private LocalDate postedDate;
	private User author;
	
	/**
	 * @param id
	 * @param text
	 * @param postedDate
	 * @param author
	 */
	
	
	public Comment(String text, User author) {
		
        if (text == null || text.isBlank()) {
            System.out.println("Error: comment text cannot be empty.");
            return;
        }

        if (author == null) {
            System.out.println("Error: comment author cannot be null.");
            return;
        }
        
		this.id = nextId++;
		this.text = text;
		this.postedDate = LocalDate.now();
		this.author = author;
	}
	
	
	
	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		 if (text == null || text.isBlank()) {
	            System.out.println("Error: comment text cannot be empty.");
	            return;
	        }
		 
		this.text = text;
	}
	
	public LocalDate getPostedDate() {
		return postedDate;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
        if (author == null) {
            System.out.println("Error: comment author cannot be null.");
            return;
        }
        
		this.author = author;
	}
	
	 @Override
	    public String toString() {
	        return "Comment ID: " + id +
	                "\nText: " + text +
	                "\nPosted date: " + postedDate +
	                "\nAuthor: " + author.getName();
	    }
}

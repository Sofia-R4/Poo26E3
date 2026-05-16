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
	private String text;
	private LocalDate postedDate;
	private User author;
	/**
	 * @param id
	 * @param text
	 * @param postedDate
	 * @param author
	 */
	
	
	public Comment(int id, String text, LocalDate postedDate, User author) {
		super();
		this.id = id;
		this.text = text;
		this.postedDate = postedDate;
		this.author = author;
	}
	
	
	
	
}

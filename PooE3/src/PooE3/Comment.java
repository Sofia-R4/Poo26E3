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
	
	public Comment(String text, User author) {  //metodo addcomment
	    this.text = text;
	    this.author = author;
	    this.postedDate = LocalDate.now();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDate getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	
}

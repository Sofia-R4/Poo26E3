/**
 * 
 */
package PooE3;

import java.util.ArrayList;

/**
 * 
 */
public class Admin extends User{

	private String email;

	public Admin(String name, String email, String password) {
		super(name, password);
		// TODO Auto-generated constructor stub
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//method to add an employee
	public void registerEmployee(ArrayList<User> users, Employee employee) {
        users.add(employee);
    }
	
	//remove occurrence method
	public void removeOccurrence(ArrayList<Occurrence> occurrences, Occurrence occurrence) {
		if(occurrence.getStatus() == OccurrenceStatus.PENDING) {
			occurrences.remove(occurrence);
			System.out.println("Ocorrência removida com sucesso!");
		}
		
		else {
			System.out.println("A ocorrência não pode ser removida pois já não está no estado Pendente.");
		}
	}
	
}
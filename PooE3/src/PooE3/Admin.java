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
	
	//remove occurrence method only for admins
	public void removeOccurrence(ArrayList<Occurrence>occurrences, int id) {
		for (int i = 0; i< occurrences.size(); i++) {
			
			Occurrence oc = occurrences.get(i);
			
			if (oc.getId() == id) {
				if(oc.getStatus() == OccurrenceStatus.PENDING) {
					occurrences.remove(oc);
					System.out.println("Occorrência removida com sucesso!");				}
			}
			
			else {
				System.out.println("A ocorrência já não está pendente, nao pode ser removida");
			}
			
			return;
		}
		System.out.println("Ocorrencia nao encotrada/numero de ocorrencia nao existe");
	}
	
}
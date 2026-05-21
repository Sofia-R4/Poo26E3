/**
 * 
 */
package PooE3;

import java.util.ArrayList;

/**
 * 
 */
public class Employee extends User{
	private Specialty specialty;
	private String email;
	private ArrayList<Occurrence>occurrences;
	
	
	
	/**
	 * @param name
	 * @param password
	 */
	public Employee(String name, String email, String password, Specialty specialty) {
		super(name, password);
		// TODO Auto-generated constructor stub
		
	}



	public Specialty getSpecialty() {
		return specialty;
	}

	


	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	public void updateAssignedOccurrenceStatus(int id) {
		for (Occurrence oc : occurrences) {
			if(oc.getId() == id) {
				if(oc.getAssignedEmployee() == this) {
					if(oc.getStatus() == OccurrenceStatus.IN_PROGRESS) {
						oc.setStatus(OccurrenceStatus.RESOLVED);
						
						System.out.println("O estado foi atualizado");
					}
					else {
						System.out.println("A ocorrência não está em progresso, logo não pode ser atualizada");
					}
				}
				
				else {
					System.out.println("A ocorrência selecionada não está sobre a tua juridiação");
				}
				
				return; //encontrou a ococrrencia correta entao acabou o for
			}
		}
		
		System.out.println("Esta ocorrência não existe");
	}
	
	public void viewAssignedOccurrences() {
		for (Occurrence oc : occurrences) {		
			if(oc.getAssignedEmployee() == this) {
				System.out.println("As ocurrencias que te pertencem são:");
				System.out.println("Descrição: " + oc.getDescription());
				System.out.println("Status: " + oc.getStatus());
				System.out.println("Location: " + oc.getLocation());
				System.out.println("Priority: " + oc.getPriority());
				System.out.println("Data: " + oc.getCreationDate());
			}
		}
		
	}
	
	public boolean canAcceptOccurrence() {
		return false;
		
	}
	
	public int getAssignedOccurrenceCount() {
		return 0;
		
	}
}

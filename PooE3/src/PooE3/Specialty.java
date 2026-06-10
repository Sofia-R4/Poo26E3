/**
 * 
 */
package PooE3;

/**
 * 
 */

import java.util.ArrayList;

public class Specialty {
	
	private int id;
	private String name;
	private ArrayList<Employee> employees;
	
	
	/**
	 * @param id
	 * @param name
	 * @param employees
	 */
	public Specialty(int id, String name, ArrayList<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	
	@Override
	public String toString() {
	    return name;
	}	
	
}

/**
 * 
 */
package PooE3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SystemManager manage = new SystemManager();
		Scanner input = new Scanner(System.in);
		
		boolean continuar = true;
		int opcao = 0;
		while(true) {
			System.out.println("------Create an account!------");
			System.out.println("1 - Create an account as Academic User");
			System.out.println("2 - Create an account as Admin");
			System.out.println("");
			
			System.out.println("------Login with your account!------");
			System.out.println("3 - Login as Employee");
			System.out.println("4 - Login as Academic User");
			System.out.println("5 - Login as Admin");
			System.out.println("");
			
			System.out.println("0 - Leave");
			
			
			try {

		        opcao = Integer.parseInt(input.nextLine());

		    } catch(NumberFormatException e) {

		        System.out.println("Introduce a valid number.");
		        continue;
		    }
			
			switch(opcao) {
			case 1:
				System.out.println("Name: ");
				String nomeCAS = input.nextLine();
				
				System.out.println("Student number: ");
				int numberCAS = input.nextInt();
				input.nextLine();
				
				System.out.println("Password: ");
				String passwordCAS = input.nextLine();
				
				if(manage.isPasswordValid(passwordCAS)) {
					User userS = new AcademicUser(nomeCAS, numberCAS, passwordCAS);
					manage.addUser(userS);	
				}
				
				break;
				
			case 2:
				System.out.println("Name: ");
				String nomeA = input.nextLine();
				
				System.out.println("Email: ");
				String emailA = input.nextLine();
				
				System.out.println("Password: ");
				String passwordA = input.nextLine();
				
				if(manage.isPasswordValid(passwordA) && manage.isEmailCorrect(emailA)) {
					User userA = new Admin(nomeA, emailA, passwordA);
					manage.addUser(userA);	
				}
				
				break;
				
			case 3:
				
				System.out.println("Email: ");
			    String emailLE = input.nextLine();

			    System.out.println("Password: ");
			    String passwordLE = input.nextLine();

			    Employee emp = manage.loginEmployee(passwordLE, emailLE);

			    if(emp != null) {

			        System.out.println("Logged in!");

			        boolean loggedE = true;

			        while(loggedE) {

			            System.out.println("------ MENU EMPLOYEE ------");
			            System.out.println("1 - My occurrences");
			            System.out.println("2 - End occurrence");
			            System.out.println("3 - Add comments");
			            System.out.println("0 - Logout");

			            int optionE;
			            
			            try {

			                optionE = input.nextInt();
			                input.nextLine();

			            } catch(NumberFormatException e) {

			                System.out.println("Introduce a valid number.");
			                continue;
			            }

			            switch(optionE) {
			            	case 1:
			            		emp.viewAssignedOccurrences();
			            		
			            		break;
			            		
			            	case 2:
			            		System.out.println("Insert the number of the occurrence: ");
			            		int id = input.nextInt();
			            		input.nextLine();
			            		
			            		emp.updateAssignedOccurrenceStatus(id);
			            		
			            		break;
			            		
			            	case 3:
			            		System.out.println("Insert the number of the occurrence: ");
			            		int id3 = input.nextInt();
			            		input.nextLine();
			            		
			            		System.out.println("Insert your comment: ");
			            		String comment3 = input.nextLine();
			            		
			            		emp.addCommentToOccurrence(id3, comment3);
			            		
			            		break;
			            		
			            	case 0:
			            		System.out.println("Logout...");
			            	    loggedE = false;
			            	    break;		            		
			            		
			            }
		            
		            }
				}
				
				break;
				
			case 4:			

					System.out.println("Number: ");
					int numberLAU = Integer.parseInt(input.nextLine());
					
					System.out.println("Password: ");
					String passwordLAU = input.nextLine();
					
					AcademicUser au = manage.loginAcademicUser(passwordLAU, numberLAU);

				
					if(au != null) {
						boolean loggedAU = true;
						
						while (loggedAU) {
						
							System.out.println("------ MENU ACADEMIC USER ------");
							System.out.println("1 - Register occurrence.");
							System.out.println("2 - View my occurrences.");
							System.out.println("3 - Edit occurrence.");
							System.out.println("4 - Remove occurrence");
							System.out.println("0 - Logout");

							int optionAU = input.nextInt();
							input.nextLine();

							try {

				                optionAU = input.nextInt();
				                input.nextLine();

				            } catch(NumberFormatException e) {

				                System.out.println("Introduce a valid number.");
				                continue;
				            }

							
							switch(optionAU) {
			            
							case 1:

							    System.out.println("Description:");
							    String description = input.nextLine();

							    System.out.println("Location:");
							    String location = input.nextLine();

							    ArrayList<OccurrenceType> types = manage.getOccurrenceTypes();

							    if (types.isEmpty()) {
							        System.out.println("There are no occurrence types available.");
							        break;
							    }

							    System.out.println("Available occurrence types:");

							    for (OccurrenceType type : types) {
							        System.out.println(
							            "ID: " + type.getId() +
							            "Name: " + type.getName() +
							            "Description: " + type.getDescription()
							        );
							    }

							    System.out.println("Choose the type ID:");
							    int typeId;

							    try {
							        typeId = Integer.parseInt(input.nextLine());
							    } catch (NumberFormatException e) {
							        System.out.println("Invalid ID.");
							        break;
							    }

							    OccurrenceType selectedType = manage.findOccurrenceTypeById(typeId);

							    if (selectedType == null) {
							        System.out.println("Occurrence type not found.");
							        break;
							    }

							    au.createOccurrence(description, location, selectedType,manage);

							    break;
							    
							case 2:
								au.getOccurrences();
								break;
								
							case 3:
								System.out.println("ID: ");
								int id = input.nextInt();
								input.nextLine();
								
								System.out.println("Insert the new description: ");
								String newDescription = input.nextLine();
								
								au.editOccurrence(id, newDescription);
								break;
								
							case 4:
								System.out.println("Insert the id of your occurrence to remove it: ");
								int idR = input.nextInt();
								input.nextLine();
								
								au.removeOccurrence(idR);
								
								break;
								
							case 0:
								System.out.println("Logout...");
			            	    loggedAU = false;
			            	    break;
			            
			            }
					}
				}
						
				break;
				
			case 5:
				System.out.println("Email: ");
				String emailLA = input.nextLine();
				
				System.out.println("Password: ");
				String passwordLA = input.nextLine();
				
				Admin adm = manage.loginAdmin(passwordLA, emailLA);
				
				
				if(adm != null) {
					boolean loggedA = true;
					
					while (loggedA) {
						
						System.out.println("------ MENU ADMIN ------");
			            System.out.println("1 - Register employees.");
			            System.out.println("2 - Create Specialty.");
			            System.out.println("0 - Logout");

			            int optionA = Integer.parseInt(input.nextLine());

			            switch(optionA) {
			            
			            	case 1:
			            		System.out.println("Insert the name: ");
			            		String nameFun = input.nextLine();
			            		
			            		System.out.println("Insert the email: ");
			            		String emailFun = input.nextLine();
			            		
			            		System.out.println("Insert the password: ");
			            		String passwordFun = input.nextLine();
			            		
			            
			            }
					}
				}
				
				
				break;
				
			case 0:
				System.out.println("Out...");
				return;
			}
		}
	}
}

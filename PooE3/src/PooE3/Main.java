/**
 * 
 */
package PooE3;

import java.util.ArrayList;
import java.util.Map;
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
		
		while(true) {
			System.out.println("------Main menu------");
			System.out.println("1 - Create an account as Academic User");
			System.out.println("2 - Create an account as Admin");
			System.out.println("3 - Login");
			System.out.println("");
			System.out.println("0 - Leave");
			
			int opcao;
			
			
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
				
				System.out.println("Academic number: ");
				int numberCAS;
				
				try {
					numberCAS = Integer.parseInt(input.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("Invalid academic number.");
					break;
				}

				System.out.println("Password: ");
				String passwordCAS = input.nextLine();
				
				if(manage.isPasswordValid(passwordCAS)) {
					AcademicUser academicUser = new AcademicUser(nomeCAS, numberCAS, passwordCAS);
					manage.addUser(academicUser);	
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
					Admin admin = new Admin(nomeA, emailA, passwordA);
					manage.addUser(admin);	
				}
				
				break;
				
				
			case 3:
				
				System.out.println("Email or Academic Number: ");
			    String credentialUser = input.nextLine();

			    System.out.println("Password: ");
			    String passwordUser = input.nextLine();

			    User loggedUser = manage.login(credentialUser, passwordUser);
			    
                if (loggedUser == null) {
                    break;
                }
                
                // Academic User Menu
			    	if(loggedUser instanceof AcademicUser	) {
			    
			    		AcademicUser academicUser = (AcademicUser) loggedUser;
			    		boolean loggedAcademic = true;

			    			while (loggedAcademic) {
			    				System.out.println("--- MENU ACADEMIC USER ---");
			    				System.out.println("1 - Register occurrence");
			    				System.out.println("2 - View my occurrences");
			    				System.out.println("3 - Edit occurrence");
			    				System.out.println("4 - Remove occurrence");
			    				System.out.println("0 - Logout");

			    				int academicOption;

			    				try {
			    					academicOption = Integer.parseInt(input.nextLine());
			    				} catch (NumberFormatException e) {
			    					System.out.println("Introduce a valid number.");
			    					continue;
			    				}
                        
			    				switch (academicOption) {
                        
			    				
			    				
			    			//To Register a new Occurrence	
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
                                        "ID: " + type.getId() + " / Name: " + type.getName() +
                                        " / Description: " + type.getDescription()
                                );
                            	}

                            	System.out.println("Choose the type ID:");
                            	int typeId;

                            	try {
                            		typeId = Integer.parseInt(input.nextLine());
                            	} catch (NumberFormatException e) {
                            		System.out.println("Invalid type ID.");
                            		break;
                            	}

                            	OccurrenceType selectedType = manage.findOccurrenceTypeById(typeId);

                            	if (selectedType == null) {
                            		System.out.println("Occurrence type not found.");
                            		break;
                            	}

                            	System.out.println("Choose priority:");
                            	System.out.println("1 - HIGH");
                            	System.out.println("2 - MEDIUM");
                            	System.out.println("3 - LOW");

                            	int priorityOption;

                            	try {
                            		priorityOption = Integer.parseInt(input.nextLine());
                            	} catch (NumberFormatException e) {
                            		System.out.println("Invalid priority.");
                            		break;
                            		}
                            	
                      
                            	Priority selectedPriority = null;
                            	
                            	
                            	
                            	switch (priorityOption) {
                                case 1:
                                    selectedPriority = Priority.HIGH;
                                    break;

                                case 2:
                                    selectedPriority = Priority.MEDIUM;
                                    break;

                                case 3:
                                    selectedPriority = Priority.LOW;
                                    break;

                                default:
                                    System.out.println("Invalid priority.");
                                    break;
                            	}

                            	if (selectedPriority == null) {
                            		break;
                            	}

                            	academicUser.createOccurrence(
                            			description,
                            			location,
                            			selectedType,
                            			selectedPriority,
                            			manage
                            			);

                            	break;
                            
                            // To view occurrences
			    			case 2:
                                academicUser.viewOccurrences();
                                break;
                                
                                
                            // To edit an occurrence
			    			case 3:
                                System.out.println("ID of occurrence to edit:");
                                int editId;

                                try {
                                    editId = Integer.parseInt(input.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid ID.");
                                    break;
                                }

                                System.out.println("New description:");
                                String newDescription = input.nextLine();

                                academicUser.editOccurrence(editId, newDescription);
                                break;

                                
                            // To remove an occurrence
                                
			    			case 4:
                                 System.out.println("ID of occurrence to remove:");
                                 int removeId;

                                 try {
                                     removeId = Integer.parseInt(input.nextLine());
                                 } catch (NumberFormatException e) {
                                     System.out.println("Invalid ID.");
                                     break;
                                 }

                                 System.out.println("Removal reason:");
                                 String reason = input.nextLine();

                                 academicUser.removeOccurrence(removeId, reason);
                                 break;
                                 
                                 
			    			case 0:
                                System.out.println("Logout...");
                                loggedAcademic = false;
                                break;
                                
                                

                            default:
                                System.out.println("Invalid option.");
                                break;
                            
			    			}
			    		}
			    	}
			    	
			    	
			    	
			    	// Employee menu
			    	else if (loggedUser instanceof Employee) {
                        Employee employee = (Employee) loggedUser;
                        boolean loggedEmployee = true;

                        while (loggedEmployee) {
                            System.out.println("------ MENU EMPLOYEE ------");
                            System.out.println("1 - My occurrences");
                            System.out.println("2 - Resolve occurrence");
                            System.out.println("3 - Add comment");
                            System.out.println("0 - Logout");

                            int employeeOption;

                            try {
                                employeeOption = Integer.parseInt(input.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Introduce a valid number.");
                                continue;
                            }

                            switch (employeeOption) {

                                case 1:
                                    employee.viewAssignedOccurrences();
                                    break;

                                case 2:
                                    System.out.println("ID of occurrence to resolve:");
                                    int resolveId;

                                    try {
                                        resolveId = Integer.parseInt(input.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid ID.");
                                        break;
                                    }

                                    Occurrence occurrenceToResolve = manage.findOccurrenceById(resolveId);

                                    if (occurrenceToResolve == null) {
                                        System.out.println("Occurrence not found.");
                                        break;
                                    }

                                    employee.resolveOccurrence(occurrenceToResolve);
                                    break;

                                case 3:
                                    System.out.println("ID of occurrence:");
                                    int commentOccurrenceId;

                                    try {
                                        commentOccurrenceId = Integer.parseInt(input.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid ID.");
                                        break;
                                    }

                                    System.out.println("Comment:");
                                    String commentText = input.nextLine();

                                    employee.addCommentToOccurrence(commentOccurrenceId, commentText);
                                    break;

                                case 0:
                                    System.out.println("Logout...");
                                    loggedEmployee = false;
                                    break;

                                default:
                                    System.out.println("Invalid option.");
                                    break;
                            }
                        }
                    }
			    	
			    	
			    	// Admin Menu
			    	else if (loggedUser instanceof Admin) {
			        Admin admin = (Admin) loggedUser;

			        boolean loggedA = true;

			        while(loggedA) {

			            System.out.println("------ MENU EMPLOYEE ------");
			            System.out.println("1 - Register employee");
			            System.out.println("2 - Create specialty");
			            System.out.println("3 - View all occurrences");
			            System.out.println("4 - Assign occurrence to employee");
			            System.out.println("5 - Update occurrence status");
			            System.out.println("6 - View resolved occurrences");
			            System.out.println("7 - View occurrence totals by type");
			            System.out.println("0 - Logout");

			            int optionA;
			            
			            try {

			                optionA = input.nextInt();
			                input.nextLine();

			            } catch(NumberFormatException e) {

			                System.out.println("Introduce a valid number.");
			                continue;
			            }
			            

			            switch(optionA) {
			            
			            	// View the assigned occurrences to this employee
			            	case 1:
			            		ArrayList<Specialty> specialties = manage.getSpecialties();
			            		
			            		if (specialties.isEmpty()) {
                                    System.out.println("There are no specialties. Create a specialty first.");
                                    break;
                                }

                                System.out.println("Employee name:");
                                String employeeName = input.nextLine();

                                System.out.println("Employee email:");
                                String employeeEmail = input.nextLine();

                                System.out.println("Employee password:");
                                String employeePassword = input.nextLine();

                                System.out.println("Available specialties:");

                                for (Specialty specialty : specialties) {
                                    System.out.println(
                                            "ID: " + specialty.getId() +
                                            " / Name: " + specialty.getName()
                                    );
                                }

                                System.out.println("Choose specialty ID:");
                                int specialtyId;

                                try {
                                    specialtyId = Integer.parseInt(input.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid specialty ID.");
                                    break;
                                }

                                Specialty selectedSpecialty = manage.findSpecialtyById(specialtyId);

                                if (selectedSpecialty == null) {
                                    System.out.println("Specialty not found.");
                                    break;
                                }

                                admin.registerEmployee(
                                        employeeName,
                                        employeeEmail,
                                        employeePassword,
                                        selectedSpecialty,
                                        manage
                                );
			            
			            		break;
			            		
			            	// To add a new specialty
			            	case 2:
			            		System.out.println("Specialty name:");
                                String specialtyName = input.nextLine();

                                if (specialtyName == null || specialtyName.isBlank()) {
                                    System.out.println("Specialty name cannot be empty.");
                                    break;
                                }

                                Specialty specialty = new Specialty(
                                        manage.generateSpecialtyId(),
                                        specialtyName,
                                        new ArrayList<Employee>()
                                );

                                manage.addSpecialty(specialty);
                                break;
			            		
                                
			            	// To view all the occurrences
			            	case 3:
			            		ArrayList<Occurrence> occurrences = manage.getOccurrences();

                                if (occurrences.isEmpty()) {
                                    System.out.println("There are no occurrences.");
                                    break;
                                }

                                System.out.println("-----/ ALL OCCURRENCES /------");

                                for (Occurrence occurrence : occurrences) {
                                    System.out.println("ID: " + occurrence.getId());
                                    System.out.println("Description: " + occurrence.getDescription());
                                    System.out.println("Location: " + occurrence.getLocation());
                                    System.out.println("Type: " + occurrence.getType());
                                    System.out.println("Priority: " + occurrence.getPriority());
                                    System.out.println("Status: " + occurrence.getStatus());
                                    System.out.println("Creation date: " + occurrence.getCreationDate());

                                    if (occurrence.getAssignedEmployee() != null) {
                                        System.out.println("Assigned employee: " + occurrence.getAssignedEmployee().getName());
                                    } else {
                                        System.out.println("No employeee assigned.");
                                    }
                                }

			            		break;
			            		
			            		
			            	//To assign an occurrence to an employee
			            	case 4:
			            		System.out.println("Occurrence ID: ");
			            		int occurrenceId;
			            		
			            		try {
			            			occurrenceId = Integer.parseInt(input.nextLine());
			            		} catch (NumberFormatException e) {
			            			System.out.println("Invalid occurrence ID");
			            			break;
			            		}
			            		
			            		
                                Occurrence occurrenceToAssign = manage.findOccurrenceById(occurrenceId);

                                if (occurrenceToAssign == null) {
                                    System.out.println("Occurrence not found.");
                                    break;
                                }

                                System.out.println("Choose employee specialty first:");

                                ArrayList<Specialty> availableSpecialties = manage.getSpecialties();

                                if (availableSpecialties.isEmpty()) {
                                    System.out.println("No specialties available.");
                                    break;
                                }

                                for (Specialty sp : availableSpecialties) {
                                    System.out.println("ID: " + sp.getId() + " / Name: " + sp.getName());
                                }

                                System.out.println("Specialty ID:");
                                int employeeSpecialtyId;

                                try {
                                    employeeSpecialtyId = Integer.parseInt(input.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid specialty ID.");
                                    break;
                                }

                                Specialty employeeSpecialty = manage.findSpecialtyById(employeeSpecialtyId);

                                if (employeeSpecialty == null) {
                                    System.out.println("Specialty not found.");
                                    break;
                                }

                                ArrayList<Employee> employeesBySpecialty = manage.getEmployeesBySpecialty(employeeSpecialty);

                                if (employeesBySpecialty.isEmpty()) {
                                    System.out.println("No employees with that specialty.");
                                    break;
                                }

                                System.out.println("Available employees:");

                                for (int i = 0; i < employeesBySpecialty.size(); i++) {
                                    Employee emp = employeesBySpecialty.get(i);

                                    System.out.println(
                                            (i + 1) + " - " +
                                            emp.getName() +
                                            " / Specialty: " + emp.getSpecialty() +
                                            " / Assigned occurrences: " + emp.getAssignedOccurrenceCount()
                                    );
                                }

                                System.out.println("Choose employee number:");
                                int employeeChoice;

                                try {
                                    employeeChoice = Integer.parseInt(input.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid employee choice.");
                                    break;
                                }

                                if (employeeChoice < 1 || employeeChoice > employeesBySpecialty.size()) {
                                    System.out.println("Invalid employee choice.");
                                    break;
                                }

                                Employee selectedEmployee = employeesBySpecialty.get(employeeChoice - 1);

                                admin.assignOccurrence(occurrenceToAssign, selectedEmployee);
                                break;
                                
                            // Update occurrence status
			            	case 5:
                                System.out.println("Occurrence ID:");
                                int statusOccurrenceId;

                                try {
                                    statusOccurrenceId = Integer.parseInt(input.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid occurrence ID.");
                                    break;
                                }

                                Occurrence occurrenceToUpdate = manage.findOccurrenceById(statusOccurrenceId);

                                if (occurrenceToUpdate == null) {
                                    System.out.println("Occurrence not found.");
                                    break;
                                }

                                System.out.println("Choose new status:");
                                System.out.println("1 - PENDING");
                                System.out.println("2 - IN_PROGRESS");
                                System.out.println("3 - RESOLVED");
                                System.out.println("4 - REMOVED");

                                int statusOption;

                                try {
                                    statusOption = Integer.parseInt(input.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid status option.");
                                    break;
                                }

                                OccurrenceStatus selectedStatus = null;

                                switch (statusOption) {
                                    case 1:
                                        selectedStatus = OccurrenceStatus.PENDING;
                                        break;

                                    case 2:
                                        selectedStatus = OccurrenceStatus.IN_PROGRESS;
                                        break;

                                    case 3:
                                        selectedStatus = OccurrenceStatus.RESOLVED;
                                        break;

                                    case 4:
                                        selectedStatus = OccurrenceStatus.REMOVED;
                                        break;

                                    default:
                                        System.out.println("Invalid status option.");
                                        break;
                                }

                                if (selectedStatus == null) {
                                    break;
                                }

                                admin.updateOccurrenceStatus(occurrenceToUpdate, selectedStatus);
                                break;
                                
                             
                            // Get all the resolved occurrences.   
			            	case 6:
                                manage.getResolvedOccurrences();
                                break;
                               
                            // View all occurrences by type
                            case 7:
                                Map<OccurrenceType, Integer> totals = manage.getOccurrenceTotalsByType();

                                if (totals.isEmpty()) {
                                    System.out.println("There are no occurrence statistics yet.");
                                    break;
                                }

                                System.out.println("-----/ OCCURRENCE TOTALS BY TYPE /-----");

                                for (OccurrenceType type : totals.keySet()) {
                                    System.out.println(type + ": " + totals.get(type));
                                }

                                break;
                                
			            	//Logout
			            	case 0:
			            		System.out.println("Logout...");
			            	    loggedA = false;
			            	    break;		  
			            	    
			            	default:
			            		System.out.println("Invalid option.");
			            		break;
			            }
		            }
				}
				
				break;
				

            case 0:
                System.out.println("Out...");
                input.close();
                return;

            default:
                System.out.println("Invalid option.");
                break;
        }
    }
}
}
/**
 * 
 */
package PooE3;

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
			
			
			System.out.println("------Login with your account!------");
			System.out.println("3 - Login as Employee");
			System.out.println("4 - Login as Academic User");
			System.out.println("5 - Login as Admin");
			
			
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
				
				manage.loginEmployee(passwordLE, emailLE);
				
				boolean loggedE = true;
				
				while (loggedE) {
					
					System.out.println("------ MENU EMPLOYEE ------");
		            System.out.println("1 - ");
		            System.out.println("2 - ");
		            System.out.println("0 - Logout");

		            int optionE = Integer.parseInt(input.nextLine());

		            switch(optionE) {
		            
		            }
				}
				
				break;
				
			case 4:			
				
				try {

					System.out.println("Number: ");
					int numberLAU = Integer.parseInt(input.nextLine());
					
					System.out.println("Password: ");
					String passwordLAU = input.nextLine();
					
					manage.loginAcademicUser(passwordLAU, numberLAU);

				} catch(NumberFormatException e) {

				    System.out.println("Introduce a valid number.");
				}
				
				boolean loggedAU = true;
				
				while (loggedAU) {
					
					System.out.println("------ MENU ACADEMIC USER ------");
		            System.out.println("1 - ");
		            System.out.println("2 - ");
		            System.out.println("0 - Logout");

		            int optionAU = Integer.parseInt(input.nextLine());

		            switch(optionAU) {
		            
		            }
				}
				
				break;
				
			case 5:
				System.out.println("Email: ");
				String emailLA = input.nextLine();
				
				System.out.println("Password: ");
				String passwordLA = input.nextLine();
				
				manage.loginAdmin(passwordLA, emailLA);
				
				boolean loggedA = true;
				
				while (loggedA) {
					
					System.out.println("------ MENU ADMIN ------");
		            System.out.println("1 - ");
		            System.out.println("2 - ");
		            System.out.println("0 - Logout");

		            int optionA = Integer.parseInt(input.nextLine());

		            switch(optionA) {
		            
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

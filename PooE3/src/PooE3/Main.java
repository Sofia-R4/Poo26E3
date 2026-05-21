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
		int opcao;
		while(true) {
			System.out.println("1 - Criar conta como estudante");
			System.out.println("2 - Criar conta como administrador");
			System.out.println("3 - Login como funcionário");
			System.out.println("0 - Sair");
			
			
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
			case 1:
				System.out.println("Nome: ");
				String nome = input.nextLine();
				
				System.out.println("Número de estudante: ");
				int numero = input.nextInt();
				input.nextLine();
				
				System.out.println("Password: ");
				String password = input.nextLine();
				
				User user = new AcademicUser(nome, numero, password);
				manage.addUser(user);
				
				System.out.println("Utilizador registado com sucesso!");
				break;
				
			case 2:
				System.out.println("Nome: ");
				String nomeA = input.nextLine();
				
				System.out.println("Email: ");
				String emailA = input.nextLine();
				
				System.out.println("Password: ");
				String passwordA = input.nextLine();
				
				User userA = new Admin(nomeA, emailA, passwordA);
				manage.addUser(userA);
				
				System.out.println("Administrador registado com sucesso!");
				
				break;
				
			}
		}
		

	}

}

import java.util.Scanner;
import java.io.*;

public class Menu {
	
	
	//MENU
		public static void menu(){
		
			int loopformenu = 0;
			
			do{
			System.out.println("\n" + "     Menu     ");
			System.out.println("Australia				1");
			System.out.println("Artantica				2");
			System.out.println("Offshore				3");
			System.out.println("Favourite				4");
			System.out.println("Quit					5");
			
			System.out.println("\n" +"Your choice: ");
			
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			
			
			switch(choice){
			case 1: 
				australia();
				break;
			
			case 2: 
				artantica();
				break;
				
			case 3: 
				offshore();
				break;
				
			case 4: 
				favourite();
				break;	
			
			case 5: 
				System.exit(0);
			}
			loopformenu = 0;
		}
			while (loopformenu != 6);
		}

		
		//Method for Menu
		public static void australia()
		{
			System.out.println("\n" + "     Choose State     ");
			System.out.println("Victoria				1");
			System.out.println("Queensland				2");
			System.out.println("\n" +"Your choice: ");
			
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			
			switch(choice){
			case 1: 
				System.out.println("\n" + "     Choose City     ");
				System.out.println("Melbourne				1");
				System.out.println("Geelong					2");
				System.out.println("\n" +"Your choice: ");
				
				Scanner scanner2 = new Scanner(System.in);
				int location1 = scanner.nextInt();
				break;
			
			case 2: 
				System.out.println("\n" + "     Choose City     ");
				System.out.println("Brisbane				1");
				System.out.println("Cairns					2");
				System.out.println("\n" +"Your choice: ");
				
				Scanner scanner3 = new Scanner(System.in);
				int location2 = scanner.nextInt();
				break;
			}
		}
		
		public static void artantica()
		{
			System.out.println("\n" + "     Choose Location     ");
			System.out.println("Casey				1");
			System.out.println("Davis				2");
			System.out.println("\n" +"Your choice: ");
			
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			
			switch(choice){
			case 1: 
				break;
			
			case 2:
				break;
			}
			 
		}
		
		public static void offshore()
		{
			System.out.println("\n" + "     Choose Location     ");
			System.out.println("Macquarie Island				1");
			System.out.println("Christmas Island				2");
			System.out.println("Flinders Reef					3");
			System.out.println("\n" +"Your choice: ");
			
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			
			switch(choice){
			case 1: 
				break;
			
			case 2:
				break;
				
			case 3:
				break;
			}
		}
		
		public static void favourite()
		{
			System.out.println("Hello World");
		}
		

		public static void main(String[] args)
		{
			Menu test = new Menu();
			Menu.menu(); 
		}
}

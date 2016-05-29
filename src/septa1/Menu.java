package septa1;

import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class Menu {
	
	
	//MENU
		public static void menu(){
		
			int loopformenu = 0;
			
			do{
			System.out.println("\n" + "     Menu     ");
			System.out.println("Australia				1");
			System.out.println("Antarctica				2");
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
				antarctica();
				break;
				
			case 3: 
				offshore();
				break;
				
			case 4: 
				favourite();
				break;	
			
			case 5: 
				System.exit(0);
				
			default:
				System.out.println("Invalid input");
				break;
			}
			loopformenu = 0;
		}
			while (loopformenu != 5);
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
				if (location1 == 1)
					Report.printReport("0");
				if (location1 == 2)
					Report.printReport("1");
				break;
			
			case 2: 
				System.out.println("\n" + "     Choose City     ");
				System.out.println("Brisbane				1");
				System.out.println("Cairns					2");
				System.out.println("\n" +"Your choice: ");
				
				Scanner scanner3 = new Scanner(System.in);
				int location2 = scanner.nextInt();
				if (location2 == 1)
					Report.printReport("2");
				if (location2 == 2)
					Report.printReport("3");
				break;
			}
		}
		
		public static void antarctica()
		{
			System.out.println("\n" + "     Choose Location     ");
			System.out.println("Casey				1");
			System.out.println("Davis				2");
			System.out.println("\n" +"Your choice: ");
			
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			
			String Location;
			
			switch(choice){
			case 1: 
				Location = new String("4");
				Report.printReport(Location);
				break;
			
			case 2:
				Location = new String("5");
				Report.printReport(Location);
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
			
			String Location;
			
			switch(choice){
			case 1: 
				Location = new String("6");
				Report.printReport(Location);
				break;
			
			case 2:
				Location = new String("7");
				Report.printReport(Location);
				break;
				
			case 3:
				Location = new String("8");
				Report.printReport(Location);
				break;
			}
		}
		
		public static void favourite()
		{
			System.out.println("Working in Progress.");
		}
}
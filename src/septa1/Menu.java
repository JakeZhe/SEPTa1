package septa1;

import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

import refresh.ReadURL;

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
				if (location1 == 1){
					System.out.println("Report for Melbourne");
					Report.printReport("0");
					ReadURL.forecast("-37.8200","144.9650");
				}
				if (location1 == 2){
					System.out.println("Report for Geelong");
					Report.printReport("1");
					ReadURL.forecast("-38.1493","144.3598");
				}
				break;
			
			case 2: 
				System.out.println("\n" + "     Choose City     ");
				System.out.println("Brisbane				1");
				System.out.println("Cairns					2");
				System.out.println("\n" +"Your choice: ");
				
				Scanner scanner3 = new Scanner(System.in);
				int location2 = scanner.nextInt();
				if (location2 == 1){
					System.out.println("Report for Brisbane");
					Report.printReport("2");
					ReadURL.forecast("-27.4685","153.0234");
				}	
				if (location2 == 2){
					System.out.println("Report for Cairns");
					Report.printReport("3");
					ReadURL.forecast("-16.9196","145.7737");
				}
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
				System.out.println("Report for Casey");
				Report.printReport(Location);
				System.out.println("Forecast unavailable");
				break;
			
			case 2:
				Location = new String("5");
				System.out.println("Report for Davis");
				Report.printReport(Location);
				System.out.println("Forecast unavailable");
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
				System.out.println("Report for Macquarie Island");
				Report.printReport(Location);
				ReadURL.forecast("-54.6318","158.8618");
				break;
			
			case 2:
				Location = new String("7");
				System.out.println("Report for Christmas Island");
				Report.printReport(Location);
				ReadURL.forecast("-10.4878","105.6330");
				break;
				
			case 3:
				Location = new String("8");
				System.out.println("Report for Flinders Reef");
				Report.printReport(Location);
				ReadURL.forecast("-26.9790","153.4850");
				break;
			}
		}
		
		public static void favourite()
		{
			System.out.println("Working in Progress.");
		}
}
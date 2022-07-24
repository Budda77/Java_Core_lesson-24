/*
 * LOGOS It Academy home work 24
 * 
 * */

package ua.lviv.lgs.homeworkCinema;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Cinema cinema = new Cinema();
		Scanner number = new Scanner(System.in);

		while(true) {
			menu();

			switch(number.nextInt()) {
			case 1:{

				System.out.println("Enter the number of the day of the week:");
				System.out.println("Sunday = 0, Monday= 1, Tuesday= 2, Wednesday= 3, Thursday= 4, Friday= 5, Saturday= 6.");
				Scanner sc = new Scanner(System.in);
				int dayOfWeek = sc.nextInt();
				cinema.addSeancesForDay(dayOfWeek);
				cinema.showSchedyle2();

				break;
			}	
			case 2:{
				cinema.showSchedyle2();		
				break;
			}
			case 3:{
				System.out.println("Enter a day of seance.");
				Scanner sc = new Scanner(System.in);
				String dayOfSeance = sc.nextLine().toUpperCase();
				System.out.println("Enter a number to add the number of sessions.");
				int count = sc.nextInt();
				try {
					cinema.addSeance(dayOfSeance, count);

				}catch(IllegalArgumentException e) {
					System.out.println("Please, enter correct day");
				}
				cinema.showSchedyle2();
				break;
			}
			case 4:{
				System.out.println("Enter a day of seance.");
				Scanner sc = new Scanner(System.in);
				String dayOfSeance = sc.nextLine().toUpperCase();
				System.out.println("Enter an hour to delete seances");
				int hour = sc.nextInt();
				try {
					cinema.removeSession(dayOfSeance, hour);

				}catch(IllegalArgumentException e) {
					System.out.println("Please, enter correct day");
				}
				cinema.presentSeance();
				break;
			}
			case 5:{
				System.out.println("Enter a day of seance to remove.");
				Scanner sc = new Scanner(System.in);
				String dayOfSeance = sc.nextLine().toUpperCase();

				try {
					cinema.removeScheduleForDay(dayOfSeance);
				}catch(IllegalArgumentException e) {
					System.out.println("Please, enter correct day");
				}

				cinema.presentSeance();
				break;
			}
			case 6:{
				System.exit(0);	
				break;
			}
			default:{
				System.out.println("Enter the number from 1 to 5");
			}

			}
		}
	}


	static void menu() {
		System.out.println("Enter 1 to create a Shedule for particular day."); 
		System.out.println("Enter 2 to show all Shedule");
		System.out.println("Enter 3 to add a film seance to the schedule, on a particular day.");
		System.out.println("Enter 4 to remove a film seance in the schedule, on a particular day.");
		System.out.println("Enter 5 to remove a Shedule for particular day");		
		System.out.println("Enter 6 to log out the program");

	}

}

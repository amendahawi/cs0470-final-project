package travel_itinerary_builder;

import java.util.Scanner;

public class TravelCLI {
	
	static Scanner scn = new Scanner(System.in);
	
	private static void printSeparator() {
		System.out.print("\n------------\n");
	}
	
	
	private static int printMainOptions() {
		
		printSeparator();
		System.out.println("MAIN MENU");
		System.out.println("[1] Create Trip");
		System.out.println("[2] View All Trips");
		System.out.println("[0] Exit");
		System.out.print("Please enter a choice: ");
		int choice = scn.nextInt();
		scn.nextLine();
		System.out.println();
		return choice;
	}
	
	public static void editTrip(TripBook tbook, Trip trip) {
				
		System.out.println("Opening " + trip.getTripName() + "...");
		
		printSeparator();
		
		tbook.printTrip(trip);
		
		System.out.println("[A] Add new activity");
		System.out.println("[E] Edit trip details");
		System.out.println("[0] Back to trip list");
		
		String choice = scn.nextLine();
		
		if (choice.compareToIgnoreCase("a") == 1) {
			System.out.println("ADD NEW ACTIVITY");
			trip.addNewActivity();
		}
		else if (choice == "0") {
			printTrips(tbook);
		}
	}
	
	
	
	
	public static Trip createTrip(TripBook tbook) {
		
		System.out.println("Please fill out the following forms:");
		System.out.print("Trip Name: ");
		String name = scn.nextLine();
		
		System.out.print("Start Date: ");
		String start_date = scn.nextLine();
		
		System.out.print("End Date: ");
		String end_date = scn.nextLine();
		Trip trip = tbook.addNewTrip(name, start_date, end_date);
		
		System.out.println();
		return trip;
	}
	
	public static void printTrips(TripBook t) {
		t.printAllTrips();
	}
	

	public static void main(String[] args) {
		
		TripBook tripbook = new TripBook();
		
		int choice = -1;
		
		while (choice != 0) {
			
			choice = printMainOptions();
			
			if (choice == 1) {
				Trip new_trip = createTrip(tripbook);
				
				editTrip(tripbook, new_trip);
			}
			else if (choice == 2) {
				printTrips(tripbook);
			}
		}

		scn.close();
	}

}

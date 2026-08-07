package travel_itinerary_builder;

import java.util.Scanner;

public class TravelCLI {
	
	static Scanner scn = new Scanner(System.in);
	
	private static void printSeparator() {
		System.out.print("-------------------------------------\n");
	}
	
	
	private static int printMainOptions() {
		
		printSeparator();
		System.out.println("MAIN MENU");
		System.out.println("[1] Create Trip");
		System.out.println("[2] View All Trips");
		System.out.println("[0] Exit");
		System.out.print("Please enter a choice: ");
		int choice = -1;
		
		while (choice < 0 && choice > 2) {
			
			choice = scn.nextInt();
			if (choice < 0 && choice > 2) {
				System.out.println("Invalid choice. Try again.");
			}
		}
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
		
		if (choice.equalsIgnoreCase("a")) {
		    addNewActivitytoTrip(trip);
		}
		else if (choice.equalsIgnoreCase("e")) {
			editTripDetails(trip);
		}
		else if (choice.equals("0")) {
		    printTrips(tbook);
		}
	}
	
	public static void addNewActivitytoTrip(Trip trip) {
		printSeparator();
		System.out.println("ADD NEW ACTIVITY");
		
		System.out.print("Activity Name: ");
		String name = scn.nextLine();
		System.out.print("Activity Location: ");
		String loc = scn.nextLine();
		System.out.print("Activity Date: ");
		String date = scn.nextLine();
		System.out.print("Activity Time: ");
		String time = scn.nextLine();
		System.out.print("Estimated Cost: $");
		float activityCost = scn.nextFloat();
		
		trip.addNewActivity(name, loc, date, time, activityCost);
		System.out.println("Activity added successfully.");
		System.out.println("Trip \"" + trip.getTripName().toUpperCase() + "\" estimated cost: $" + trip.getEstimatedCost());
		
	}
	
	public static void editTripDetails(Trip trip) {
		printSeparator();
		System.out.println("EDIT TRIP DETAILS");
		
		System.out.println("[1] Rename trip");
		System.out.println("[2] Change trip dates");
		System.out.println("[3] Set or remove trip budget");
		System.out.println("[0] Back to trip");
		
		int choice = -1;
		
		while (choice < 0 && choice > 3) {
			
			if (choice == 1) {	
				System.out.print("Enter new name: ");
				String new_name = scn.nextLine();
				trip.setName(new_name);
			}
			else if (choice == 2) {
				editTripDate(trip);
			}
			else if (choice == 3) {
				editTripBudget(trip);
			}
			
			
			choice = scn.nextInt();
			scn.nextLine();
		}
	}
	
	public static void editTripDate(Trip trip) {
		printSeparator();
		
		System.out.println("CHANGE TRIP DATES");
		System.out.println("[1] Change trip start date");
		System.out.println("[2] Change trip end date");
		System.out.println("[0] Cancel");
		
		int choice = -1;
		
		while (choice < 0 && choice > 2) {
			if (choice == 1) {
				editTripStartDate(trip);
			}
			else if (choice == 2) {
				editTripEndDate(trip);
			}
			else if (choice == 0) {
				break;
			}
			else {
			 System.out.println("Invalid choice. Try again.");
			}
			
			choice = scn.nextInt();
			scn.nextLine();
		}
	}
	
	public static void editTripStartDate(Trip trip) {
		System.out.print("Enter new trip start date: ");
		String new_start = scn.nextLine();
		trip.setStartDate(new_start);
	}
	
	public static void editTripEndDate(Trip trip) {
		System.out.print("Enter new trip end date: ");
		String new_end = scn.nextLine();
		trip.setEndDate(new_end);
	}
	
	public static void editTripBudget(Trip trip) {

		printSeparator();
		System.out.println("EDIT TRIP BUDGET");
		System.out.println("[1] Set trip budget");
		System.out.println("[2] Remove trip budget");
		System.out.println("[0] Cancel");
		
		int choice = -1;
		
		while (choice < 0 && choice > 2) {
			if (choice == 1) {
				setTripBudget(trip);
			}
			else if (choice == 2) {
				removeTripBudget(trip);
			}
			else if (choice == 0) {
				break;
			}
			else {
			 System.out.println("Invalid choice. Try again.");
			}
			
			choice = scn.nextInt();
			scn.nextLine();
		}
	}
	
	public static void setTripBudget(Trip trip) {
		System.out.print("Enter trip budget: $");
		float budget = scn.nextFloat();
		scn.nextLine();
		
		trip.setBudget(budget);
	}
	
	public static void removeTripBudget(Trip trip) {
		trip.setBudget(-1);
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
	
	public static void printTrips(TripBook tripbook) {
		tripbook.printAllTrips();
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

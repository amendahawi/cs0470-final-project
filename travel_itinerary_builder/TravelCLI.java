package travel_itinerary_builder;

import java.util.Scanner;

public class TravelCLI {
	
	static Scanner scn = new Scanner(System.in);
	
	private static void printSeparator() {
		System.out.print("-------------------------------------\n");
	}
	
	private static void printInvalidChoice() {
		printSeparator();
		System.out.println("Invalid choice. Try again.");
	}
	
	
	private static void printMainOptions() {
		printSeparator();
		System.out.println("MAIN MENU:");
		System.out.println("[1] Create Trip");
		System.out.println("[2] View All Trips");
		System.out.println("[0] Exit");
		System.out.print("Please enter a choice: ");
	}
	
	public static void editTrip(TripBook tbook, Trip trip) {
				
		String choice = "-1";
		
		printSeparator();
		System.out.println("Opening " + trip.getTripName() + "...");	
		
		while (!choice.equals("0")) {
			
			if (!choice.equals("-1")) {
				printSeparator();
			}
			tbook.printTrip(trip);
			System.out.println("[A] Add new activity");
			System.out.println("[E] Edit trip details");
			System.out.println("[V] View all trip activities");
			System.out.println("[0] Cancel");
			System.out.print("Please enter a choice: ");
			
			choice = scn.nextLine();
			
			if (choice.equalsIgnoreCase("a")) {
			    addNewActivitytoTrip(tbook, trip);
			}
			else if (choice.equalsIgnoreCase("e")) {
				editTripDetails(tbook, trip);
			}
			else if (choice.equalsIgnoreCase("v")) {
				viewAllTripActivities(tbook, trip);
			}
			else if (choice.equals("0")) {
			    break;
			}
			else {
				printInvalidChoice();
			}
		}
	}
	
	public static void addNewActivitytoTrip(TripBook tbook, Trip trip) {
		
		printSeparator();
		System.out.println("ADD NEW ACTIVITY:");
		
		System.out.print("Activity Name: ");
		String name = scn.nextLine();
		System.out.print("Activity Location: ");
		String loc = scn.nextLine();
		System.out.print("Activity Date (MM/DD/YYYY): ");
		String date = scn.nextLine();
		System.out.print("Activity Time (H:MM (AM/PM)): ");
		String time = scn.nextLine();
		System.out.print("Estimated Cost: $");
		float activityCost = scn.nextFloat();
		scn.nextLine();
		
		trip.addNewActivity(name, loc, date, time, activityCost);
		System.out.println("\nActivity added successfully.");
		System.out.println("Trip \"" + trip.getTripName().toUpperCase() + "\" estimated cost: $" + trip.getEstimatedCost());
		
	}
	
	public static void editTripDetails(TripBook tbook, Trip trip) {
		
		int choice = -1;
		
		while (choice != 0) {
			
			printSeparator();
			tbook.printTrip(trip);
			
			System.out.println("EDIT TRIP DETAILS:");
			System.out.println("[1] Rename trip");
			System.out.println("[2] Edit trip dates");
			System.out.println("[3] Set or remove trip budget");
			System.out.println("[0] Cancel");
			System.out.print("Please enter a choice: ");
			
			choice = scn.nextInt();
			scn.nextLine();
			
			if (choice == 1) {	
				System.out.print("Enter new name: ");
				String new_name = scn.nextLine();
				trip.setName(new_name);
				System.out.println("Success! Returning...");
			}
			else if (choice == 2) {
				editTripDate(trip);
				System.out.println("Success! Returning...");
			}
			else if (choice == 3) {
				editTripBudget(trip);
				System.out.println("Success! Returning...");
			}
			else if (choice == 0) {
				break;
			}
			else {
				printInvalidChoice();
			}
		}
	}
	
	public static void viewAllTripActivities(TripBook tbook, Trip trip) {
		
		if (trip.getActivityCount() <= 0) {
			System.out.println("NO ACTIVITIES PLANNED.");
			return;
		}
		
		int choice = -1;
		
		while (choice != 0) {
			
			printSeparator();
			System.out.println("TRIP ACTIVITIES:\n");
			trip.printAllActivities();
			
			System.out.println("\n[1] Edit an activity");
			System.out.println("[0] Cancel");
			System.out.print("Please enter a choice: ");
			
			choice = scn.nextInt();
			scn.nextLine();
			
			if (choice == 1) {
				editActivity(trip);
			}
			else if (choice == 0) {
				break;
			}
			else {
				printInvalidChoice();
			}
		}
		
	}
	
	public static void editActivity(Trip trip) {

		while (true) {
		    System.out.print("\nPlease enter the index of your selected activity OR press [0] to cancel: ");
		    int actIndex = scn.nextInt();
		    scn.nextLine();

		    if (actIndex == 0) {
		        break;
		    }

		    Activity activity = trip.getActivity(actIndex);

		    if (activity != null) {
		        editSelectedActivity(activity);
		        break;
		    }

		    System.out.println("Invalid index. Try again.");

		    printSeparator();
		    System.out.println("ACTIVITY LIST:");
		    trip.printAllActivities();
		}
	}
	
	public static void editSelectedActivity(Activity activity) {
		
		int choice = -1;
		
		while (choice != 0) {
			printSeparator();
			System.out.println("EDITING AN ACTIVITY:");
			System.out.println("[1] Edit activity name");
			System.out.println("[2] Edit activity location");
			System.out.println("[3] Edit activity date");
			System.out.println("[4] Edit activity time");
			System.out.println("[5] Edit activity cost");
			System.out.println("[0] Cancel");
			System.out.print("Please enter a choice: ");
		
			choice = scn.nextInt();
			scn.nextLine();
			
			if (choice == 1) {
				System.out.print("Enter new activity name: ");
				String new_name = scn.nextLine();
				activity.setActivityName(new_name);
				System.out.println("Success! Returning...");
			}
			else if (choice == 2) {
				editActivityLocation(activity);
				System.out.println("Success! Returning...");
			}
			else if (choice == 3) {
				editActivityDate(activity);
				System.out.println("Success! Returning...");
			}
			else if (choice == 4) {
				editActivityTime(activity);
				System.out.println("Success! Returning...");
			}
			else if (choice == 5) {
				editActivityEstCost(activity);
				System.out.println("Success! Returning...");
			}
			else if (choice == 0) {
				break;
			}
			else {
				printInvalidChoice();
			}
		}
	}
	
	public static void editActivityLocation(Activity activity) {
		
		printSeparator();
		System.out.print("Enter new activity location: ");
		String new_loc = scn.nextLine();
		activity.setDate(new_loc);
	}
	
	public static void editActivityDate(Activity activity) {
		
		printSeparator();
		System.out.print("Enter new activity date in (MM/DD/YYYY) format: ");
		String new_date = scn.nextLine();
		activity.setDate(new_date);
	}
	
	public static void editActivityTime(Activity activity) {
		
		printSeparator();
		System.out.print("Enter new activity time in H:MM (AM/PM) format: ");
		String new_time = scn.nextLine();
		activity.setTime(new_time);
	}
	
	public static void editActivityEstCost(Activity activity) {
		
		printSeparator();
		System.out.print("Enter new activity estimated cost: ");
		float new_cost = scn.nextFloat();
		scn.nextLine();
		activity.setEstCost(new_cost);
	}
	
	
	public static void editTripDate(Trip trip) {
		
		int choice = -1;
		
		while (choice != 0) {
			
			printSeparator();
			System.out.println("EDITING TRIP DATES:");
			System.out.println("[1] Edit trip start date");
			System.out.println("[2] Edit trip end date");
			System.out.println("[0] Cancel");
			System.out.print("Please enter a choice: ");
			
			choice = scn.nextInt();
			scn.nextLine();			
			
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
				printInvalidChoice();
			}
		}
	}
	
	public static void editTripStartDate(Trip trip) {
		printSeparator();
		System.out.print("Enter new trip start date in (MM/DD/YYYY) format: ");
		String new_start = scn.nextLine();
		trip.setStartDate(new_start);
	}
	
	public static void editTripEndDate(Trip trip) {
		printSeparator();
		System.out.print("Enter new trip end date in (MM/DD/YYYY) format: ");
		String new_end = scn.nextLine();
		trip.setEndDate(new_end);
	}
	
	public static void editTripBudget(Trip trip) {
		
		int choice = -1;
		
		while (choice != 0) {
			
			printSeparator();
			System.out.println("EDIT TRIP BUDGET:");
			System.out.println("[1] Set trip budget");
			System.out.println("[2] Remove trip budget");
			System.out.println("[0] Cancel");
			System.out.print("Please enter a choice: ");
			
			choice = scn.nextInt();
			scn.nextLine();
			
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
				printInvalidChoice();
			}
		}
	}
	
	public static void setTripBudget(Trip trip) {
		printSeparator();
		System.out.print("Enter trip budget: $");
		float budget = scn.nextFloat();
		scn.nextLine();
		trip.setBudget(budget);
	}
	
	public static void removeTripBudget(Trip trip) {
		trip.setBudget(-1);
	}

	
	public static Trip createTrip(TripBook tbook) {
		
		printSeparator();
		System.out.println("CREATE TRIP:");
		System.out.println("Please fill out the following forms:");
		System.out.print("Trip Name: ");
		String name = scn.nextLine();
		
		System.out.print("Start Date (MM/DD/YYYY): ");
		String start_date = scn.nextLine();
		
		System.out.print("End Date (MM/DD/YYYY): ");
		String end_date = scn.nextLine();
		
		Trip trip = tbook.addNewTrip(name, start_date, end_date);
		return trip;
	}
	
	public static void viewAllTrips(TripBook tripbook) {
		
		if (tripbook.getTripCount() <= 0) {	
			printSeparator();
			System.out.println("NO TRIPS YET.");
			System.out.println("Returning to Main Menu...");
		}
		else {	
			int choice = -1;
			
			while (choice != 0) {
				
				printSeparator();
				System.out.println("TRIPS LIST:");
				tripbook.printAllTrips();
			
				System.out.println("\n[1] Open a trip");
				System.out.println("[0] Back to Main Menu");
				System.out.print("Please enter a choice: ");
				
				choice = scn.nextInt();
				scn.nextLine();
				
				if (choice == 1) {
				    
				    while (true) {
				        System.out.print("\nPlease enter the index of your selected trip OR press [0] to cancel: ");
				        int tripIndex = scn.nextInt();
				        scn.nextLine();

				        if (tripIndex == 0) {
				            break;
				        }

				        Trip trip = tripbook.getTrip(tripIndex);

				        if (trip != null) {
				            editTrip(tripbook, trip);
				            break;
				        }

				        System.out.println("Invalid index. Try again.");

				        printSeparator();
				        System.out.println("TRIPS LIST:");
				        tripbook.printAllTrips();
				    }
				}
				else if (choice == 0) {
				    break;
				}
				else {
				    printInvalidChoice();
				}
			}
		}
		
		
	}
	

	public static void main(String[] args) {
		
		TripBook tripbook = new TripBook();
		
		int choice = -1;
		
		while (choice != 0) {
			
			printMainOptions();
			choice = scn.nextInt();
			scn.nextLine();
			
			if (choice == 1) {
				Trip new_trip = createTrip(tripbook);
				editTrip(tripbook, new_trip);
			}
			else if (choice == 2) {
				viewAllTrips(tripbook);
			}
			else if (choice == 0) {
				System.out.println("Quitting Travel Itinerary Builder...");
				break;
			}
			else {
				printInvalidChoice();
			}
		}

		scn.close();
	}
}




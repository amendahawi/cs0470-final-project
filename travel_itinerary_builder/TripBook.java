package travel_itinerary_builder;

import java.util.ArrayList;

public class TripBook {

	private ArrayList<Trip> trips = new ArrayList<Trip>();
	private int tripCount;
	
	
	
	// Methods
	public Trip getTrip(int tripID) {
		
		for (Trip trip : trips) {
			
			if (trip.getTripID() == tripID) {
				return trip;
			}
		}
		return null;
	}
	
	
	public Trip addNewTrip(String name, String start_date, String end_date) {
		
		tripCount += 1;
		Trip new_trip = new Trip(name, start_date, end_date, tripCount);
		trips.add(new_trip);
		return new_trip;
	}
	
	
	// Getters
	public int getTripCount() {
		return tripCount;
	}
	
	
	public void printTrip(Trip t) {
		System.out.println(t.getTripName().toUpperCase());
		System.out.println();
		System.out.println("Dates: " + t.getStartDate() + " - " + t.getEndDate());
		
		System.out.println();
		System.out.println("ACTIVITIES");
		if (t.getActivityCount() < 1) {
			System.out.println("No activities planned yet.");
		}
		else {
			System.out.println(t.getActivityCount() + "activities planned.");
		}
		System.out.println();
	}
	
	
	
	public void printAllTrips() {
		
		if (tripCount < 1) {
			System.out.println("NO TRIPS AVAILABLE.");
			System.out.println("Returning to main menu...");
			System.out.println();
			return;
		}
		
		System.out.println("Trips:");
		
		for (Trip t : trips) {
			System.out.println("[" + t.getTripID() + "]: " + t.getTripName());
			System.out.println(t.getStartDate() + " - " + t.getEndDate());
			System.out.println(t.getActivityCount() + " activities");
			System.out.println();
		}
		System.out.println();
	}

}

package travel_itinerary_builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TripBook {

	private ArrayList<Trip> trips;
	private int nextTripID = 1;
	
	// Constructors ------------------------------
	
	public TripBook() {
		trips = new ArrayList<Trip>();
	}
	
	
	// Getters ------------------------------
	
	public int getTripCount() {
		
		return trips.size();
	}
		
	public Trip getTrip(int tripID) {
		
		for (Trip trip : trips) {
			
			if (trip.getTripID() == tripID) {
				return trip;
			}
		}
		return null;
	}
	
	
	// Other Methods ------------------------------
	
	public Trip addNewTrip(String name, String start_date, String end_date) {
		
		Trip new_trip = new Trip(name, start_date, end_date, nextTripID);
		trips.add(new_trip);
		nextTripID++;
		return new_trip;
	}
	
	public void removeTrip(int tripID) {
		
		Trip trip = getTrip(tripID);
		if (trip != null) {
			trips.remove(trip);
		}
	}
	
	public void removeTrip(Trip trip) {
		if (trip != null) {
			trips.remove(trip);
		}
	}
	
	public List<Trip> getAllTrips() {
	    return Collections.unmodifiableList(trips);
	}
	
	
	
	

}

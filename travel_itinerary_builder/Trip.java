package travel_itinerary_builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Trip {
	
	private int tripID;
	private ArrayList<Activity> tripActivities;
	private String name;
	private String startDate;
	private String endDate;
	private float budget = -1;
	
	private int nextActivityID = 1;
	
	
	// Constructors ------------------------------
	public Trip(String name, String start_date, String end_date, int tripID) {
		tripActivities = new ArrayList<Activity>();
		this.name = name;
		this.startDate = start_date;
		this.endDate = end_date;
		this.tripID = tripID;
	}
	
	
	// Methods ------------------------------
	
	// Setter Methods ------------------------------
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStartDate(String date) {
		this.startDate = date;
	}
	
	public void setEndDate(String date) {
		this.endDate = date;
	}
	
	public void setBudget(float budget) {
		this.budget = budget;
	}
	
	public void removeBudget() {
		this.budget = -1;
	}
	
	
	// Getter Methods ------------------------------
	public Activity getActivity(int activityID) {
		
		for (Activity activity : tripActivities) {
			
			if (activity.getID() == activityID) {
				return activity;
			}
		}
		return null;
	}
	
	
	public String getTripName() {
		return this.name;
	}
	
	public int getTripID() {
		return tripID;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
	
	public int getActivityCount() {
		return tripActivities.size();
	}
	
	public float getEstimatedCost() {
		
		float totalCost = 0;

		for (Activity activity : tripActivities) {
			totalCost += activity.getEstCost();
		}
		
		return totalCost;
	}
	
	public float getBudget() {
		return budget;
	}
	
	
	
	// Activity Methods
	public Activity addNewActivity(String name, String loc, String date, String time, float activityCost) {
		
		Activity new_act = new Activity(nextActivityID, name, loc, date, time, activityCost);
		tripActivities.add(new_act);
		nextActivityID++;
		return new_act;
	}
	
	public void removeActivity(int activityID) {
		
		Activity activity = getActivity(activityID);
		
		if (activity != null) {
			tripActivities.remove(activity);
		}
	}
	
	public void removeActivity(Activity activity) {
		
		if (activity != null) {
			tripActivities.remove(activity);
		}
	}
	
	
	public List<Activity> getAllActivities() {
		return Collections.unmodifiableList(tripActivities);
	}
	
	public List<Activity> getActivitiesSorted() {
		
		// Sort all activities in date order and time order
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
	    
	    // Create a new ArrayList to store the sorted list
	    ArrayList<Activity> sortedActivities = new ArrayList<>(tripActivities);

	    sortedActivities.sort(
	        Comparator.comparing(
	            (Activity a) -> LocalDate.parse(a.getDate(), dateFormatter)
	        ).thenComparing(
	            a -> LocalTime.parse(a.getTime(), timeFormatter)
	        )
	    );

	    return sortedActivities;
	}
}

package travel_itinerary_builder;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Trip {
	
	private int tripID;
	private int activityCount;
	private ArrayList<Activity> tripActivities = new ArrayList<Activity>();
	
	private String name;
	private String startDate;
	private String endDate;
	
	private float budget = -1;
	
	public Trip(String name, String start_date, String end_date, int tripID) {
		this.name = name;
		this.startDate = start_date;
		this.endDate = end_date;
		this.tripID = tripID;
	}
	
	
	public void addNewActivity(String name, String loc, String date, String time, float activityCost) {
		
		activityCount += 1;
		Activity new_act = new Activity(activityCount, name, loc, date, time, activityCost);
		
		tripActivities.add(new_act);
	}
	
	
	// Setter Methods
	
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
	
	
	
	// Getter Methods
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
	
	public void printAllActivities() {
		
		
		// Sort all activities in date order and time order
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
		
		tripActivities.sort(
		    Comparator.comparing(
		        (Activity a) -> LocalDate.parse(a.getDate(), dateFormatter)
		    ).thenComparing(
		        a -> LocalTime.parse(a.getTime(), timeFormatter)
		    )
		);
		
		// Print all the activities
		for (Activity a : tripActivities) {
			
			System.out.println("[" + a.getID() + "]: " + a.getActivityName());
			System.out.println("Location: " + a.getLocation());
			System.out.println("Date: " + a.getDate());
			System.out.println("Time: " + a.getTime());
			System.out.printf("Estimated Cost: $%.2f%n", a.getEstCost());
			
			if (a.getID() < activityCount) {
				System.out.println();
			}
		}
		
	}
	
}

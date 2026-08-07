package travel_itinerary_builder;

import java.util.ArrayList;
import java.util.Scanner;

public class Trip {
	
	private int tripID;
	private int activityCount;
	private ArrayList<Activity> tripActivities = new ArrayList<Activity>();
	
	private String name;
	private String startDate;
	private String endDate;
	
	private float budget = -1;
	private float estimatedCost = 0;
	
	
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
		this.estimatedCost += activityCost;
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
		this.budget = 0;
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
		return this.estimatedCost;
	}

}

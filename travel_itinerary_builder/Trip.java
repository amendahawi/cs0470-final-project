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
	
	
	public Trip(String name, String start_date, String end_date, int tripID) {
		this.name = name;
		this.startDate = start_date;
		this.endDate = end_date;
		this.tripID = tripID;
	}
	
	
	public void addNewActivity() {
		
		Scanner scn = new Scanner(System.in);
		
		activityCount += 1;
		
		System.out.print("Activity Name: ");
		String name = scn.nextLine();
		System.out.print("Activity Location: ");
		String loc = scn.nextLine();
		System.out.print("Activity Date: ");
		String date = scn.nextLine();
		System.out.print("Activity Time: ");
		String time = scn.nextLine();
		System.out.print("Estimated Cost: $");
		float estCost = scn.nextFloat();
		
		Activity new_act = new Activity(activityCount, name, loc, date, time, estCost);
		
		tripActivities.add(new_act);
		
		System.out.println("Activity added successfully.");
		scn.close();
	}
	
	
	// Setter Methods
	
	
	
	
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

}

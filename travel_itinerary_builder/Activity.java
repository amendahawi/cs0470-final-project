package travel_itinerary_builder;

public class Activity {
	
	private int activityID;
	private String activityName;
	private String activityLocation;
	private String date;
	private String time;
	private float estCost;
	
	
	public Activity(int activityID, String activityName, String loc, String date, String time, float estCost) {
		
		this.activityID = activityID;
		this.activityName = activityName;
		this.activityLocation = loc;
		this.date = date;
		this.time = time;
		this.estCost = estCost;
	}
	
	
	
	// Setters
	public void setLocation(String loc) {
		this.activityLocation = loc;
	}
	
	
	// Getters
	public int getID() {
		return activityID;
	}
	
	public String getLocation() {
		return activityLocation;
	}

}

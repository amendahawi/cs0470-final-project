package travel_itinerary_builder;

public class Activity {
	
	// Attributes
	private int activityID;
	private String activityName;
	private String activityLocation;
	private String date;
	private String time;
	private float estCost;
	
	
	// Constructors ------------------------------
	public Activity(int activityID, String activityName, String loc, String date, String time, float estCost) {
		this.activityID = activityID;
		this.activityName = activityName;
		this.activityLocation = loc;
		this.date = date;
		this.time = time;
		this.estCost = estCost;
	}
	
	
	// Methods ------------------------------
	
	// Setters ------------------------------
	public void setActivityName(String name) {
		this.activityName = name;
	}
	public void setLocation(String loc) {
		this.activityLocation = loc;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setEstCost(float estCost) {
		this.estCost = estCost;
	}
	
	
	// Getters ------------------------------
	public int getID() {
		return this.activityID;
	}
	
	public String getActivityName() {
		return this.activityName;
	}
	
	public String getLocation() {
		return this.activityLocation;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public float getEstCost() {
		return this.estCost;
	}

}

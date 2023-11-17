package model;

public class AlertsModel {
	

	private String title;
	private String description;
	
	public AlertsModel(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	
	public AlertsModel() {
		super();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}

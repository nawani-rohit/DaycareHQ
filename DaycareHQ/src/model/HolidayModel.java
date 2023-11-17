package model;

import javafx.beans.property.SimpleStringProperty;

public class HolidayModel {
	
	 private SimpleStringProperty date;
	 private SimpleStringProperty holiday;
	 
	 public HolidayModel(String date, String holiday) {
	        this.date = new SimpleStringProperty(date);
	        this.holiday = new SimpleStringProperty(holiday);
	 }
	 
	 public String getDate() {
	        return date.get();
	 }

	 public void setDate(String date) {
	    this.date = new SimpleStringProperty(date);
	 }
	 
	 public String getHoliday() {
	        return holiday.get();
	 }

	 public void setHoliday(String holiday) {
	    this.holiday = new SimpleStringProperty(holiday);
	 }
}

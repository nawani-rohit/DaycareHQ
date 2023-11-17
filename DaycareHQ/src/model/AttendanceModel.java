package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AttendanceModel {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty date;
	private SimpleIntegerProperty hours;
	private SimpleStringProperty attendanceRecord;

	
	public AttendanceModel() {
		super();
	}
	
	public AttendanceModel(Integer id, String name, String date, Integer hours, String attendanceRecord) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.date = new SimpleStringProperty(date);
		this.hours = new SimpleIntegerProperty(hours);
		this.attendanceRecord = new SimpleStringProperty(attendanceRecord);
	}
	
	public String getAttendanceRecord() {
		return attendanceRecord.get();
	}
	public void setAttendanceRecord(String attendanceRecord) {
		this.attendanceRecord = new SimpleStringProperty(attendanceRecord);
	}
	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}
	public int getId() {
		return id.get();
	}
	public void setId(int id) {
		this.id = new SimpleIntegerProperty(id);
	}
	public String getDate() {
		return date.get();
	}
	public void setDate(String date) {
		this.date = new SimpleStringProperty(date);
	}
	public Integer getHours() {
		return hours.get();
	}
	public void setHours(Integer hours) {
		this.hours = new SimpleIntegerProperty(hours);
	}
	
}

package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ChildModel {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty parentName;
	private SimpleStringProperty department;
	private SimpleStringProperty reportsTo;
	
	public ChildModel() {
		super();
	}
	
	public ChildModel(Integer id, String name, String parentName, String department, String reportsTo) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.parentName = new SimpleStringProperty(parentName);
		this.department = new SimpleStringProperty(department);
		this.reportsTo = new SimpleStringProperty(reportsTo);
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
	public String getParentName() {
		return parentName.get();
	}
	public void setParentName(String parentName) {
		this.parentName = new SimpleStringProperty(parentName);
	}
	public String getDepartment() {
		return department.get();
	}
	public void setDepartment(String department) {
		this.department = new SimpleStringProperty(department);
	}
	public String getReportsTo() {
		return reportsTo.get();
	}
	public void setReportsTo(String reportsTo) {
		this.reportsTo = new SimpleStringProperty(reportsTo);
	}
	
}

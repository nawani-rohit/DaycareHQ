package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FeeModel {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty fee;
	private SimpleStringProperty age;
	private SimpleStringProperty department;

	public FeeModel() {
		super();
	}

	public FeeModel(Integer id, String name, String fee, String age, String department) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.fee = new SimpleStringProperty(fee);
		this.age = new SimpleStringProperty(age);
		this.department = new SimpleStringProperty(department);
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
	public String getFee() {
		return fee.get();
	}
	public void setFee(String feePerAnnum) {
		this.fee = new SimpleStringProperty(feePerAnnum);
	}
	public String getAge() {
		return age.get();
	}
	public void setAge(String age) {
		this.age = new SimpleStringProperty(age);
	}
	public String getDepartment() {
		return department.get();
	}
	public void setDepartment(String department) {
		this.department = new SimpleStringProperty(department);
	}

}


package org;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String designation;
	private String department;
	private Employee reportingTo;

	public Employee(int id, String name, int age, String designation, String department, Employee reportingTo) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.department = department;
		this.reportingTo = reportingTo;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDesignation() {
		return designation;
	}

	public String getDepartment() {
		return department;
	}

	public Employee getReportingTo() {
		return reportingTo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setReportingTo(Employee reportingTo) {
		this.reportingTo = reportingTo;
	}

	@Override
	public String toString() {
		return "" + id + " " + name + " " + age + " " + designation + " " + department;
	}

}

package com.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "employee")
@Check(constraints = "salary >=10000 AND salary <=120000")
public class Employee {
	@Id
	private int emp_id;
	@Column(nullable = false)
	private String emp_name;
	@Column(nullable = false)
	private String gender;
	private double salary;
	@Column(nullable = true)
	private double experience;
	@ManyToOne
	private Designation designation;

	public Employee() {

	}

	public Employee(int emp_id, String emp_name, String gender, double salary, double experience,
			Designation designation) {

		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.gender = gender;
		this.salary = salary;
		this.experience = experience;
		this.designation = designation;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", gender=" + gender + ", salary=" + salary
				+ ", experience=" + experience + ", designation=" + designation + "]";
	}

}

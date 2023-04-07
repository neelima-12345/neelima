package com.onetomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "designation")
public class Designation {
	@Id
	private String des_id;
	private String des_name;
	private String department;
	@OneToMany(mappedBy = "designation")
	private List<Employee> employee;

	public Designation() {

	}

	public Designation(String des_id, String des_name, String department, List<Employee> employee) {
		super();
		this.des_id = des_id;
		this.des_name = des_name;
		this.department = department;
		this.employee = employee;
	}

	public String getDes_id() {
		return des_id;
	}

	public void setDes_id(String des_id) {
		this.des_id = des_id;
	}

	public String getDes_name() {
		return des_name;
	}

	public void setDes_name(String des_name) {
		this.des_name = des_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Designation [des_id=" + des_id + ", des_name=" + des_name + ", department=" + department + "]";
	}

}

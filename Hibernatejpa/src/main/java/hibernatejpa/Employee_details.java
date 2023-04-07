package hibernatejpa;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;



@Entity
@Table(name = "employeedetails")
@Check(constraints = "Salary >=12000 AND Salary <=100000")
public class Employee_details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "EmployeeName", nullable = false)
	private String name;

	@Column(unique = true)
	private String emailId;

	@Column(length = 20, nullable = false)
	private String designation;

	@Column(name = "Salary", nullable = false)
	private double salary;

	@Column(name = "date", nullable = false)

	private LocalDate joining_date;

	public Employee_details() {

	}

	public Employee_details(Integer id, String name, String emailId, String designation, double salary,
			LocalDate joining_date) {

		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.designation = designation;
		this.salary = salary;
		this.joining_date = joining_date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(LocalDate joining_date) {
		this.joining_date = joining_date;
	}

	@Override
	public String toString() {
		return "Employee_details [id=" + id + ", name=" + name + ", emailId=" + emailId + ", designation=" +
	designation + ", salary=" + salary + ", joining_date=" + joining_date + "]";
	}

}

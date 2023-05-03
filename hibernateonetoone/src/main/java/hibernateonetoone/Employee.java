package hibernateonetoone;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//vdgg

import org.hibernate.annotations.Check;

@Entity
@Check(constraints = "Salary >=5000 AND Salary <=100000")
public class Employee {
	@Id
	private int emp_id;
	@Column(nullable = false)
	private String emp_name;
	private double salary;
	private LocalDate emp_joining_date;
	@OneToOne(mappedBy = "employee")
	private Laptop laptop;

	public Employee() {

	}

	public Employee(int emp_id, String emp_name, double salary, LocalDate emp_joining_date) {

		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.salary = salary;
		this.emp_joining_date = emp_joining_date;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getEmp_joining_date() {
		return emp_joining_date;
	}

	public void setEmp_joining_date(LocalDate emp_joining_date) {
		this.emp_joining_date = emp_joining_date;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", salary=" + salary + ", emp_joining_date="
				+ emp_joining_date + "]";
	}

}

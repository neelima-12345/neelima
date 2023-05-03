package hibernateonetoone;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	private int laptop_id;
	@Column(nullable = false)
	private String laptop_name;
	@Column(nullable = false)
	private String laptop_model;
	@Column(nullable = false)
	private LocalDate Lap_Warranty;
	@OneToOne
	private Employee employee;

	public Laptop() {

	}

	public Laptop(int laptop_id, String laptop_name, String laptop_model, LocalDate lap_Warranty) {

		this.laptop_id = laptop_id;
		this.laptop_name = laptop_name;
		this.laptop_model = laptop_model;
		Lap_Warranty = lap_Warranty;
	}

	public int getLaptop_id() {
		return laptop_id;
	}

	public void setLaptop_id(int laptop_id) {
		this.laptop_id = laptop_id;
	}

	public String getLaptop_name() {
		return laptop_name;
	}

	public void setLaptop_name(String laptop_name) {
		this.laptop_name = laptop_name;
	}

	public String getLaptop_model() {
		return laptop_model;
	}

	public void setLaptop_model(String laptop_model) {
		this.laptop_model = laptop_model;
	}

	public LocalDate getLap_Warranty() {
		return Lap_Warranty;
	}

	public void setLap_Warranty(LocalDate lap_Warranty) {
		Lap_Warranty = lap_Warranty;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Laptop [laptop_id=" + laptop_id + ", laptop_name=" + laptop_name + ", laptop_model=" + laptop_model
				+ "," + " Lap_Warranty=" + Lap_Warranty + ", " + "employee=" + employee + "]";
	}

}

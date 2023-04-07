package example2;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student {
	@Id
	private int id;
	private String name;
	private String gender;
	private double marks;
	private String phone_number;

	public Student() {

	}

	public Student(int id, String name, String gender, double marks, String phone_number) {

		this.id = id;
		this.name = name;
		this.gender = gender;
		this.marks = marks;
		this.phone_number = phone_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender +
				", marks=" + marks + ", phone_number=" + phone_number + "]";
	}

}

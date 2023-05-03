package onetoOneRealtion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Capital {
	@Id
	@Column(length = 20)
	private String capital_name;
	@Column(nullable = false)
	private long population;
	@Column(nullable = false)
	private boolean isseashore;
	@Column(nullable = false)
	private String area;

	@OneToOne(mappedBy = "capital")
	private Country country;

	public Capital() {

	}

	public Capital(String capital_name, long population, boolean isseashore, String area) {

		this.capital_name = capital_name;
		this.population = population;
		this.isseashore = isseashore;
		this.area = area;

	}

	public String getCapital_name() {
		return capital_name;
	}

	public void setCapital_name(String capital_name) {
		this.capital_name = capital_name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public boolean isIsseashore() {
		return isseashore;
	}

	public void setIsseashore(boolean isseashore) {
		this.isseashore = isseashore;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Capital [capital_name=" + capital_name + ", " + "population=" + population + ", " + "isseashore="
				+ isseashore + ", area=" + area + "]";
	}

}

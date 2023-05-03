package onetoOneRealtion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Country {
	@Id
	@Column(length = 20)
	private String country_name;
	@Column(nullable = false)
	private long population;
	@Column(nullable = false)
	private String largest_river;
	@Column(nullable = false)
	private String main_crop;
	@Column(nullable = false)
	private boolean isseashore;

	@OneToOne
	private Capital capital;

	public Country() {

	}

	public Country(String country_name, long population, String largest_river, String main_crop, boolean isseashore) {

		this.country_name = country_name;
		this.population = population;
		this.largest_river = largest_river;
		this.main_crop = main_crop;
		this.isseashore = isseashore;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public String getLargest_river() {
		return largest_river;
	}

	public void setLargest_river(String largest_river) {
		this.largest_river = largest_river;
	}

	public String getMain_crop() {
		return main_crop;
	}

	public void setMain_crop(String main_crop) {
		this.main_crop = main_crop;
	}

	public boolean isIsseashore() {
		return isseashore;
	}

	public void setIsseashore(boolean isseashore) {
		this.isseashore = isseashore;
	}

	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Country [country_name=" + country_name + ", population=" + population + ", largest_river="
				+ largest_river + ", main_crop=" + main_crop + ", isseashore=" + isseashore + ", capital=" + capital
				+ "]";
	}

}

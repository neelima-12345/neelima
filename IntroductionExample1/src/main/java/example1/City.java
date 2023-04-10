package example1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
	@Id
	private Integer id;
	private String city_name;
	private long city_population;
	private String country_name;

	public City() {

	}

	public City(Integer id, String city_name, long city_population, String country_name) {

		this.id = id;
		this.city_name = city_name;
		this.city_population = city_population;
		this.country_name = country_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public long getCity_population() {
		return city_population;
	}

	public void setCity_population(long city_population) {
		this.city_population = city_population;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", city_name=" + city_name + ", city_population=" + city_population
				+ ", country_name=" + country_name + "]";
	}

}
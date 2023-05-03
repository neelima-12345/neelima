package onetomanymapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Check;

@Entity
@Check(constraints = "facing in('east','west','north','south')")
public class Apartment {
	@Id
	private String apartment_id;
	@Column(nullable = false)
	private String apartment_name;
	@Column(nullable = false)
	private int no_flats;
	private String facing;
	@Column(nullable = false)
	private int no_floors;
	@Column(nullable = false)
	private boolean islift;

	@OneToMany(mappedBy = "apartment")
	private List<Flat> flats;

	public Apartment() {

	}

	public Apartment(String apartment_id, String apartment_name, int no_flats, String facing, int no_floors,
			boolean islift, List<Flat> flats) {

		this.apartment_id = apartment_id;
		this.apartment_name = apartment_name;
		this.no_flats = no_flats;
		this.facing = facing;
		this.no_floors = no_floors;
		this.islift = islift;
		this.flats = flats;
	}

	public String getApartment_id() {
		return apartment_id;
	}

	public void setApartment_id(String apartment_id) {
		this.apartment_id = apartment_id;
	}

	public String getApartment_name() {
		return apartment_name;
	}

	public void setApartment_name(String apartment_name) {
		this.apartment_name = apartment_name;
	}

	public int getNo_flats() {
		return no_flats;
	}

	public void setNo_flats(int no_flats) {
		this.no_flats = no_flats;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	public int getNo_floors() {
		return no_floors;
	}

	public void setNo_floors(int no_floors) {
		this.no_floors = no_floors;
	}

	public boolean isIslift() {
		return islift;
	}

	public void setIslift(boolean islift) {
		this.islift = islift;
	}

	public List<Flat> getFlats() {
		return flats;
	}

	public void setFlats(List<Flat> flats) {
		this.flats = flats;
	}

	@Override
	public String toString() {
		return "Apartment [apartment_id=" + apartment_id + ", " + "apartment_name=" + apartment_name + ", no_flats="
				+ no_flats + ", facing=" + facing + ", no_floors=" + no_floors + ", islift=" + islift + "]";
	}

}

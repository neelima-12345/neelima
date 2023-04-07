package onetomanymapping;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;


@Entity
public class Flat {
	@Id
	private String flat_id;
	private String owner_name;
	private int no_bedrooms;
	private String facing;
	private int floor;
	private boolean isAvailable;
	@ManyToOne
	private Apartment apartment;

	public Flat() {

	}

	public Flat(String flat_id, String owner_name, int no_bedrooms, String facing, int floor, boolean isAvailable,
			Apartment apartment) {

		this.flat_id = flat_id;
		this.owner_name = owner_name;
		this.no_bedrooms = no_bedrooms;
		this.facing = facing;
		this.floor = floor;
		this.isAvailable = isAvailable;
		this.apartment = apartment;
	}

	public String getFlat_id() {
		return flat_id;
	}

	public void setFlat_id(String flat_id) {
		this.flat_id = flat_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public int getNo_bedrooms() {
		return no_bedrooms;
	}

	public void setNo_bedrooms(int no_bedrooms) {
		this.no_bedrooms = no_bedrooms;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@Override
	public String toString() {
		return "Flat [flat_id=" + flat_id + ", owner_name=" + owner_name + ", no_bedrooms=" + no_bedrooms + ", facing="
				+ facing + ", floor=" + floor + ", isAvailable=" + isAvailable + ", apartment=" + apartment + "]";
	}

}
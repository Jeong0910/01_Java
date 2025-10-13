package edu.kh.model.dto;

import java.util.Objects;
import java.util.Set;

public class Toy implements Comparable<Toy> {

	private String toyName;
	private int age;
	private int price;
	private String colour;
	private int manufactureDate;
	private Set<String> materialSet;

	public Toy() {
	}

	public Toy(String toyName, int age, int price, String colour, int manufactureDate, Set<String> materialSet) {
		super();
		this.toyName = toyName;
		this.age = age;
		this.price = price;
		this.colour = colour;
		this.manufactureDate = manufactureDate;
		this.materialSet = materialSet;
	}

	public String getToyName() {
		return toyName;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	public int getage() {
		return age;
	}

	public void setage(int age) {
		this.age = age;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(int manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Set<String> getmaterialSet() {
		return materialSet;
	}

	public void setmaterialSet(Set<String> materialSet) {
		this.materialSet = materialSet;
	}

	@Override
	public int compareTo(Toy o) {

		return this.manufactureDate - o.manufactureDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, colour, manufactureDate, materialSet, price, toyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		return age == other.age && Objects.equals(colour, other.colour) && manufactureDate == other.manufactureDate
				&& Objects.equals(materialSet, other.materialSet) && price == other.price
				&& Objects.equals(toyName, other.toyName);
	}

	@Override
	public String toString() {

		String strIngredient = String.join(", ", materialSet);

		return String.format("이름 : %s / 가격 : %d / 색상 : %s / 사용가능연령 : %d " + "/ 제조년월일 : %d / 재료 : %s", toyName, price,
				colour, age, manufactureDate, strIngredient);
	}

}
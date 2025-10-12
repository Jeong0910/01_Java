package edu.kh.model.dto;

import java.util.Objects;
import java.util.Set;

public class Toy implements Comparable<Toy> {
	
	private String toyName;
	private int useAge;
	private int price;
	private String colour;
	private int manufactureDate;
	private Set<String> ingredientSet;
	
	public Toy() {}

	public Toy(String toyName, int useAge, int price, String colour, int manufactureDate, Set<String> ingredientSet) {
		super();
		this.toyName = toyName;
		this.useAge = useAge;
		this.price = price;
		this.colour = colour;
		this.manufactureDate = manufactureDate;
		this.ingredientSet = ingredientSet;
	}

	public String getToyName() {
		return toyName;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	public int getUseAge() {
		return useAge;
	}

	public void setUseAge(int useAge) {
		this.useAge = useAge;
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

	public Set<String> getIngredientSet() {
		return ingredientSet;
	}

	public void setIngredientSet(Set<String> ingredientSet) {
		this.ingredientSet = ingredientSet;
	}

	@Override
	public int compareTo(Toy o) {
		
		return this.manufactureDate-o.manufactureDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colour, ingredientSet, manufactureDate, price, toyName, useAge);
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
		return colour == other.colour && Objects.equals(ingredientSet, other.ingredientSet)
				&& manufactureDate == other.manufactureDate && price == other.price
				&& Objects.equals(toyName, other.toyName) && useAge == other.useAge;
	}
	
	@Override
	public String toString() {
		
		return String.format("이름 : %s / 가격 : %d / 색상 : %s / 사용가능연령 : %d "
				+ "/ 제조년월일 : %d / 재료 : %s\n",
				toyName, price, colour, useAge, manufactureDate, ingredientSet);
	}
	
	public int compareTo (int index) {
		return this.useAge-useAge;
	}
}
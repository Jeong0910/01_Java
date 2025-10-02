package edu.kh.model.dto;

import java.util.LinkedHashSet;
import java.util.Set;

//import edu.kh.collection.pack1.model.dto.Student;

public class Toy implements Comparable<Toy>{
	// dto
	private String name;
	private int age;
	private int price;
	private String color;
	private int year;
	private Set<String> ingredientSet;

	// 생성자
	public Toy() {

	}

	public Toy(String name, int age, int price, String color, int year, Set<String> ingredientSet) {
		this.name = name;
		this.age = age;
		this.price = price;
		this.color = color;
		this.year = year;
		this.ingredientSet = ingredientSet;
	}

	// getter & setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	

	public Toy(Set<String> ingredientSet) {
		super();
		this.ingredientSet = ingredientSet;
	}

	@Override
	public String toString() {
		return String.format("이름 : %s / 가격 : %d / 색상 : %s / 사용가능연령 : %d / 제조년월일 : %d / 재료 : %s\n", name, price, color, age, year, ingredientSet);
	}

	@Override
	public int compareTo(Toy o) {
		return this.year - o.year;
	}
}

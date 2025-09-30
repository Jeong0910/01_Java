package edu.kh.poly.ex2.model.dto;

public class Fish extends Animal

{

	public Fish(String type, String eatType) {
		super(type, eatType);
	}

	@Override
	public void eat() {
		System.out.println("입을 뻐끔거린다");
		
	}

	@Override
	public void breath() {
		System.out.println("아가미 호흡을 한다");
		
	}

	@Override
	public void move() {
		System.out.println("꼬리를 헤엄치며 움직인다");
	
	}
	
	@Override
	public String toString() {
		
		return "Fish : " + super.toString();
	}

}

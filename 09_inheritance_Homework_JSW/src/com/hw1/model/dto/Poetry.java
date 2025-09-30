package com.hw1.model.dto;

public class Poetry extends Book {
	
	private int numberOfPoems;
	
	public Poetry() {}

	public Poetry(String title, String author, int numberOfPoems) {
		super(title, author);
		this.numberOfPoems = numberOfPoems;
	}

	public int getNumberOfPoems() {
		return numberOfPoems;
	}

	public void setNumberOfPoems(int numberOfPoems) {
		this.numberOfPoems = numberOfPoems;
	}
	
	@Override
	public void displayInfo() {
		System.out.print("[시집] 제목 : "+ getTitle() + "/"+"저자 : "+ getAuthor() + "장르 : " + numberOfPoems);

	}

}

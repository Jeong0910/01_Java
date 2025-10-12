package edu.kh.model.run;

import edu.kh.model.service.ToyFactory;

public class Run {
	public static void main(String[] args) {
		ToyFactory toyFactory = new ToyFactory();
		
		toyFactory.displayMenu();
	}
}
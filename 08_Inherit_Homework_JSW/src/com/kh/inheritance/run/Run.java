package com.kh.inheritance.run;

import com.kh.inheritance.model.dto.BasicPhone;
import com.kh.inheritance.model.dto.SmartPhone;

public class Run {
	public static void main(String[] args) {
		
		SmartPhone sp = new SmartPhone("Samsung","Galaxy S20",2020,120000,"Android",128);
		sp.printinfo();
		
		System.out.println("===========================================");
		
		BasicPhone bp = new BasicPhone("Nokia","3310",2000,10000,true);
		bp.printinfo();
		bp.checkKeyboard();
		
		
	}
}
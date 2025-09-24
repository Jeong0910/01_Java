package com.kh.practice.snack.controller;

import com.kh.practice.snack.model.vo.Snack;

public class SnackController {
	
	Snack s = new Snack();
	
	public String saveData(String kind, String name, 
			String flavour, int numOf, int price) {
		
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavour);
		s.setNumOf(numOf);
		s.setFlavor(flavour);
		
		return "저장 완료되었습니다.\n" + "저장한 정보를 확인하겠습니까?(y/n) : ";

	}
	
	public String confirmData() {
		
		return s.information() ;
	}

}

package edu.kh.op.practice;

import java.util.Scanner;

public class OperatotPractice3 {
	
	Scanner ner = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("가격을 입력 하세요 : ");
		int price = ner.nextInt();
		
		System.out.print("멤버십 있으세요?(있으면 true / 없으면 false) ");
		boolean isMember = ner.nextBoolean();
		// "true" / "false"
		
		double discount = isMember ? price * 0.10 : price * 0.05;
		double totalPrice = price - discount;
		
		System.out.println("할인율 : " + discount);
		System.out.println("할인을 포함한 최종 금액 : " + totalPrice + "원" );
		
	}
	
	public void practice2() {
		System.out.println("출금할 금액 입력 : ");
		int amount = ner.nextInt();
		
		int ft = amount / 50000; // 5만원짜리 지폐 개수
		amount %= 50000; // 복합대입연산자
		// amount = amount % 50000;
		// 5만원짜리 지폐를 거르고 난 뒤 나머지 금액
		// 나머지 값을 amount 변수에 재대입해야 아래 다음 지폐에서 재사용 할 수 있다.
		
		int tt = amount / 10000; // 1만짜리 지폐 개수
		amount %= 10000;
		
		int sft = amount / 5000;
		amount %= 5000;
		
		int one = amount / 1000;
		amount %= 1000;
		
		System.out.println("50000원: " + ft);
		System.out.println("10000원: " + tt);
		System.out.println("5000원: " + sft);
		System.out.println("1000원: " + one);
	}
	
	public void practice3() {
		
		System.out.println("첫 번째 수 : ");
		int num1 = ner.nextInt();
		
		System.out.println("두 번째 수 : ");
		int num2 = ner.nextInt();
		
		// 첫번째 수가 두번째 수의 배수인지
		// == 첫번째 수가 두번째 수로 나누어 떨어진다
		// == 첫번째를 두번째로 나누었을때 나머지가 0이다
		String result = num1 % num2 == 0 ? "배수입니다" : "배수가 아닙니다";
		
		System.out.println(result);
	}
}

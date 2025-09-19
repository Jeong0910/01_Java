package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice {

	Scanner ner = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("인원 수 : ");
		int people = ner.nextInt();
		System.out.print("사탕 개수 : ");
		int candy = ner.nextInt();
		
		System.out.printf("1인당 사탕 개수 : %d\n", candy / people);
		System.out.println();
		System.out.printf("남는 사탕 개수 : %d\n", candy % people);
	}
	
	public void practice2() {
		System.out.print("이름 : ");
		String name = ner.next();
		System.out.print("학년 : ");
		int grade = ner.nextInt();
		System.out.print("반 : ");
		int cls = ner.nextInt();
		System.out.print("번호 : ");
		int number = ner.nextInt();
		ner.nextLine();
		System.out.print("성별 : ");
		String gender = ner.nextLine();
		System.out.print("성적 : ");
		double score = ner.nextDouble();
		System.out.println();
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다\n",grade,cls,number,gender,name,score);
	}
	
	public void practice3() {
		System.out.print("국어 : ");
		int kor = ner.nextInt();
		System.out.print("영어 : ");
		int eng = ner.nextInt();
		System.out.print("수학 : ");
		int math = ner.nextInt();
		int sum = kor+eng+math;
		double avg = sum / 3.0;
		
		System.out.println("합계 : " + sum);
		System.out.printf("평균 : %1.f\n" , avg);
		
		// 각 과목이 40점 이상이고,
		// 평균 60점 이상이어야 합격
		// 그 외 불합격 출력
		
		boolean result = (kor>=40) && (eng>=40) && (math>=40) && (avg>=60);
		
		System.out.println(result?"합격":"불합격");
		
	}
}

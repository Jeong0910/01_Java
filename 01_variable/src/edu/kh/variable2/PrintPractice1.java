package edu.kh.variable2;

public class PrintPractice1 {

	public static void main(String[] args) {
		
		//문제1
		int age = 35;
		System.out.println("나는"+age+"살입니다.");
		
		//문제2
		int score = 90;
		score = score + 10;
		// score = += 10;
		System.out.println("최종점수:"+ score);
		
		//문제3
		int a = 10;
		double b = a;
		System.out.println("a = "+ a);
		System.out.println("b = "+ b);
		
		//문제4
		double pi = 3.14159;
		int n = (int)pi;
		System.out.printf("pi = %.2f, n = %d\n",pi,n);
		
		//문제5
		char ch = 'A';
		int code = ch;
		System.out.printf("문자: %c, 코드값: %d\n", ch, code);
		
		//문제6
		final int PRICE = 5000;
		int count = 3;
		int total = PRICE * count;
		System.out.printf("물건가격: %d원, 개수: %d개, 총액: %d원\n", PRICE, count, total);
		
		//문제7
		int kor = 95, eng = 87, math = 90;
		int sum = kor + eng + math;
		double avg = sum/ 3.0; // 3으로 나누면 인트값으로 나오니 실수형인 소수점 .0을 붙여야 함.
		System.out.printf("국어: %d,영어 :%d,수학: %d\n",kor,eng,math);
		System.out.printf("총점: %d,평균: %.2f\n,",sum,avg);
		
		//--------------------------------------------------------------------------------------------
		
		
		//응용문제
		
		//문제1
		String name = "영숙";
		int Age = 28;
		double height = 165.7;
		
		//문제2
		System.out.printf("출연자 이름: %s\n", name);
		System.out.printf("나이: %d세\n", Age);
		System.out.printf("키: %.1fcm\n", height);
				
		//문제3
		double doubleAge = Age;
		System.out.println("자동 형변화된 나이(double):" + doubleAge);

		//문제4
		int intHeight = (int)height;
		System.out.println("강제 형변화된 키 (int):" + intHeight);
		
		//문제5
		int score1 = 87, score2 = 92;
		double avgScore = (score1 + score2)/ 2.0;
		System.out.printf("%s님의 매칭 점수 평균은 %.1f점입니다!", name, avgScore);
		
		
		
		
	}

}

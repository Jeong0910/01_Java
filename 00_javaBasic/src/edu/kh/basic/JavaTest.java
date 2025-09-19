package edu.kh.basic;

// 한줄 주석용 : 컴파일이 해석하지 않는 부분 (메모)
/* 범위 주석 (별이 없어도 됨.)
 * */
//main치고 컨트롤 스페이스 치면 자동완성.
public class JavaTest {
	public static void main(String[] args) {
		
		//main 메서드 안에 작성한 코드를 실행시키는 방법
		// 단축키 : ctrl + F11
		// 상단에 초록색 재생 버튼
		System.out.println("Hello World!!!");
		// syso 작성후 ctrl + space -> Enter 자동완성
		System.out.println("hi");
		System.out.println("오늘 저녁 뭐 먹지?");
		System.out.println("1234");
		System.out.println(1234);
		
		// 숫자 연산
		System.out.println("1+2"); //쌍따옴표 안에 있는 것은 문자로 인식
		System.out.println(1+2); //쌍따옴표 없는 코드는 숫자, 변수로 인식
		
		System.out.println(50 - 23);
		System.out.println(12 * 13);
		System.out.println(300 / 5);
		System.out.println(12 % 2); //모듈러(modulo) : 나머지
		
		
		// ctrl + alt 위아래 방향키 : 해당줄 복사
		System.out.println();
		System.out.println();
		System.out.println(); //개행 역할만(점프)
		
		// "" (문자열) + 숫자 함께 작성 : 이어쓰기
		// 숫자 + 숫자 : 더하기 연산
		System.out.println("14 * 19 = " + 14 * 19);
		
		
		//java는 사칙연산의 우선 순위를 그대로 따름
		// -> 우선 계산을 원하면 () 괄호 사용
		
		System.out.println("90 + 70 + 65 = " + 90 + 70 + 65 );  //이상하게 답이 나옴
		System.out.println("90 + 70 + 65 = " + ( 90 + 70 + 65 ) ); // 괄호를 넣어줘야 제대로 된 답이 나옴
		
		
		
		
		
	}
}

package com.hw3.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.hw3.model.dto.Book;

public class BookService {

	private Scanner sc = new Scanner(System.in);
	private List<Book> bookList = new ArrayList<>();

	public BookService() {

		bookList.add(new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원"));
		bookList.add(new Book(2222, "문과남자의 과학공부", "유시민", 15750, "돌베개"));
		bookList.add(new Book(3333, "역행자", "자청", 17550, "웅진지식하우스"));
		bookList.add(new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들"));
		bookList.add(new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스"));

	}

	public void displayMenu() {

		int menuNum = 0;

		do {

			try {
				System.out.println("===도서 목록 프로그램===");
				System.out.println("1. 도서 등록");
				System.out.println("2. 도서 조회");
				System.out.println("3. 도서 수정");
				System.out.println("4. 도서 삭제");
				System.out.println("5. 즐겨찾기 추가");
				System.out.println("6. 즐겨찾기 삭제");
				System.out.println("7. 즐겨찾기 조회");
				System.out.println("8. 추천도서 뽑기");
				System.out.println("0. 프로그램 종료");

				System.out.print("메뉴를 입력하세요 : ");
				menuNum = sc.nextInt();

				sc.nextLine();

				switch (menuNum) {
				case 1:
					System.out.println(addBook());
					break;
				case 2:
					bookselect(); break;
				case 3:
					updateBook(); break;
				case 4:
					/* 도서 삭제 */ break;
				case 5:
					/* 즐겨찾기 추가 */ break;
				case 6:
					/* 즐겨찾기 삭제 */ break;
				case 7:
					/* 즐겨찾기 조회 */ break;
				case 8:
					/* 추천도서 뽑기 */ break;
				case 0:
					System.out.print("프로그램을 종료합니다.");
					break;
				}

				if (menuNum < 0 && menuNum > 8) {
					System.out.println("0~8번 사이의 숫자만 선택해주세요.");
				}

			} catch (InputMismatchException e) {

			}

		} while (menuNum != 0);

	}

	public String addBook() {

		System.out.print("도서 번호 : ");
		int num = sc.nextInt();
		System.out.print("도서 제목 : ");
		String title = sc.nextLine();
		System.out.print("도서 저자 : ");
		String author = sc.next();
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		System.out.print("도서 출판사 : ");
		String publisher = sc.next();

		if (bookList.add(new Book(num, title, author, price, publisher))) {
			return "등록 완료";
		} else {

			return "등록 실패";

		}

	}

	public void bookselect() {

		System.out.println("도서 조회 프로그램");

		if (bookList.isEmpty()) {
			System.out.println("일치하는 도서가 없습니다.");
			return;
		}

		int input = 0;
		for (Book book : bookList) {
			System.out.print((input++) + "번 : ");
			System.out.println(book);

		}
	}
	
	public String updateBook() {
		
		System.out.println(bookList);
		
		System.out.println("=======도서 수정=======");
		
		System.out.println("수정할 도서 번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(bookList.isEmpty()) {
			return "입력된 도서 번호가 없습니다";
		}
		
		
		
		
		return "";
	}
}

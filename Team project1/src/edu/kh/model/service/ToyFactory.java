package edu.kh.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.kh.model.dto.Ingredient;
import edu.kh.model.dto.Toy;

public class ToyFactory extends Toy {
	// service

	private Scanner sc = new Scanner(System.in);
	private List<Toy> toyList = new ArrayList<Toy>();
	private Set<Ingredient> ingredientSet = new LinkedHashSet<Ingredient>();

	private Map<Integer, String> ingredientMap = new HashMap<Integer, String>();

	public Set<String> makeSet(int... ingredient) {

		// ingredient = 배열
		// [1, 2]
		// [1, 3, 2]
		Set<String> str = new HashSet<>();

		for (int item : ingredient) {
			if (ingredientMap.containsKey(item)) {
				String value = ingredientMap.get(item);
				str.add(value);
			}
		}

		return str;
	}

	// displayMenu();
	public ToyFactory() {

		ingredientMap.put(1, "면직물");
		ingredientMap.put(2, "플라스틱");
		ingredientMap.put(3, "유리");
		ingredientMap.put(4, "고무");

		toyList.add(new Toy("마미롱레그", 8, 36000, "분홍색", 19950805, makeSet(1, 4)));
		toyList.add(new Toy("허기워기", 5, 12000, "파란색", 19940312, makeSet(1, 2)));
		toyList.add(new Toy("키시미시", 5, 15000, "분홍색", 19940505, makeSet(1, 2)));
		toyList.add(new Toy("캣냅", 8, 27000, "보라색", 19960128, makeSet(1, 2)));
		toyList.add(new Toy("파피", 12, 57000, "빨간색", 19931225, makeSet(1, 2, 4)));

	}

	public ToyFactory(String name, int age, int price, String color, int year, Set<String> ingredientSet,
			List<Toy> list) {
		super(name, age, price, color, year, ingredientSet);
		this.toyList = list;
	}

	public void displayMenu() {
		int menuNum = 0;

		do {
			try {
				System.out.println("<<플레이타임 공장>>");
				System.out.println("1. 전체 장난감 조회하기");
				System.out.println("2. 새로운 장난감 만들기");
				System.out.println("3. 장난감 삭제하기");
				System.out.println("4. 장난감 제조일 순으로 조회하기");
				System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
				System.out.println("6. 재료 추가");
				System.out.println("7. 재료 제거");
				System.out.println("0. 종료");

				System.out.print("선택 : ");
				menuNum = sc.nextInt();

				switch (menuNum) {
				case 1: /* viewToyList() */
					viewToyList();
					break;
				case 2:/* addToy() */
					System.out.println(addToy());
					break;
				case 3:/* deleteToy() */
					deleteToy();
					break;
				case 4:/* searchToyByYears() */
					searchToyByYears();
					break;
				case 5:/*  */
					break;
				case 6:/**/
					break;
				case 7:/**/
					break;
				case 0:/**/
					System.out.println("종료합니다..");
					break;
				default:
					System.out.println("0~7 숫자를 입력해주세요.");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (menuNum != 0);
	}

	public void viewToyList() {
		System.out.println("<전체 장난감 목록>");

		for (int i = 0; i < toyList.size(); i++) {
			System.out.println((i + 1) + ". " + toyList.get(i));
		}
	}

	public String addToy() {
		System.out.println("<새로운 장난감 추가>");

		System.out.print("장난감 이름 : ");
		String name = sc.next();

		System.out.print("사용 가능 연령: ");
		int age = sc.nextInt();

		System.out.print("가격: ");
		int price = sc.nextInt();

		System.out.print("색상: ");
		String color = sc.next();

		System.out.print("제조일 (YYYYMMDD 형식으로 입력): ");
		int year = sc.nextInt();

		String input = "q";

		Set<String> set = new LinkedHashSet<String>();

		do {
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요): ");
			input = sc.next();

			set.add(input);

		} while (!input.equals("q"));

		toyList.add(new Toy(name, age, price, color, year, set));

		return "새로운 장난감이 추가되었습니다.";
	}

	public void deleteToy() {
		System.out.print("삭제할 장난감의 이름을 입력하세요: ");
		String input2 = sc.next();

		boolean flag = false;

		for (int i = 0; i < toyList.size(); i++) {
			if (toyList.get(i).getName().equals(input2)) {
				toyList.remove(i);
				flag = true; // 찾았다!!
				break;
			} else {
				System.out.println("못찾았습니다.");
			}
		}
		if (flag) { // 찾았을 경우
			System.out.println("장난감이 삭제되었습니다.");
		} else {
			System.out.println("장난감이 존재하지 않습니다.");
		}
	}
	public void searchToyByYears() {
		Collections.sort(toyList);
		
		System.out.println("제조일 순으로 장난감을 정렬");
		for(int i = 0; i < toyList.size(); i++) {
			System.out.println(toyList.get(i));
		}
	}
}

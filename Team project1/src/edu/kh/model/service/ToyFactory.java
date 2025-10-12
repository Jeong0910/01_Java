package edu.kh.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.kh.model.dto.Toy;

public class ToyFactory extends Toy {

	private Scanner sc = new Scanner(System.in);
	private Set<Toy> toyList = new LinkedHashSet<>();
	private Map<Integer, String> ingredientMap = new HashMap<>();

	private Set<String> makeSet(int... ingredient) {

		Set<String> str = new HashSet();

		for (int item : ingredient) {
			if (ingredientMap.containsKey(item)) {
				String value = ingredientMap.get(item);
				str.add(value);
			}
		}

		return str;
	}

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

	public ToyFactory(String toyName, int useAge, int price, String colour, int manufactureDate,
			Set<String> ingredientSet) {
		super(toyName, useAge, price, colour, manufactureDate, ingredientSet);

	}

	public void displayMenu() {

		int menuNum = 0;

		do {

			try {
				System.out.println("<< 플레이타임 공장>>");
				System.out.println("1. 전체 장난감 조회하기");
				System.out.println("2. 새로운 장난감 만들기");
				System.out.println("3. 장난감 삭제하기");
				System.out.println("4. 장난감 제조일 순으로 조회하기");
				System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
				System.out.println("6. 재료 추가");
				System.out.println("7. 재료 제거");

				System.out.print("선택 : ");
				menuNum = sc.nextInt();

				switch (menuNum) {
				case 1:
					viewAllToys(); break;
				case 2:
					System.out.println(makeNewToys()); break;
				case 3:
					removeToys(); break;
				case 4:
					viewToysByMD(); break;
				case 5:
					viewToysByUsableAge(); break;
				case 6:
					/* addIngredients(); */ break;
				case 7:
					/* removeIngredients(); */ break;
				case 0:
					System.out.println("종료합니다..");
					break;
				default:
					System.out.println("0~7 사이의 숫자를 입력하세요.");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (menuNum != 0);
	}
	
	public void viewAllToys() { //1
		
		System.out.println("\n<전체 장난감 목록>");
		
		Iterator<Toy> it = toyList.iterator();
		
		while(it.hasNext()) {
			
			String temp = it.next().toString();
			for(int i =0; i<toyList.size(); i++) {
				System.out.println((i+1) + ". " + temp); // 똑같은 정보가 여러개뜸.
				
			}
			
		}
		
	}
	public String makeNewToys() { //2
		
		System.out.println("<새로운 장난감 추가>");
		
		System.out.print("장난감 이름 : ");
		String toyName = sc.next();
		System.out.print("사용 가능 연령 : ");
		int useAge = sc.nextInt();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		System.out.print("색상 : ");
		String colour = sc.next();
		System.out.print("제조일 (YYYYMMDD 형식으로 입력) :");
		int manufactureDate = sc.nextInt();
		
		String input = "q";

		Set<String> ingredientSet = new LinkedHashSet<String>();
		
		
		do {
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요): ");
			input = sc.next();

			ingredientSet.add(input);
			
			if(input.equals("q")) {
				return "종료합니다..";
			}
			
			

		} while (!input.equals("q"));

		toyList.add(new Toy(toyName, useAge, price, colour, manufactureDate, ingredientSet));

		return "새로운 장난감이 추가되었습니다.";
		
	}
	
	public void removeToys() { //3
		
		System.out.print("삭제할 장난감의 이름을 입력하세요: ");
		String input = sc.next();
		
		List<Toy> list = new ArrayList<Toy>(toyList);
		
		boolean flag = false;

		for (int i = 0; i < toyList.size(); i++) {
			if (list.get(i).getToyName().equals(input)) {
				list.remove(i);
				flag = true;
				break;
			} else {
				System.out.println("못찾았습니다.");
			}
		}
		if (flag) {
			System.out.println("장난감이 삭제되었습니다.");
		} else {
			System.out.println("장난감이 존재하지 않습니다.");
		}
	}
	public void viewToysByMD() { //4
		
		System.out.println("<제조일 순으로 장난감을 정렬>");
		
		List<Toy> list = new ArrayList<Toy>(toyList);
		
		Collections.sort(list);
		
		for(int i = 0; i < toyList.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public String viewToysByUsableAge() { //5
		
		System.out.println("<연령별로 사용 가능한 장난감>");
		
		Set<Integer> list = new LinkedHashSet<Integer>();
		
		
		
		
		return "";
	}
}
package edu.kh.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.kh.model.dto.Toy;

public class ToyFactory extends Toy {

	private Scanner sc = new Scanner(System.in);
	
	// 중복된 Toy 객체가 없도록 저장할 컬렉션 중 Set
	private Set<Toy> toys = new LinkedHashSet<>();
	// 재료가 저장되어 있는 map
	private Map<Integer, String> materialMap = new HashMap<>();
	// -> Map<Integer, String>을 받는 materialmap이 new연산자 HashMap<> 생성.
	
	
	
	
	// 가변인자 : 매개변수의 수가 정확히 몇개인지 특정할 수 없을 때 사용
	// 자료형...변수명
	// 가변인자를 통해 들어온 매개변수의 데이터 타입은 배열!
	private Set<String> addMaterial(int... material) {
		// 1. 매개변수로 전달받은 materials 파악하기 == 배열로 정수형 데이터가 여러개 
		Set<String> str = new LinkedHashSet<>();
		// 2. 재료를 저장하여 반환할 Set객체를 생성
		// 3. addedMaterial 에 재료명을 추가해야함
		// -> 단, 재료는 Map에 존재하는 것만 추가 가능
		for (int item : material) {
			// Map에서 재료 고유 번호(Key)에 대응하는 재료명(Value)를 가져와서
			// addedMaterial 추가
			// map에 없는 key를 입력하여 value를 얻어왔을 때 == null
			if (materialMap.containsKey(item)) {
				String value = materialMap.get(item);
				str.add(value);
			}
		}

		return str;
	}

	public ToyFactory() {
		materialMap.put(1, "면직물");
		materialMap.put(2, "플라스틱");
		materialMap.put(3, "유리");
		materialMap.put(4, "고무");
		// materialmap.put()은 컬렉션Map을 사용해서 객체를 추가한다.
		toys.add(new Toy("마미롱레그", 8, 36000, "분홍색", 19950805, addMaterial(1, 4)));
		toys.add(new Toy("허기워기", 5, 12000, "파란색", 19940312, addMaterial(1, 2)));
		toys.add(new Toy("키시미시", 5, 15000, "분홍색", 19940505, addMaterial(1, 2)));
		toys.add(new Toy("캣냅", 8, 27000, "보라색", 19960128, addMaterial(1, 2)));
		toys.add(new Toy("파피", 12, 57000, "빨간색", 19931225, addMaterial(1, 2, 4)));
		// Set의 객체추가 add를 사용하여 뉴연산자 토이클래스에 정보추가.
	}
	
	// 상속
	public ToyFactory(String toyName, int age, int price, String colour, int manufactureDate, Set<String> materialSet) {
		super(toyName, age, price, colour, manufactureDate, materialSet);
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
				
				// void에서는 호출형태, String에서는 프린트구문.
				switch (menuNum) {
				case 1:
					/* viewAllToys(); */
					viewAllToys();
					break;
				case 2:
					/* makeNewToys(); */
					System.out.println(makeNewToys());
					break;
				case 3:
					/* removeToys(); */
					System.out.println(removeToys());
					break;
				case 4:
					/* viewToysByMD(); */
					System.out.println(viewToysByMD());
					break;
				case 5:
					/* viewToysByUsableAge(); */
					viewToysByUsableAge();
					break;
				case 6:
					/* addMaterials(); */
					addMaterials();
					break;
				case 7:
					/* removeMaterials(); */
					removeMaterials();
					break;

				case 0:
					System.out.println("종료합니다..");
					break;
				default:
					System.out.println("0~7 사이의 숫자를 입력하세요.");
				}

			} catch (InputMismatchException e) {
				e.printStackTrace();
			}

		} while (menuNum != 0);
	}

	/**
	 * 1. 전체 장난감 조회하기 드라이버 : 안재훈, 네비게이터 : 정석원
	 */
	public void viewAllToys() {
		System.out.println("\n<전체 장난감 목록>");
		
		// .size()는 length(길이)와 같은 기능을 한다.
		if (toys.size() == 0) {
			System.out.println("장난감이 존재하지 않습니다.");
		}
		
		// Set에서 사용해야하는 객체검색 Iterator.
		Iterator<Toy> it = toys.iterator();
		int index = 1;
		// hasNext()는 가지고 있는 확인해준다.
		while (it.hasNext()) {
			System.out.println((index++) + ". " + it.next().toString());
			// 여기서 index를 사용하는 이유는 번호를 넣기 위함이다.
		}

	}

	/**
	 * 2. 새로운 장난감 만들기 드라이버 : 안재훈, 네비게이터 : 정석원
	 */
	public String makeNewToys() {

		System.out.println("<새로운 장난감 추가>");

		System.out.print("장난감 이름 : ");
		String toyName = sc.next();
		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		System.out.print("색상 : ");
		String colour = sc.next();
		System.out.print("제조일 (YYYYMMDD 형식으로 입력) :");
		int manufactureDate = sc.nextInt();

		String input = "q";

		Set<String> materialSet = new LinkedHashSet<String>();
		
		while (true) {
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요): ");
			input = sc.next();

			if (input.equals("q"))// equal 문자열
				break;

			if (materialMap.containsValue(input)) {
				materialSet.add(input);// 매터리얼맵에 인풋(재료)에 기입한 값이 존재한다면,
										//매터리얼셋에 인풋(재료)를 추가한다.
			} else {
				System.out.println("존재하지 않는 재료입니다.");
			}

		}
		Iterator<Toy> it = toys.iterator();

		Toy addToy = new Toy(toyName, age, price, colour, manufactureDate, materialSet);

		boolean flag = false;
		while (it.hasNext()) {// hasNext()는 반복문에서 다음 요소가 있는지 확인하는 메서드
			Toy toyInfo = it.next();
			if (toyInfo.equals(addToy)) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			toys.add(addToy);
			return "새로운 장난감이 추가되었습니다.";
		} else {
			return "동일한 장난감이 등록되어있습니다.";
		}
	}

	/**
	 * 3. 장난감 삭제하기 드라이버 : 안재훈, 네비게이터 : 정석원
	 */
	public String removeToys() {
		if (toys.size() == 0) {
			return "장난감이 존재하지 않습니다.";
		}

		System.out.print("삭제할 장난감의 이름을 입력하세요: ");
		String input = sc.next();

		List<Toy> list = new ArrayList<Toy>(toys);

		boolean flag = false;

		for (int i = 0; i < toys.size(); i++) {
			if (list.get(i).getToyName().equals(input)) { //주의사항 : get***()은 Set컬렉션에서 사용할 수 없음으로 List써야함.
		// list.get(i)가 돌때, getToyNmae와 인풋이 동일하다면
				toys.remove(list.get(i));
				flag = true;
				break;
			}
		}
		if (flag) {
			return "장난감이 삭제되었습니다.";
		} else {
			return "장난감이 존재하지 않습니다.";
		}
	}

	/**
	 * 4. 장난감 제조일 순으로 조회하기 드라이버 : 안재훈, 네비게이터 : 정석원
	 */
	public String viewToysByMD() {
		if (toys.size() == 0) {
			return "장난감이 존재하지 않습니다.";
		}
		System.out.println("<제조일 순으로 장난감을 정렬>");
		List<Toy> list = new ArrayList<Toy>(toys);

		String result = ""; // 넘버를 새기기 위한 용도.
		Collections.sort(list);
		for (int i = 0; i < toys.size(); i++) {
			result += ((i + 1) + ". " + list.get(i)) + "\n";
		}
		return result;
	}

	/**
	 * 5. 연령별 사용 가능한 장난감 리스트 조회하기 드라이버 : 정석원, 네비게이터 : 안재훈
	 */
	public void viewToysByUsableAge() {
		// 1. toy에서 연령정보를 뽑아온다.
		// 2. 연령 정보를 set에 저장한다.
		// 3. 반복문(이중 for문) 을 통해서 연령을 비교해서 출력한다.
		System.out.println("<연령별로 사용 가능한 장난감>");

		Set<Integer> ageInfo = new LinkedHashSet<Integer>();

		for (Toy toy : toys) {
			ageInfo.add(toy.getage());
		}

		List<Toy> toyLists = new ArrayList<Toy>(toys);
		List<Integer> ageList = new ArrayList<Integer>(ageInfo);

		Collections.sort(ageList); // 오름차순 정렬
		Collections.sort(toyLists, new Comparator<Toy>() { // Comparator은 collection.sort( , ) 두번째 인자에서 compare 사용.
															// comparable은 클래스에서 사용하여 오버라이딩 CompareTo 사용.
			public int compare(Toy o1, Toy o2) {
				return o2.getManufactureDate() - o1.getManufactureDate();
			}
		});

		for (int age : ageList) {
			System.out.println("[연령:" + age + "세]");
			int index = 1;
			for (Toy toy : toyLists) {
				if (toy.getage() == age) {
					System.out.println(index++ + ". " + toy.toString());
				}
			}
		}

	}

	/**
	 * sub method : 6, 7 메소드에서 재료 출력 드라이버 : 정석원, 네비게이터 : 안재훈
	 */
	public void printMaterials() { // 서브 메서드
		System.out.println("===현재 등록 재료===");
		for (Map.Entry<Integer, String> material : materialMap.entrySet()) {
			// 리턴 타입 Map.Entry<Integer, String> 키와 값의 쌍으로 구성된 
			// 모든 Map.Entry 객체를 set에 담아서 리턴.
			System.out.println(material.getKey() + ":" + material.getValue());

		}
		System.out.println("=================");

	}

	/**
	 * 6. 재료 추가 드라이버 : 정석원, 네비게이터 : 안재훈
	 */

	public void addMaterials() {
		System.out.println("<재료 추가>");
		printMaterials(); // 서브 메서드 호출
		System.out.print("재료 고유번호(key) 입력:");
		int input = sc.nextInt();

		System.out.print("재료명 입력:");
		String name = sc.next();
		if (materialMap.containsKey(input)) { // 중복된 키가 존재할 때
			System.out.println("이미 해당키에 재료가 등록되어 있습니다.");
			System.out.print("덮어쓰시겠습니까?(Y/N)");
			String yesOrNo = sc.next();

			if (yesOrNo.equalsIgnoreCase("Y")) {
				materialMap.put(input, name);
				System.out.println("재료가 성공적으로 덮어쓰기 되었습니다.");
			} else {
				System.out.println("재료를 등록하지 않았습니다.");
			}
		} else { // 중복된 키가 존재하지 않을 때
			materialMap.put(input, name);
			System.out.println("새로운 재료가 성공적으로 등록되었습니다.");
		}
	}

	/**
	 * 
	 * 7. 재료 삭제 드라이버 : 정석원, 네비게이터 : 안재훈
	 */
	public void removeMaterials() {
		System.out.println("<재료 삭제>");
		printMaterials();

		System.out.print("삭제할 재료명 입력:");
		String name = sc.next();

		boolean flag = false;

		for (Map.Entry<Integer, String> material : materialMap.entrySet()) {
			if (material.getValue().equals(name)) {
				materialMap.remove(material.getKey());
				System.out.println("재료 '" + material.getValue() + "'가 성공적으로 제거되었습니다.");
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("해당 이름의 재료가 존재하지 않습니다.");
		}
	}
}
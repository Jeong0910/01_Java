package edu.kh.collection.pack3.model.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapService {

	// Map : key와 value 한쌍이 데이터가 되어 이를 모아둔 객체
	// key : value -> Entry라고 부름
	// key = Value

	// - key를 모아두면 set의 특징(중복 X)
	// - value를 모아두면 list의 특징(중복O)

	public void ex1() {

		// HashMap<Key, Value> : Map의 자식 클래스 중 가장 대표되는 Map
		Map<Integer, String> map = new HashMap<Integer, String>();

		// Map.put(Integer Key, String Value) : 추가
		map.put(1, "홍길동"); // {1=홍길동}
		map.put(2, "고길동");
		map.put(3, "김길동");
		map.put(4, "박길동");
		map.put(5, "이길동");
		map.put(6, "최길동");

		System.out.println(map);
		// key 중복 테스트
		map.put(1, "정석원"); // 키는 중복 x 대신 value 덮어쓰기
		System.out.println(map);

		map.put(7, "최길동");
		System.out.println(map);
	}

	public void ex2() {
		// Map 사용 예제

		// VO/DTO(값 저장용 객체)는 특정 데이터 묶음의 재사용이 많은 경우 사용함.
		// -> 재사용이 적은 VO는 오히려 코드 낭비
		// -> Map을 이용해서 VO와 비슷한 코드를 작성할 수 있음

		// 1) VO 버전
		Member member = new Member();

		// 값 세팅
		member.setId("userId"); // id=userId
		member.setPw("pass01");// pw=passo1
		member.setAge(30);// age=30

		// 2) Map 버전
		Map<String, Object> map = new HashMap<>();
		// value가 Object 타입 == 어떤 객체든 Value에 들어올 수 있다!

		// 값 세팅
		map.put("id", "user02"); // id=user02
		map.put("pw", "pass02"); // pw=pass02
		map.put("age", 25); // age=25

		// 값 출력
		// Object(value) Map.get(Key)
		// : 매개변수로 전달받음 Key와 대응되는 Value 반환
		System.out.println(map.get("id"));
		System.out.println(map.get("pw"));
		System.out.println(map.get("age"));

		System.out.println("------------------------------------");
		// **Map에 저장된 데이터에 순차적으로 접근하기**

		// Map에서 Key만 모아두면 Set의 특징을 가진다(중복 저장 X)
		// -> 이를 활용하여 Map에서 keySet() 메서드 제공
		// -> Key만 모아서 Set으로 반환

		Set<String> set = map.keySet(); // id, pw, age 라는 key가 저장된 Set 반환

		System.out.println("keySet() : " + set); // [ pw, id, age]

		// 향상된 for문

		for (String key : set) {
			System.out.println(map.get(key));
		}

		// map에 저장된 데이터가 많거나 (반복 필요)
		// 어떤 key가 있는지 불분명할때
		// 또는 map에 저장된 모든 데이터에 접근해야할 때
		// keySet() + 향상된 for문 코드사용 용이
	}

	public void ex3() {
		// List에 Map을 여러개 추가하여 다루기
		// List 객체 생성
		List<Map<String, Object>> list = new ArrayList<>();
		// List 객체 생성되었고, 해당 list에서는 Map만 들어올 수 있음을 제시함.
		// -> Map객체는 아직 생성되지 않았다.

		for (int i = 0; i < 10; i++) {
			// Map 객체 생성
			Map<String, Object> map = new LinkedHashMap<>();
			// HashMap은 순서를 보장하지 않는 자료구조
			// 순서를 유지하고 싶으면 LinkedHashMap 이용.
			// -> LinkedHashMap은 put 한 순서를 유지 시켜줌.

			// Map에 데이터 추가
			map.put("id", "user0" + i );
			map.put("pw", "pass0" + i );

			// Map을 list에 추가
			list.add(map);
		}
		// for문 종료시 list에 10개의 Map 객체가 추가되어 있음
		System.out.println(list);

		// 향상된 for문 이용해서 key가 "id"에 대응되는 value값 전부 출력하기

		for (Map<String, Object> temp : list) {
			System.out.println(temp.get("id"));
		}

	}
}

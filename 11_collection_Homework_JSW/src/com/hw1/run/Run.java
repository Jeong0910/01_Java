package com.hw1.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hw1.model.dto.Friend;

public class Run {

	public static void main(String[] args) {
		
		List<Friend> friendList = new ArrayList<>();
		
		
		
		friendList.add(new Friend("짱구"));
		friendList.add(new Friend("철수"));
		friendList.add(new Friend("유리"));
		friendList.add(new Friend("훈이"));
		friendList.add(new Friend("맹구"));
		
		// 1번 방법
		Random random = new Random();
		int randomIndex = random.nextInt(friendList.size());
		Friend leader = friendList.get(randomIndex);
		leader.pickLeader();
		
		// 2번 방법
		int mathRandom = (int)(Math.random()*5);
		Friend num = friendList.get(mathRandom);
		Friend call = new Friend(num.getName());
		call.pickLeader();
		
		
		
		
		
		
		
		
		
		
		
	}

}

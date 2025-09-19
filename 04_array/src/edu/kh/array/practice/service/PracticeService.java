package edu.kh.array.practice.service;

import java.util.Scanner;

public class PracticeService {

	Scanner sc = new Scanner(System.in);

	public void practice1() {
		int[] arr = new int[9];
		int sum = 0;

		for (int i = 1; i <= arr.length; i++) {
			System.out.print(i + " ");
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("\n짝수 번째 인덱스 합 : " + sum);
	}

	public void practice2() {
		int[] arr = new int[9];
		int sum = 0;

		for (int i = 9; i <= arr.length; i--) {
			System.out.print(i + " ");
			if (i % 2 != 0) {
				sum += i;
			}

		}
		System.out.println("\n홀수 번째 인덱스 합 : " + sum);

	}

	public void practice3() {

		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];

		for (int i = 1; i <= arr.length; i++) {
			System.out.print(i + " ");
		}
	}
}

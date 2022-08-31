package day0804;

import java.util.Arrays;
import java.util.Scanner;

public class TestDice {
	static int N, totalCnt;
	static int[] numbers;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int mode = sc.nextInt();
		totalCnt = 0;
		numbers = new int[N];
		
		switch (mode) {
		case 1:
			dice1(0);//duplicate permutation
			break;
		case 2:
			isSelected = new boolean[7];
			dice2(0);//Permutation
			break;
		case 3:
			dice3(0, 1);//duplicate combination
			break;
		case 4:
			isSelected = new boolean[7];
			dice4(0, 1);//combination
			break;
		
		}
		
		System.out.println(totalCnt);
	}
	
	private static void dice1(int cnt) {
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
	}
	
	private static void dice2(int cnt) {
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			dice2(cnt+1);
			isSelected[i] = false;
		}
	}
	
	private static void dice3(int cnt, int start) {
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i);
		}
	}
	
	//combination
	private static void dice4(int cnt, int start) {
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			dice4(cnt+1, i+1);
		}
	}

}

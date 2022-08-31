package day0804;

import java.util.Scanner;

public class SubSetTest {

	static int N, totalCnt; 
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		totalCnt = 0;
		input = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		subset(0);
		System.out.println(totalCnt);
	}
	
	private static void subset(int index) {
		if(index==N) {
			totalCnt++;
			for (int i = 0; i < N; i++) {
				System.out.print(isSelected[i]?input[i]:"X");
				System.out.print("\t");
			}
			System.out.println();
			return;
		}
		// atom select
		isSelected[index] = true;
		subset(index + 1);
		// atom non-select
		isSelected[index] = false;
		subset(index+1);
	}

}

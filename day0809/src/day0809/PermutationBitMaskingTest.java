package day0809;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitMaskingTest {
	static int N, R, totalCnt;
	static int[] numbers, input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		perm(0,0);
		System.out.println(totalCnt);
	}
	
	private static void perm(int cnt, int flag) {
		if(cnt==R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag & 1<<i)!=0) continue;
			
			numbers[cnt] = input[i];
			perm(cnt+1, flag | 1<<i);
		}
	}
}

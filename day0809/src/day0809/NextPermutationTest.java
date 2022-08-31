package day0809;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input);
		do {
			System.out.println(Arrays.toString(input));
		}while(np(input));
	}
	
	public static boolean np(int[] numbers) {
		int N = numbers.length;
		//find top
		int i = N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		if(i==0) return false;// 다음 순열을 만들 수 있는 가장 큰 순열의 상태
		//2. 꼭대기의 바로 앞자리(i-1)의 값을 크게 만들 교환 값 뒤쪽에서 찾기
		int j = N-1;
		while(numbers[i-1]>=numbers[j]) --j;
		
		//3. i-1의 위치값과 j위치값 교환
		swap(numbers, i-1, j);
		
		//4. i위치부터 맨뒤까지의 수열을 가장 작은 형태의 오름차순으로 변경
		int k = N-1;
		while(i<k) swap(numbers, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}

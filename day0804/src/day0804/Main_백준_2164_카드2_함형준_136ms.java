package day0804;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2164_카드2_함형준_136ms {
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[] arr = new int[2*N];
		for (int i = 1; i <= N; i++) {
			arr[i]=i;
		}
		int first = 1;
		int last = N;
		while(N>1) {
			first++;
			arr[last+1] = arr[first];
			last++;
			first++;
			N--;
		}
		System.out.println(arr[first]);
	}
}

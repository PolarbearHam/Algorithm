package day1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIStest2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];//수열의 수들
		int[] C = new int[N];// 동적테이블 C[k] : 해당(k) 길이를 만족하는 자리(k자리)에 오는 수의 최소값
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int size = 0;
		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(C, 0, size, arr[i]);
			if(pos>=0) continue;
			
			int insertPos = Math.abs(pos)-1;
			C[insertPos] = arr[i];
			
			if(insertPos == size) size++;
		}
		System.out.println(size);
		System.out.println(Arrays.toString(C));
	}
}

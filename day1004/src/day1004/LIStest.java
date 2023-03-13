package day1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIStest {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] LIS = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i = 0; i < N; i++) { //앞부터 모든 원소들을 기준으로 자신을 끝으로 하는 LIS계산
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i] && LIS[i]<LIS[j]+1) {
					LIS[i] = LIS[j]+1;
				}
			}
			max = Math.max(max, LIS[i]);
		}
		
		System.out.println(max);
		System.out.println(Arrays.toString(LIS));
		
	}
}

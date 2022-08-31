package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_함형준_183ms {
	public static StringBuilder sb = new StringBuilder();
	public static int N;
	public static int T;
	public static int L;
	public static int[] taste;
	public static int[] cal;
	public static int sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			taste = new int[N];
			cal = new int[N];
			sum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			combination(0,0,0);
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void combination(int cnt, int calSum, int tasteSum) {
		if(calSum>L) {
			return;
		}
		if(cnt==N) {
			sum = Math.max(sum, tasteSum);
			return;
		}
		combination(cnt+1, calSum+cal[cnt], tasteSum+taste[cnt]);
		combination(cnt+1, calSum, tasteSum);
	}
}

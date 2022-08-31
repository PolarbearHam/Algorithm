package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1948_날짜계산기_D2_함형준_98ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			
			int sum =0; int sum2 = 0;
			for (int i = 0; i < m; i++) {
				sum+=month[i];
			}
			sum = sum + d;
			
			m = Integer.parseInt(st.nextToken())-1;
			d = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < m; i++) {
				sum2+=month[i];
			}
			sum2 = sum2 + d;
			sb.append("#").append(test_case).append(" ").append(sum2-sum+1).append("\n");
		}
		System.out.println(sb);
	}
	
}

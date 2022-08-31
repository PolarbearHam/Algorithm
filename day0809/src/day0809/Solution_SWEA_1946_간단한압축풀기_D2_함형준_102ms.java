package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1946_간단한압축풀기_D2_함형준_102ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#").append(test_case).append("\n");
			int count = -1;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				int b = Integer.parseInt(st.nextToken());
				for (int j = 0; j < b; j++) {
					count++;
					if(count>0&&count%10==0) {
						sb.append("\n");
					}
					sb.append(a);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

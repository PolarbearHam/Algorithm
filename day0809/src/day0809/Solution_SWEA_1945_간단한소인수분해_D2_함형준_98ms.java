package day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1945_간단한소인수분해_D2_함형준_98ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int a =0; int b =0; int c =0; int d =0; int e =0;
			while(true) {
				if(N%2==0) {
					N=N/2;
					a++;
				}
				if(N%3==0) {
					N=N/3;
					b++;
				}
				if(N%5==0) {
					N=N/5;
					c++;
				}
				if(N%7==0) {
					N=N/7;
					d++;
				}
				if(N%11==0) {
					N=N/11;
					e++;
				}
				if(N==1)break;
			}
			sb.append("#").append(test_case).append(" ").append(a).append(" ").append(b).append(" ").append(c).append(" ").append(d).append(" ").append(e).append("\n");
		}
		System.out.println(sb);
	}
}

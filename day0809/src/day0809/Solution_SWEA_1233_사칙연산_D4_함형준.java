package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1233_사칙연산_D4_함형준 {
	public static StringBuilder sb = new StringBuilder();
	public static int N;
	public static int cur;
	public static char[] tree;
	public static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N+1];
			ans = 1;
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				cur = Integer.parseInt(st.nextToken());
				tree[cur] = st.nextToken().charAt(0);
				
				if(tree[cur]!='+'&&tree[cur]!='*'&&tree[cur]!='/'&&tree[cur]!='-') {
					if(cur%2==0 && cur/2>0) {
						if(tree[cur/2]!='+'&&tree[cur/2]!='-'&&tree[cur/2]!='*'&&tree[cur/2]!='/') {
							ans=0;
							continue;
						}
					}
				}
			}
			sb.append("#").append(test_case).append(" "+ans+"\n");
		}
		System.out.println(sb);
	}
}

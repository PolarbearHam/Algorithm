package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리_함형준_127ms {
	static int N, M;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N];
			
			for (int i = 0; i < N; i++) {
				p[i]=i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				
				int px = find(x);
				int py = find(y);
				
				if(px==py);
				if(px<=py) {
					p[py] = px;
				}else {
					p[px] = py;
				}
			}
			int cnt = 1;
			int[] ans = new int[N];
			ans[0] = find(0);
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				for (int j = 0; j < cnt; j++) {
					if(ans[j]==find(i)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					ans[cnt++] = find(i);
				}
			}
			sb.append("#").append(test).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int find(int x) {
		if(p[x]==x) return x;
		return p[x] = find(p[x]);
	}
}

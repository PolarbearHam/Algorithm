package day1201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_나무의키 {
	static int N, T, max, ans, sum, evenCnt;
	static int[] tree, diffheight;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			tree = new int[N];
			diffheight = new int[N];
			max=0; sum=0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}
			
			for (int i = 0; i < N; i++) {
				diffheight[i] = max-tree[i];
				sum+=diffheight[i];
			}
			
			evenCnt = 0;
			ans = 0;
			
			for (int h : diffheight) {
				evenCnt += h/2;
			}
			if(sum>evenCnt*3) {
				ans = evenCnt*2;
				int remain = sum - evenCnt*3;
				ans += remain*2-1;
			}else {
				ans = sum/3*2;
				if(sum%3==1) ans++;
				else if(sum%3==2) ans+=2;
			}
			
			
			sb.append("#").append(test).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}

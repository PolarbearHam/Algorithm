package day0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1952_수영장2 {
	static int min;
	static int[] pay, plan;
	static boolean[] month;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			pay = new int[4];
			plan = new int[12];
			month = new boolean[12];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				pay[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
				if(plan[i]!=0) month[i]=true;
			}
			min = pay[3];
			dfs(0, 0);
			sb.append("#").append(test).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void dfs(int month, int cost) {
		if(cost>=min) return;
		if(month>11) {
			if(min > cost) min = cost;
			return;
		}
		
		dfs(month+1, cost + Math.min(plan[month]*pay[0], pay[1]));
		dfs(month+3, cost + pay[2]);//3month cost dfs(month+3, cost+cost_3Month);
	}

}

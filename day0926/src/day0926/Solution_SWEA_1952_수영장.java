package day0926;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1952_수영장 {
	static int min, day, month, threeMonth, year;
	static int[] plan;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			threeMonth = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) {
				plan[i]=Integer.parseInt(st.nextToken());
			}
			min = year;
			dfs(0,0);
			sb.append("#").append(test).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int index, int cnt) {
		if(index>11) {
			if(min>cnt) min=cnt;
			return;
		}
		if(cnt>=min) return;
		dfs(index+1, cnt+day*plan[index]);
		dfs(index+1, cnt+month);
		dfs(index+3, cnt+threeMonth);
	}
}

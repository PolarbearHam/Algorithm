package day0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1149_RGB거리_S1_함형준_84ms {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int red=0, green=1, blue=2;
		int[][] cost = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			cost[i][red] = Integer.parseInt(st.nextToken());
			cost[i][green] = Integer.parseInt(st.nextToken());
			cost[i][blue] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			cost[i][red] += Math.min(cost[i-1][green], cost[i-1][blue]);
			cost[i][green] += Math.min(cost[i-1][red], cost[i-1][blue]);
			cost[i][blue] += Math.min(cost[i-1][green], cost[i-1][red]);
		}
		System.out.println(Math.min(cost[N-1][red], Math.min(cost[N-1][blue], cost[N-1][green])));
	}
}
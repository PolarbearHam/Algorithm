package day0804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15650_N과M2_Silver3_함형준_120ms {
	public static int N;
	public static int M;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		visit = new boolean[N];
		dfs(0, 1);
		System.out.println(sb);
		
	}
	public static void dfs(int depth, int start) {
		if(depth==M) {
			for (int i : numbers) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[depth]=i;
			dfs(depth+1, i+1);
		}
	}
}

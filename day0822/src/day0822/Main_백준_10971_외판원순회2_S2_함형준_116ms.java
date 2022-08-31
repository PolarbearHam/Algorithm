package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10971_외판원순회2_S2_함형준_116ms {
	static int N, result=Integer.MAX_VALUE;
	static int[][] W;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0] = true;
		dfs(0,0);
		System.out.println(result);
		
	}
	
	static void dfs(int cur, int cost) {
		if(visit()) {
			if(W[cur][0]!=0) {
				result = Math.min(result, cost+W[cur][0]);
			}
			return;
		}
		
		for (int i = 1; i < N; i++) {
			if(!visited[i] && W[cur][i]!=0) {
				visited[i] = true;
				dfs(i, cost + W[cur][i]);
				visited[i] = false;
			}
		}
	}
	
	static boolean visit() {
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}
}

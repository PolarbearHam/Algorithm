package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main_백준_10026_적록색약_G5_함형준_96ms {
	static char[][] grid, abgrid;
	static int N, normal, abnormal;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited, abvisited;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		abgrid = new char[N][N];
		visited = new boolean[N][N];
		abvisited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = s.charAt(j);
				if(s.charAt(j)=='G') {
					abgrid[i][j] = 'R';
				}else {
					abgrid[i][j] = s.charAt(j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, grid[i][j]);
					normal++;
				}
				if(!abvisited[i][j]) {
					abdfs(i, j, abgrid[i][j]);
					abnormal++;
				}
			}
		}
		System.out.println(normal+" "+abnormal);
	}
	
	static void dfs(int r, int c, char color) {
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0||nc<0||nr>=N||nc>=N||visited[nr][nc]||grid[nr][nc]!=color) continue;
			dfs(nr, nc, color);
		}
	}
	static void abdfs(int r, int c, char color) {
		abvisited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0||nc<0||nr>=N||nc>=N||abvisited[nr][nc]||abgrid[nr][nc]!=color) continue;
			abdfs(nr, nc, color);
		}
	}
}

package review;

import java.util.*;
import java.io.*;

public class BfsDfs {
	static int[] dr = {-1, 1, 0, 0};//up down left right
	static int[] dc = {0, 0, -1, 1};
	static int N = 5, C=1;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		arr = new int [N][N];
		visited = new boolean[N][N];
		
		bfs(N/2, N/2);
		for (int[] i : arr) System.out.println(Arrays.toString(i)); System.out.println();
	}
	static void dfs(int i, int j) {
		visited[i][j] = true;
		arr[i][j] = C;
		C++;
		for (int d = 0; d < 4; d++) {
			int nr = i+dr[d];
			int nc = j+dc[d];
			if(0<=nr&&nr<N&&0<=nc&&nc<N&& !visited[nr][nc]) dfs(nr, nc);
		}
	}
	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		visited[r][c] = true;
		q.offer(new int[] {r, c});
		while(!q.isEmpty()) {
			int[] rc=q.poll();
			//priority queue 사용 시에는 이 자리에 if(visited[r][c])continue; visited[r][c]=true; 로 방문처리를 해야함
			r = rc[0];
			c = rc[1];
			arr[r][c] = C++;
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(0<=nr&&nr<N&&0<=nc&&nc<N&& !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
}

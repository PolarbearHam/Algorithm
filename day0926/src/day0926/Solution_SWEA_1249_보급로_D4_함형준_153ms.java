package day0926;

import java.util.*;
import java.io.*;

public class Solution_SWEA_1249_보급로_D4_함형준_153ms {
	static int N, min;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			min = Integer.MAX_VALUE;
			visited = new boolean[N][N];
			distance = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			distance[0][0] = 0;
			bfs(0,0);
			sb.append("#").append(test).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		while(q.size()>0) {
			int[] p = q.poll();
			
			if(p[0]==N-1 && p[1]==N-1) {
				min = min>distance[N-1][N-1]? distance[N-1][N-1]:min;
			}
			if(min<=distance[p[0]][p[1]]) continue;
			for(int i=0; i<4; i++) {
				int nr = p[0]+dr[i];
				int nc = p[1]+dc[i];
				if(0<=nr&&0<=nc&&nr<N&&nc<N) {
					if(!visited[nr][nc] || distance[nr][nc]>distance[p[0]][p[1]]+map[nr][nc]) {
						visited[nr][nc] = true;
						distance[nr][nc] = distance[p[0]][p[1]]+map[nr][nc];
						q.offer(new int[] {nr,nc});
					}
				}
			}
		}
	}
}

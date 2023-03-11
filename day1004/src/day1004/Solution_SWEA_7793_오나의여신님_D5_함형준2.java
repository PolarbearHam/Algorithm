package day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_7793_오나의여신님_D5_함형준2 {
	static class Point{
		int r, c;
		boolean isDevil;
		public Point(int r, int c, boolean isDevil) {
			super();
			this.r = r;
			this.c = c;
			this.isDevil = isDevil;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[N][];
			for (int r = 0; r < N; r++) {
				map[r] = br.readLine().toCharArray();
			}
			Queue<Point> q = new LinkedList<Point>();
			Point sPoint = null;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(map[r][c]=='*') {
						q.offer(new Point(r, c, true));
					}else if(map[r][c]=='S') {
						sPoint = new Point(r, c, false);
					}
				}
			}
			q.offer(sPoint);
			int min = Integer.MAX_VALUE;
			int cnt = 1;
			ex : while(q.size()>0) {
				int size = q.size();
				while(--size>=0) {
					Point point = q.poll();
					int r = point.r;
					int c = point.c;
					boolean devil = point.isDevil;
					for (int i = 0; i < dr.length; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(0<=nr && 0<=nc && nr<N && nc<M) {//
							if(devil) {
								if(map[nr][nc]=='.'||map[nr][nc]=='S') {
									map[nr][nc]='*';
									q.offer(new Point(nr, nc, true));
								}
							}else {
								if(map[nr][nc]=='D') {
									min = cnt;
									break ex;
								}
								if(map[nr][nc]=='.') {
									map[nr][nc]='S';
									q.offer(new Point(nr, nc, false));
								}
							}
						}
					}
				}
				cnt++;
			}
			
			
			sb.append("#").append(test).append(" ").append(min==Integer.MAX_VALUE? "GAME OVER" : min).append("\n");
		}
		System.out.println(sb.toString());
	}
}

package day1004;

import java.io.*;
import java.util.*;

public class Solution_SWEA_7793_오나의여신님_D5_함형준 {
	static int N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c;
		boolean isDevil;

		public Point(int r, int c, boolean isDevil) {
			super();
			this.r = r;
			this.c = c;
			this.isDevil = isDevil;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			// 수연 s, 여신d, 돌x, 악마*, 평범.
			char[][] map = new char[N][];
			Point sPoint = null;
			Queue<Point> q = new LinkedList<Point>();
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '*') {// devil
						q.offer(new Point(i, j, true));// 큐에 바로넣기
					} else if (map[i][j] == 'S') {// 수연
						sPoint = new Point(i, j, false);// 수연이 좌표기록
					}
				}
			}
			q.offer(sPoint);
			int min = Integer.MAX_VALUE;
			// bfs
			int cnt = 1;// 이동횟수
			ex: while (q.size() > 0) {
				int size = q.size();
				System.out.println(size);
				while (--size >= 0) {
					Point point = q.poll();
					int r = point.r;
					int c = point.c;
					boolean isDevil = point.isDevil;
					System.out.println(point.r+":"+point.c);
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
							if (isDevil) {// devil
								if (map[nr][nc] == '.' || map[nr][nc] == 'S') {// 평범한 지역. 수연S
									map[nr][nc] = '*';// 악마의 손아귀
									q.offer(new Point(nr, nc, true));
								}
							} else {// suyeon
								System.out.println("??");
								if (map[nr][nc] == 'D') {
									min = cnt;
									break ex;
								}
								if (map[nr][nc] == '.') {
									map[nr][nc] = 'S';
									q.offer(new Point(nr, nc, false));
								}
							}
						}
					}
				}
				cnt++;
			}
			sb.append("#").append(test).append(" ").append(min == Integer.MAX_VALUE ? "GAME OVER" : min).append("\n");
		}
		System.out.println(sb.toString());
	}
}

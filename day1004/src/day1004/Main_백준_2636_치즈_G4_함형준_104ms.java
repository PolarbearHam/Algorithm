package day1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2636_치즈_G4_함형준_104ms {
	static int R, C, cheese, cnt;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < C; j++, index += 2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 1)
					cheese++;
			}
		}
		int time = 0;
		int ans = 0;
		while (cheese > 0) {
			time++;
			ans = cheese;
			melting();
		}
		System.out.println(time);
		System.out.println(ans);
	}// end of main

	static void melting() {
		visited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;
		while (q.size() > 0) {
			int[] pos = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = pos[0] + dr[i];
				int nc = pos[1] + dc[i];

				if (nr >= 0 && nc >= 0 && nr < R && nc < C && !visited[nr][nc]) {// 배열 안
					if (map[nr][nc] == 1) {
						cheese--;
						map[nr][nc] = 0;
					} else if (map[nr][nc] == 0) {
						q.offer(new int[] { nr, nc });
					}
					visited[nr][nc] = true;
				}
			} // end of drdc
		} // end of while
	}
}

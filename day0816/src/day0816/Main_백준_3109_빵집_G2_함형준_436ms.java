package day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_3109_빵집_G2_함형준_436ms {
	public static int[] dr = { -1, 0, 1 };// rightup right rightdown
	public static int[] dc = { 1, 1, 1 };
	public static boolean[][] visited;
	public static char[][] map;
	public static int count = 0;
	public static int R, C;
	public static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(1, i, 0);
		}

		System.out.println(count);

	}

	public static void dfs(int start, int r, int c) {
		if (start == C) {
			flag = true;
			count++;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc] && map[nr][nc] != 'x') {
				visited[r][c] = true;
				dfs(start + 1, nr, nc);
				if (flag)
					return;
			}
		}

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638 {
	static int N, M, time, count;
	static int[] start;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		map = new int[N][M];
		visited = new boolean[N][M];
		int flag = 0;
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if (map[i][j] == 1) {
					list.add(new int[] {i, j});
					count++;
				}
			}
		}
		while(count!=0) {
			time++;
			visited = new boolean[N][M];
			bfs();
			melting();
		}
		
		System.out.println(time);
	}

	static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;
		map[0][0] = 2;

		while (q.size() > 0) {
			int[] rc = q.poll();
			int r = rc[0];
			int c = rc[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (visited[nr][nc]||map[nr][nc]==1)
					continue;
				map[nr][nc] = 2;
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}
	static void melting() {
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i)[0];
			int c = list.get(i)[1];
			int cnt = 0;
			
			for (int j = 0; j < 4; j++) {
				int nr = r+dr[j];
				int nc = c+dc[j];
				
				if(map[nr][nc]==2)cnt++;
			}
			if(cnt>=2) {
				map[r][c] = 0;
				count--;
				list.remove(i);
				i--;
			}
		}
	}
}

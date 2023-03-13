import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {
	static int N, max, count;
	static int[][] map, transMap;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> q = new ArrayDeque<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 1;
		for (int i = 1; i <= 100; i++) {
			transMap = new int[N][N];
			count=0;
			visited = new boolean[N][N];
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(map[j][k]<=i) {
						transMap[j][k] = 0;
					}else transMap[j][k] = 1;
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(transMap[j][k]==1&&!visited[j][k]) {
						Search(j, k);
						count++;
					}
				}
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}

	private static void Search(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr<0||nc<0||nr>=N||nc>=N) continue;
			if(transMap[nr][nc]==1&&!visited[nr][nc]) {
				Search(nr, nc);
			}
		}
	}
}

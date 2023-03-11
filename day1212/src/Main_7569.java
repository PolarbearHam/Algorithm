import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {
	static int M, N, H, result;
	static int[][][] map;
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};
	static Queue<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k]==1) q.add(new int[] {i, j, k});
				}
			}
		}
		
		bfs();
		System.out.println(result);
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				System.out.println(Arrays.toString(map[i][j]));
			}
		}
	}

	private static void bfs() {
		while(q.size()>0) {
			int[] nrc = q.poll();
			int h = nrc[0];
			int r = nrc[1];
			int c = nrc[2];
			
			for (int i = 0; i < 6; i++) {
				int nh = h+dh[i];
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr<0||nc<0||nh<0||nr>=N||nc>=M||nh>=H) continue;
				if(map[nh][nr][nc]==0) {
					q.add(new int[] {nh, nr, nc});
					map[nh][nr][nc] = map[h][r][c]+1;
				}
			}
		}
		result = Integer.MIN_VALUE;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[i][j][k]==0) {
						result=-1;
						return;
					}
					result = Math.max(result, map[i][j][k]);
				}
			}
		}
		if(result==1) {
			result=0;
			return;
		}else {
			result-=1;
			return;
		}
	}
}

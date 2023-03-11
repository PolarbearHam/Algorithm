import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562 {
	static int I, ans, min;
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};
	static int[] start = new int[2], end = new int[2];
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q = new ArrayDeque<int[]>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			I = Integer.parseInt(br.readLine());
			map = new int[I][I];
			visited = new boolean[I][I];
			q.clear();
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			q.add(new int[] {start[0], start[1]});
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			if(start[0]==end[0]&&start[1]==end[1]) {
				System.out.println(0);
				continue;
			}
			for (int i = 0; i < I; i++) {
				Arrays.fill(map[i], Integer.MAX_VALUE);
			}
			map[start[0]][start[1]] = 0;
			bfs();
			System.out.println(map[end[0]][end[1]]);
		}
	}

	private static void bfs() {
		while(q.size()>0) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			
			for (int i = 0; i < 8; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(nr<0||nc<0||nr>=I||nc>=I) continue;
				if(visited[nr][nc]) continue;
				if(nr==end[0]&&nc==end[1]) {
					map[nr][nc] = Math.min(map[nr][nc], min);
				}
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
				map[nr][nc] = map[r][c]+1;
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940 {
	static int N, M;
	static int[][] map, distance;
	static Queue<int[]> q = new ArrayDeque<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		distance = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					q.add(new int[] {i, j, 0});
					visited[i][j] = true;
				}
			}
		}
		find();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1&&distance[i][j]==0) {
					distance[i][j] = -1;
				}
				sb.append(distance[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
		
	}
	
	public static void find() {
		while(q.size()>0) {
			int[] rc = q.poll();
			for(int i=0; i<4; i++) {
				int nr = rc[0] + dr[i];
				int nc = rc[1] + dc[i];
				int nd = rc[2] + 1;
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc]==0) continue;
				visited[nr][nc] = true;
				distance[nr][nc] = nd;
				q.add(new int[] {nr, nc, nd});
			}
		}
	}
}

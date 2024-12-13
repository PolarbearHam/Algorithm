import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261 {
	static int M, N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String s = "0"+br.readLine();
			char[] str = s.toCharArray();
			for(int j=1; j<=M; j++) {
				map[i][j] = str[j]-48;
			}
		}
		
		int ans = bfs(1, 1);
		System.out.println(ans);
		
	}
	
	public static int bfs(int r, int c) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		
		q.offer(new Point(r, c, 0));
		boolean[][] visited = new boolean[N+1][M+1];
		
		int nr, nc;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.r == N && p.c == M) {
				return p.cnt;
			}
			
			for(int i=0; i<4; i++) {
				nr = p.r + dr[i];
				nc = p.c + dc[i];
				
				if(nr<1||nc<1||nr>N||nc>M) {
					continue;
				}
				if(!visited[nr][nc] && map[nr][nc]==0) {
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc, p.cnt));
				}
				if(!visited[nr][nc] && map[nr][nc]==1) {
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc, p.cnt+1));
				}
				
			}
		}
		return 0;
		
	}

}

class Point implements Comparable<Point>{
	int r;
	int c;
	int cnt;
	
	Point(int r, int c, int cnt){
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
	
	@Override
	public int compareTo(Point o) {
		return cnt - o.cnt;
	}
}
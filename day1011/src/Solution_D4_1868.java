import java.util.*;
import java.io.*;


public class Solution_D4_1868 {
	static int N, X, K, L, Y;
	static char[][] map, map2;
	static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};//상하좌우 좌상 좌하 우상 우하
	static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};
	static Queue<int[]> q = new LinkedList<>();
	static Queue<int[]> q2 = new LinkedList<>();
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}//* mine . empty
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(search(i, j)&&map[i][j]=='.') {
						q.add(new int[] {i,j});
						visited[i][j]=true;
						spread();
					}
				}
			}
			K=0; L=0; Y=0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='*') K++;
					if(map[i][j]=='0'&&!visited[i][j]) {
						q.add(new int[] {i, j});
						visited[i][j]=true;
						bfs();
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) L++;
				}
			}
			sb.append("#").append(test).append(" ").append(Y+L-K).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void spread() {
		while(q.size()>0) {
			int[] rc = q.poll();
			int r = rc[0];
			int c = rc[1];
			char count='0';
			for (int i = 0; i < 8; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(nr<0||nc<0||nr>=N||nc>=N) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc]=='*') count++;
				
				if(map[nr][nc]=='.') {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
			map[r][c] = count;
		}
	}
	private static void bfs() {
		while(q.size()>0) {
			int[] rc = q.poll();
			int r = rc[0];
			int c = rc[1];
			
			for (int i = 0; i < 8; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(nr<0||nc<0||nr>=N||nc>=N) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc]=='0') {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
					X++;
				}
				if(map[nr][nc]!='*') visited[nr][nc]=true;
			}
		}
		Y++;
	}
	private static boolean search(int r, int c) {
		for (int i = 0; i < 8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr<0||nc<0||nr>=N||nc>=N) continue;
			if(map[nr][nc]=='*') return false;
		}
		return true;
	}
	
	
}

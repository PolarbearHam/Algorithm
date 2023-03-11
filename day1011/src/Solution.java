import java.util.*;
import java.io.*;

public class Solution {
	static int N, max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr= {1, 1, -1, -1};//우하 좌하 좌상 우상
	static int[] dc= {1, -1, -1, 1};
	static boolean[] dessert;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max=0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<N-2; i++) {
				for (int j = 1; j < N-1; j++) {
					visited = new boolean[N][N];
					dessert = new boolean[101];
					visited[i][j] = true;
					dessert[map[i][j]] = true;
					dfs(1, i, j, i, j, 0);
				}
			}
			if(max==0) max=-1;
			
			sb.append("#").append(test).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void dfs(int cnt, int r, int c, int sR, int sC, int prevDir) {
		for (int i = prevDir; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr<0||nc<0||nr>=N||nc>=N) continue;
			if(nr==sR&&nc==sC&&cnt>2) {
				max = Math.max(max, cnt);
				return;
			}
			if(visited[nr][nc]) continue;
			if(dessert[map[nr][nc]]) continue;
			visited[nr][nc] = true;
			dessert[map[nr][nc]] = true;
			dfs(cnt+1, nr, nc, sR, sC, i);
			visited[nr][nc] = false;
			dessert[map[nr][nc]] = false;
		}
	}

	
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SolutionSWEA1767_2 {
	static class Core{
		int r, c;
		public Core(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int N, size, min;
	static int[][] map;
	static Core[] core;
	static boolean[] visited;
	static int[] dr= {-1, 1, 0,0};
	static int[] dc= {0, 0, -1,1};
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			size = 0;
			core = new Core[12];
			visited = new boolean[12];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0, index=0; j < N; j++, index+=2) {
					map[i][j] = s.charAt(index) - 48;
				}
			}
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					if(map[i][j]==1) {
						core[size++] = new Core(i, j);
					}
				}
			}
			for (int i = size; i >= 0 ; i--) {
				combination(0, 0, i);
				if(min<Integer.MAX_VALUE) break;
			}
			sb.append("#").append(test).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static void combination(int start, int cnt, int R) {
		if(cnt==R) {
			dfs(0,0);
			return;
		}
		for (int i = start; i < size; i++) {
			visited[i] = true;
			combination(i+1, cnt+1, R);
			visited[i] = false;
		}
	}
	static void dfs(int idx, int cnt) {
		if(idx==size) {
			min = Math.min(min, cnt);
			return;
		}
		if(!visited[idx]) {
			dfs(idx+1, cnt);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int r = core[idx].r;
			int c = core[idx].c;
			boolean sucess = false;
			int tmp = 0;
			while(true) {
				r+=dr[i]; c+=dc[i];
				if(r<0||c<0||r>=N||c>=N) {
					sucess = true;
					break;
				}
				if(map[r][c]!=0) break;
				map[r][c] = 2;
				tmp++;
			}
			if(sucess) dfs(idx+1, cnt+tmp);
			while(true) {
				r-=dr[i]; c-=dc[i];
				if(r==core[idx].r&&c==core[idx].c) break;
				map[r][c]=0;
			}
		}
	}
}

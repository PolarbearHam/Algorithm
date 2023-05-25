import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144 {
	static int R, C, T, up, down;
	static int[][] map;
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		int count =0;
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1&&count==0) {
					up = i;
					down = i+1;
					count++;
				}
			}
		}
		
		bfs(0);
		int result = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==-1) continue;
				result += map[i][j];
			}
		}
		System.out.println(result);
	}
	
	public static void bfs(int time) {
		if(time==T) {
			return;
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!=-1&&map[i][j]!=0)q.add(new int[] {i, j, map[i][j]});
			}
		}
		spread();
		airClean();
		bfs(time+1);
	}
	
	public static void spread() {
		while(q.size()>0) {
			int[] rc = q.poll();
			int r = rc[0];
			int c = rc[1];
			int amount = rc[2];
			int divide = amount/5;
			int cnt = 0;
			if(amount<5) continue;
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr<0||nr>=R||nc<0||nc>=C) continue;
				if(map[nr][nc]==-1) continue;
				
				map[nr][nc] += divide;
				cnt++;
			}
			map[r][c] -= divide*cnt;
			
		}
	}
	public static void airClean() {
		for(int i=up-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		for(int i=0; i<C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		for(int i=0; i<up; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for(int i=C-1; i>1; i--) {
			map[up][i] = map[up][i-1];
		}
		map[up][1] = 0;
		
		for(int i=down+1; i<R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for(int i=0; i<C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		for(int i=R-1; i>down; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for(int i=C-1; i>1; i--) {
			map[down][i] = map[down][i-1];
		}
		map[down][1] = 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

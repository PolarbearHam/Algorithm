import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {
	static int max = Integer.MIN_VALUE;
	static int[][] arr;
	static boolean[][] visited;
	static int n, m;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				solve(i, j, arr[i][j], 1);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}
	public static void solve(int r, int c, int sum, int count) {
		if(count==4) {
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr<0||nc<0||nr>=n||nc>=m) continue;
			if(!visited[nr][nc]) {
				if(count==2) {
					visited[nr][nc] = true;
					solve(r, c, sum+arr[nr][nc], count+1);
					visited[nr][nc] = false;
				}
				visited[nr][nc] = true;
				solve(nr, nc, sum+arr[nr][nc], count+1);
				visited[nr][nc] = false;
			}
		}
	}
}

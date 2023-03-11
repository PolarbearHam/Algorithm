import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404 {
	static final int INF = 98765321;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] city = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i==j) continue;
				city[i][j] = INF;
			}
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			city[s][e] = Math.min(city[s][e], c);
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					city[i][j] = Math.min(city[i][k]+city[k][j], city[i][j]);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(city[i][j]==INF) {
					city[i][j]=0;
				}
				System.out.print(city[i][j]+" ");
			}
			System.out.println();
		}
	}
}

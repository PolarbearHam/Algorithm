import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14938 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] items = new int[n+1];
		int[][] edges = new int[n+1][n+1];
		int MAX_LEN = 16;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				edges[i][j] = MAX_LEN;
			}
		}
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			edges[a][b] = l;
			edges[b][a] = l;
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
					if(i==j || j==k || i==k) continue;
					edges[j][k] = Math.min(edges[j][i]+edges[i][k], edges[j][k]);
				}
			}
		}
		int max = 0;
		for(int i=1; i<=n; i++) {
			int temp = items[i];
			for(int j=1; j<=n; j++) {
				if(edges[i][j]<=m) {
					temp+=items[j];
				}
			}
			max = Math.max(temp, max);
		}
		System.out.println(max);
	}
}

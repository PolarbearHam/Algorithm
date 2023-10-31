import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17484 {
	static int N, M, min = Integer.MAX_VALUE;
	static int[] dr = {-1, -1, -1};
	static int[] dc = {-1, 0, 1};
	static int[][] arr;
	static int[][][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<M; i++) {
			dp[0][i][0] = arr[0][i];
			dp[0][i][1] = arr[0][i];
			dp[0][i][2] = arr[0][i];
		}
		for(int i=1; i<N; i++) {
			dp[i][0][0] = min;
			dp[i][M-1][2] = min;
			for(int j=0; j<M; j++) {
				if(!(j-1<0||j-1>=M)&&(j+1<0||j+1>=M)) {
					dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
				}else if(!(j-1<0||j-1>=M)&&!(j+1<0||j+1>=M)) {
					dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
					dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
				}else if((j-1<0||j-1>=M)&&!(j+1<0||j+1>=M)) {
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
					dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
				}
			}
		}
		int mini = min;
		for(int i=0; i<M; i++) {
			for(int j=0; j<3; j++) {
				mini = Math.min(mini, dp[N-1][i][j]);
			}
		}
		System.out.println(mini);
	}
}

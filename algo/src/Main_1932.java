import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1932 {
	static int[][] arr;
	static Integer[][] dp;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int max = 0;
		arr = new int[N][N];
		dp = new Integer[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < i+1; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			dp[N-1][i] = arr[N-1][i];
		}
		System.out.println(find(0,0));
	}
	private static int find(int depth, int idx) {
		if(depth==N-1) return dp[depth][idx];
		
		if(dp[depth][idx]==null) {
			dp[depth][idx] = Math.max(find(depth+1, idx), find(depth+1, idx+1))+arr[depth][idx];
		}
		return dp[depth][idx];
	}
}
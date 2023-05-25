import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010 {
	static int count;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		dp = new int[30][30];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(combination(M, N)).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	public static int combination(int n, int r) {
		if(dp[n][r]>0) {
			return dp[n][r];
		}
		if(n==r||r==0) {
			return dp[n][r]=1;
		}
		return dp[n][r] = combination(n-1, r-1) + combination(n-1, r);
	}
}

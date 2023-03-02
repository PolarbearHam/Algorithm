import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053 {
	static int[] seq;
	static Integer[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		seq = new int[N];
		dp = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			seq[i]  = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			LIS(i);
		}
		
		int max = dp[0];
		
		for (int i = 1; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	
	public static int LIS(int idx) {
		if(dp[idx]==null) {
			dp[idx]=1;
			
			for (int i = idx-1; i >= 0; i--) {
				if(seq[i]<seq[idx]) dp[idx] = Math.max(dp[idx], LIS(i)+1);
			}
		}
		return dp[idx];
	}
}

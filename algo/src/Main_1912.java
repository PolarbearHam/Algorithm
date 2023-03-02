import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1912 {
	static int N, max=Integer.MIN_VALUE;
	static int[] arr;
	static Integer[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		max = arr[0];
		
		recur(N-1);
		System.out.println(max);
	}

	private static int recur(int n) {
		if(dp[n]==null) {
			dp[n] = Math.max(recur(n-1)+arr[n], arr[n]);
			max = Math.max(dp[n], max);
		}
		return dp[n];
	}

	
}

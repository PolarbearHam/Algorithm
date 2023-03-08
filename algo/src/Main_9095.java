import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095 {
	static int dp[] = new int[11];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <11; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		for (int i = 0; i < T; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}
	
}

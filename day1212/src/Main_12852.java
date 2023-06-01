import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12852 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1,000,000
		int N = Integer.parseInt(br.readLine());
		Node[] dp = new Node[N+1];
		dp[1] = new Node(0, "1");
		
		for(int i=2; i<N+1; i++) {
			int cnt = Integer.MAX_VALUE;
			int before = 0;
			if(i%3==0) {
				cnt = dp[i/3].n;
				before = i/3;
			}
			if(i%2==0) {
				if(cnt>dp[i/2].n) {
					cnt = dp[i/2].n;
					before = i/2;
				}
			}
			if(cnt>dp[i-1].n) {
				before = i-1;
			}
			dp[i] = new Node(dp[before].n+1, i+" "+dp[before].process);
		}
		System.out.println(dp[N].n+"\n"+dp[N].process);
		
	}
	public static class Node{
		int n;
		String process;
		
		public Node(int n, String process) {
			this.n = n;
			this.process = process;
		}
	}
}

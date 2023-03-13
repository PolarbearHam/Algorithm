import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static int[][] arr;
	static boolean[] visited;
	
	static Queue<Integer> q = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	static Integer[][] dp;
	
	static char[] str1;
	static char[] str2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		dp = new Integer[str1.length][str2.length];
		
		System.out.println(lcs(str1.length-1, str2.length-1));
		
	}

	private static int lcs(int x, int y) {
		if(x==-1||y==-1) {
			return 0;
		}
		
		if(dp[x][y]==null) {
			dp[x][y]=0;
			
			if(str1[x]==str2[y]) {
				dp[x][y] = lcs(x-1, y-1)+1;
			}else {
				dp[x][y] = Math.max(lcs(x-1, y), lcs(x,y-1));
			}
		}
		return dp[x][y];
	}
}

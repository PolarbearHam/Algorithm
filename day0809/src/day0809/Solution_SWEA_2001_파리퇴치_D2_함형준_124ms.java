package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_D2_함형준_124ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int result = 0;
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] n = new int[N+1][N+1];
			int[][] sum = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					n[i][j] = Integer.parseInt(st.nextToken());
					if(i==1&&j==1) {
						result = n[i][j];
						sum[i][j]=result;
					}else {
						sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+n[i][j];
					}
				}
			}
			int max=0;
			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					result = sum[i][j]-sum[i-M][j]-sum[i][j-M]+sum[i-M][j-M];
					max = Math.max(max, result);
				}
			}
			
			
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}

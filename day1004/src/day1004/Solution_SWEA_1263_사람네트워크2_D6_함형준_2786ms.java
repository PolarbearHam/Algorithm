package day1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1263_사람네트워크2_D6_함형준_2786ms {
	static final int INF = 99999;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] net = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					net[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && net[i][j]==0) {
						net[i][j]=INF;
					}
				}
			}
			//경유지 출발지 목적지 순서로 돌려야함
			for(int k=0; k<N; k++) {
				for (int i = 0; i < N; i++) {
					if(i==k) continue;
					for (int j = 0; j < N; j++) {
						if(i==j||k==j) continue;
						if(net[i][j]>net[i][k]+net[k][j]) {
							net[i][j] = net[i][k] + net[k][j];
						}
					}
				}
			}
			int min=Integer.MAX_VALUE;
			int sum =0;
			for (int i = 0; i < net.length; i++) {
				for (int j = 0; j < net.length; j++) {
					sum+=net[i][j];
				}
				min = min>sum? sum:min;
				sum=0;
			}
			System.out.println("#"+test+" "+min);
		}
	}
}

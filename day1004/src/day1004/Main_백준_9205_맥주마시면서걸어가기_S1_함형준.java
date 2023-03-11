package day1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_9205_맥주마시면서걸어가기_S1_함형준 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n+2][n+2];
			boolean[][] visited = new boolean[n+2][n+2];
			List<int[]> list = new ArrayList<int[]>();
			for (int i = 0; i < n+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
					list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < n+2; j++) {
					int[] li1 = list.get(i), li2 = list.get(j);
					arr[i][j] = Math.abs(li1[0]-li2[0])+Math.abs(li1[1]-li2[1]);
					if(arr[i][j]<=1000) visited[i][j]=true;
				}
			}
			
			for (int k = 0; k < n+2; k++) {
				for (int i = 0; i < n+2; i++) {
					for (int j = 0; j < n+2; j++) {
						if(visited[i][k] & visited[k][j]) {
							visited[i][j] = true;
						}
					}
				}
			}
			System.out.println(visited[0][n+1]? "happy":"sad");
		}//end of testcase
	}//end of main
}

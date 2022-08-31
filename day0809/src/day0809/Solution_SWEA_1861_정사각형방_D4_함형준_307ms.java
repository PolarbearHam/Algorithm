package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_함형준_307ms {
	public static int T;
	public static int N;
	public static StringBuilder sb = new StringBuilder();
	public static int[][] map;
	public static int[] dr= {-1, 1, 0, 0};
	public static int[] dc= {0, 0, -1, 1};
	public static int cnt;
	public static int ans;
	public static int cur;
	//비선형 자료구조이지만 선형처럼 풀 수 있음 왜 why? 갈 수 있는 길이 하나이기 때문
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][N+2];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt=ans=cur=0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					bfs(i, j, 1, map[i][j]);
				}
			}
			sb.append("#"+test_case+" "+ans+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
	public static void bfs(int r, int c, int count, int current) {
		
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(map[nr][nc]-map[r][c]==1) {
				bfs(nr, nc, ++count, current);
			}
		}
		if(cnt==count) {
			if(ans>current) ans=current;
		}
		if(cnt<count) {
			cnt = count;
			ans = current;
		}
	}
}

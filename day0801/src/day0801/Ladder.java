package day0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ladder {
	static int size = 100;
	static int[] dr = { 0, 0, -1 };
	static int[] dc = { -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			int c=0;
			int r = 100;
			int[][] arr = new int[102][102];
			for (int i = 1; i <= 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2)
						c = j;
				}
			}
			while(r!=1) {
				for (int i = 0; i < 3; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if(arr[nr][nc]==1) {
						r = nr;
						c = nc;
						arr[r-dr[i]][c-dc[i]] = 3;
					}
					else continue;
				}
			}
			System.out.printf("#%d %d\n", test_case, c-1);
		}

	}
}

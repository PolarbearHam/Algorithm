package day0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Harvest {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			int y=0;
			for (int i = 0; i < N; i++) {
				char[] s = br.readLine().toCharArray();
				int j = i;
				if (j > (N / 2))
					j = -i + N - 1;
				for (int k = 0; k < -j + (N / 2); k++) {
					y++;
				}
				for (int l = 0; l < 2 * j + 1; l++) {
					sum+=s[y+l]-'0';
				}
				for (int m = 0; m < -j + (N / 2); m++) {
					y++;
				}
				y=0;
			}
			System.out.printf("#%d %d\n", test_case, sum);
		}

	}

}

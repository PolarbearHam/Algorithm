package day1004;

import java.util.*;
import java.io.*;

public class Solution_SWEA_4008_숫자만들기 {
	static int N, max, min;
	static int[] op, num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());// N=3~12
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			op = new int[4];// +-*/
			for (int i = 0; i < op.length; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			num = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			dfs(1, num[0]);// step, 지금까지의 연산결과

			sb.append("#").append(test).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb.toString());
	}

	// step, val 지금까지의 연산결과
	static void dfs(int step, int val) {
		if (step == N) {
			max = max < val ? val : max;
			min = min > val ? val : min;
			return;
		}
		// 재귀파트
		for (int i = 0; i < op.length; i++) {
			if (op[i] == 0)
				continue;
			op[i]--;
			switch (i) {
			case 0:
				dfs(step + 1, val + num[step]);
				break;
			case 1:
				dfs(step + 1, val - num[step]);
				break;
			case 2:
				dfs(step + 1, val * num[step]);
				break;
			case 3:
				dfs(step + 1, val / num[step]);
				break;
			}
			op[i]++;
		}

	}
}

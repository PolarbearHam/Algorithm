package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_16935_배열돌리기3_S1_함형준_380ms {
	public static StringBuilder sb = new StringBuilder();
	public static int N;
	public static int M;
	public static int R;
	public static int O;
	public static int[][] map;
	public static int[][] result;

	/**
	 * 1번 상하, 2번 좌우, 3번 오른90, 4번 왼90, 5번 4개그룹시계, 6번 4개그룹반시계 N,M은 짝수, 최대 100, R은
	 * 1000, Aij원소는 10^8;
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// row
		M = Integer.parseInt(st.nextToken());// column
		R = Integer.parseInt(st.nextToken());// rotate time
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			O = Integer.parseInt(st.nextToken());
			N = map.length;
			M = map[0].length;
			switch (O) {
			case 1:
				updown();
				map = result;
				break;
			case 2:
				leftright();
				map = result;
				break;
			case 3:
				right90();
				map = result;
				break;
			case 4:
				left90();
				map = result;
				break;
			case 5:
				partright90();
				map = result;
				break;
			case 6:
				partleft90();
				map = result;
				break;
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static void updown() {
		result = new int[N][M];
		result[N - 1] = Arrays.copyOf(map[0], M);
		for (int i = 0; i < N - 1; i++) {
			int j = -i + N - 1;
			result[i] = Arrays.copyOf(map[j], M);
		}
	}

	public static void leftright() {
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			result[i][M - 1] = map[i][0];
		}
		for (int i = 0; i < M - 1; i++) {
			for (int j = 0; j < N; j++) {
				int k = -i + M - 1;
				result[j][i] = map[j][k];
			}
		}
	}

	public static void right90() {

		result = new int[M][N];// 86
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int ri = -i + N - 1;// 5
				result[j][ri] = map[i][j];
			}
		}

	}

	public static void left90() {

		result = new int[M][N];// 86
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int rj = -j + M - 1;
				result[rj][i] = map[i][j];
			}
		}

	}

	public static void partright90() {
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			if (i >= N / 2) {
				int j = i - N / 2;// 345 012 12
				System.arraycopy(map[i], M / 2, result[i], 0, M / 2);// 왼쪽으로 당기기 3->4 43
				System.arraycopy(map[j], M / 2, result[i], M / 2, M / 2);// 아래거 위로 올리기 4->1
			} else {
				int j = i + N / 2;// 012 345
				System.arraycopy(map[i], 0, result[i], M / 2, M / 2);// 오른쪽으로 밀기1->2
				System.arraycopy(map[j], 0, result[i], 0, M / 2);// 위거 아래로 내리기2->3
			}
		}
	}

	public static void partleft90() {
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			if (i >= N / 2) {
				int j = i - N / 2;
				System.arraycopy(map[i], 0, result[i], M / 2, M / 2);// 4->3
				System.arraycopy(map[i], M / 2, result[j], M / 2, M / 2);// 3->2
			} else {
				int j = i + N / 2;
				System.arraycopy(map[i], M / 2, result[i], 0, M / 2);// 2->1
				System.arraycopy(map[i], 0, result[j], 0, M / 2);// 1->4
			}
		}
	}
}

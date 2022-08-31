package day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PCSTest {
	static int N, R, input[], numbers[];
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println("perm");
		permutation(0,0);
		System.out.println("combi");
		combination(0,0);
		System.out.println("subset");
		subset(0);
	}

	static void permutation(int cnt, int flag) {
		if (cnt == R) {
			System.out.print(Arrays.toString(numbers));
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			numbers[cnt] = input[i];
			permutation(cnt + 1, flag | 1 << i);
		}
	}

	static void combination(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
	}

	static void subset(int cnt) {
		if (cnt == R) {
			for (int i = 0; i < N; i++) {
				System.out.print(isSelected[i] ? input[i] : "X" + " ");
			}
			System.out.println();
			return;
		}
		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);
	}
}

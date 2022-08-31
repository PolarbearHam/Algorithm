package day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1074_Z_S1_함형준_124ms {
	public static int n, sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		n = (int) Math.pow(2, N);
		sum = 0;
		divide(n, r, c);
		System.out.println(sum);
	}

	public static void divide(int n, int r, int c) {
		if (n == 1)
			return;

		n = n / 2;
		if (r < n && c < n) {
			divide(n, r, c);
		} else if (r < n && c >= n) {
			sum = sum + (int) Math.pow(n, 2);
			divide(n, r, c - n);
		} else if (r >= n && c < n) {
			sum = sum + (int) Math.pow(n, 2) * 2;
			divide(n, r - n, c);
		} else if (r >= n && c >= n) {
			sum = sum + (int) Math.pow(n, 2) * 3;
			divide(n, r - n, c - n);
		}

	}
}

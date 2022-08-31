package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1759_암호만들기_G5_함형준_76ms {
	public static StringBuilder sb = new StringBuilder();
	public static int L, C, bcount, acount;
	public static char[] arr, res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		res = new char[L];
		String s = br.readLine();
		for (int i = 0, index = 0; index < s.length(); i++, index += 2) {
			arr[i] = s.charAt(index);
		}
		Arrays.sort(arr);
		comb(0, 0);
		System.out.println(sb);
	}

	public static void comb(int depth, int start) {
		if (depth == L) {
			acount = 0;
			bcount = 0;
			for (int i = 0; i < res.length; i++) {
				if (res[i] == 'a' || res[i] == 'e' || res[i] == 'i' || res[i] == 'o' || res[i] == 'u') {
					acount++;
				} else {
					bcount++;
				}
			}
			if (acount >= 1 && bcount >= 2) {
				for (int i = 0; i < res.length; i++) {
					sb.append(res[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = start; i < C; i++) {
			res[depth] = arr[i];
			comb(depth + 1, i + 1);
		}
	}
}

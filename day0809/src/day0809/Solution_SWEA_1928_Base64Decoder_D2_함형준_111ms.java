package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

public class Solution_SWEA_1928_Base64Decoder_D2_함형준_111ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String encode = br.readLine();
			String decode = new String(Base64.getDecoder().decode(encode));
			sb.append("#").append(test_case).append(" ").append(decode).append("\n");
		}
		System.out.println(sb);
	}
}

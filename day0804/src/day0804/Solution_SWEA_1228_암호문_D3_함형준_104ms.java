package day0804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_1228_암호문_D3_함형준_104ms {
	public static int N;
	public static String S;
	public static String s;
	public static String[] srr;
	public static String[] Srr;
	public static int SrrL;
	public static int T;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			N = Integer.parseInt(br.readLine());
			S = br.readLine();
			Srr = S.split(" ");
			SrrL = Srr.length;
			ArrayList<String> arrSrr = new ArrayList<String>();
			for (int i = 0; i < SrrL; i++) {
				arrSrr.add(Srr[i]);
			}
			T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "I");
			
			for (int i = 0; i < T; i++) {
				srr = st.nextToken().split(" ");
				int srrL = Integer.parseInt(srr[2]);
				int SrrIndex = Integer.parseInt(srr[1]);
				for (int j = 3; j < srrL + 3; j++) {
					if (SrrIndex >= SrrL) continue;
					arrSrr.add(SrrIndex++, srr[j]);
				}
			}
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(arrSrr.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}

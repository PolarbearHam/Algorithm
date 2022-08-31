package day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1992_쿼드트리_S1_함형준_124ms {
	public static String[] s;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		s = new String[N];
		for (int i = 0; i < N; i++) {
			s[i]=br.readLine();
		}
		
		divide(N, 0, 0);
		System.out.println(sb);
	}
	
	public static void divide(int n, int r, int c) {
		if(check(n, r, c)) {
			sb.append(s[r].charAt(c));
			return;
		}
		
		n/=2;
		sb.append("(");
		divide(n, r, c);
		divide(n, r, c+n);
		divide(n, r+n, c);
		divide(n, r+n, c+n);
		sb.append(")");
	}
	
	public static boolean check(int n, int r, int c) {
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(s[i].charAt(j)!=s[r].charAt(c)) return false;
			}
		}
		return true;
	}
}

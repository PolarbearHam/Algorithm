package day0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1463_S3_함형준_112ms {
	static int N, min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		
		recursive(N, 0);
		System.out.println(min);
	}
	private static void recursive(int n, int cnt) {
		if(n==1) {
			if(min>cnt) min = cnt;
			return;
		}
		if(n<=0) return;
		if(cnt>min) return;
		if(n%3==0)	recursive(n/3, cnt+1);
		if(n%2==0)	recursive(n/2, cnt+1);
		recursive(n-1, cnt+1);
	}
}

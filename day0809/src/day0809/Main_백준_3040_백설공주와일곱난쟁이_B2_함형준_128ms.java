package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_3040_백설공주와일곱난쟁이_B2_함형준_128ms {
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr = new int[9];
	public static boolean[] visited = new boolean[9];
	public static int sum, N, R;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		combination(0, 0, 7);
		System.out.println(sb);
	}
	
	public static void combination(int cnt, int minSum, int r) {
		if(r==0&&minSum==100) {
			for (int i = 0; i < arr.length; i++) {
				if(visited[i]==true) sb.append(arr[i]).append("\n");
			}
			return;
		}
		if(cnt==9) return;
		
		visited[cnt] = true;
		combination(cnt+1, minSum+arr[cnt], r-1);
		visited[cnt] = false;
		combination(cnt+1, minSum, r);
	}
}

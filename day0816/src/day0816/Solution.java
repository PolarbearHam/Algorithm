package day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int count = 0;
		int index = 0;
		int min = Integer.MAX_VALUE;
		char[] s = new char[32];
		int[][] arr2 = new int[N+1][M];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				count = 0;
				s = Integer.toBinaryString(i^arr[j]).toCharArray();
				for (int k = 0; k < s.length; k++) {
					if(s[k]=='1') count++;
				}
				arr2[i][j] = count;
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				if(arr2[i][j]==0) continue;
				if(max<=arr2[i][j]) {
					max = arr2[i][j];
					index = i;
				}
			}
		}
		
		System.out.println(Arrays.deepToString(arr2));
		System.out.print(min);
	}
}

package day0822;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution123 {
	static int[][] arr = new int[100][100];
	static String s;
	static int[] dr = {1, -1};//down up
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		for (int test = 1; test <= 10; test++) {
			br.readLine();
			for (int i = 0; i < 100; i++) {
				s = br.readLine();
				for (int j = 0, index=0; index < s.length(); j++, index+=2) {
					arr[i][j] = s.charAt(index);
				}
			}
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if(arr[i][j]==0)  continue;
					dfs(0, i, j);
				}
			}
			System.out.println(count);
			System.out.println(Arrays.toString(arr[0]));
		}
	}
	
	public static void dfs(int depth, int r, int c) {
		
		if(arr[r][c]=='1') {
			int nr = r+1;
			if(nr>=100) {
				arr[r][c]=0;
				return;
			}
			if(arr[nr][c]=='2') {
				count++;
				return;
			}else {
				arr[r][c]=0;
				dfs(depth+1, nr, c);
			}
		}
		if(arr[r][c]=='2') {
			int nr = r-1;
			if(nr<0) {
				arr[r][c]=0;
				return;
			}
			if(arr[nr][c]=='1') {
				count++;
				return;
			}else {
				arr[r][c]=0;
				dfs(depth+1, nr, c);
			}
		}
	}
}

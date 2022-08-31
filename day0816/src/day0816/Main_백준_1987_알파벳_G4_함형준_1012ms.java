package day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳_G4_함형준_1012ms {
	public static char[][] map;
	public static boolean[] duplicate;
	public static int R, C, count;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static ArrayList<Character> word;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		duplicate = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j]=s.charAt(j);
			}
		}
		count=0;
		dfs(0, 0, 1);
		System.out.println(count);
	}
	
	
	public static void dfs(int r, int c, int cnt) {
		duplicate[map[r][c]-'A'] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			int ncnt = cnt+1;
			
			if(nr<0 || nr >= R || nc<0 || nc>=C) continue;
			if(duplicate[map[nr][nc]-'A']) {
				count = Math.max(count, cnt);
				continue;
			}

			duplicate[map[nr][nc]-'A']=true;
			dfs(nr, nc, ncnt);
			duplicate[map[nr][nc]-'A']=false;
		}
	}
}

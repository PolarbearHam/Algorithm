import java.util.*;
import java.io.*;

public class Solution_2112_보호필름 {
	static int R, C, K, answer;
	static int[] arr, copy, layer0, layer1;
	static int[][] map;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = Integer.MAX_VALUE;
			layer0 = new int[C];
			layer1 = new int[C];
			Arrays.fill(layer1, 1);
			for (int i = 0; i <= R; i++) {
				combination(0, 0, i);
				if(answer<Integer.MAX_VALUE) break;
			}
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}


	private static void combination(int idx, int cnt, int r) {
		if(cnt==r) {
			if(check(map)) {
				answer = Math.min(answer, cnt);
			}
			return;
		}
		if(idx==R) return;
		
		combination(idx+1, cnt, r);
		int[] now = map[idx];
		map[idx] = layer0;
		combination(idx+1, cnt+1, r);
		map[idx] = layer1;
		combination(idx+1, cnt+1, r);
		
		map[idx] = now;
	}


//	private static int[][] deepcopy(int[][] map2) {
//		int[][] cop = new int[map2.length][map2[0].length];
//		
//		for (int i = 0; i < map2.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				cop[i][j] = map2[i][j];
//			}
//		}
//		return cop;
//	}
	
	static boolean check(int[][] map2) {
		for (int j = 0; j < C; j++) {
			int cnt=1;
			for (int i = 1; i < R; i++) {
				if(map2[i-1][j]==map2[i][j]) cnt++;
				else cnt=1;
				if(cnt==K) break;
			}
			if(cnt<K) return false;
		}
		return true;
	}
}

package day1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_SWEA_5656_BFS {
	static int N, W, H, min;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			go(map, 0);
			sb.append("#").append(test).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	static boolean go(int[][] map, int cnt) {
		int result = getRemain(map);
		if (result == 0) {
			min = result;
			return true;
		}

		if (cnt == N) {// 구슬을 다 던진 상태
			// 남은 벽돌 개수 카운팅
			min = min > result ? result : min;
			return false;
		}
		int[][] newMap = new int[H][W];
		// duplicate permutation
		for (int c = 0; c < W; c++) {

			// 구슬에 맞는 시작벽돌 찾기
			int r = 0;
			while (r < H && map[r][c] == 0)
				++r;

			if (r == H) {// 맞는 시작벽돌이 없는상태
				continue;
			} else {// 맞는 시작돌이 있는상태
				copy(map, newMap);
				// 제거될 벽돌 연쇄 처리
				boom(newMap, r, c, newMap[r][c]);
				// 벽동 중력 처리
				down(newMap);
				// 다음 구슬 던지기
				if (go(newMap, cnt + 1))
					return true;
			}
		}
		return false;
	}

	private static int getRemain(int[][] map) {
		int result = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (map[r][c] > 0)
					result++;
			}
		}

		return result;
	}

	static void boom(int[][] map, int r, int c, int cnt) {// dfs
		// 벽돌이 있던 자리를 0으로 변경: 빈칸으로 만들어서 방문처리
		map[r][c] = 0; // 방문처리
		if (cnt == 1)
			return;

		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			for (int k = 1; k < cnt; k++) {
				nr += dr[d];
				nc += dc[d];
				if (nr >= 0 && nc >= 0 && nr < H && nc < W && map[nr][nc] > 0) {
					boom(map, nr, nc, map[nr][nc]);
				}
			}
		}
	}

//	static void boom(int[][] map, int r, int c) {//bfs
//		Queue<Point> queue = new ArrayDeque<Point>();
//		//벽돌이 있던 자리를 0으로 변경: 빈칸으로 만들어서 방문처리
//		queue.offer(new Point(r, c, map[r][c]));
//		if(map[r][c]>1) {
//			queue.offer(new Point(r, c, map[r][c]));
//		}
//		map[r][c] = 0; //방문처리
//		
//		while(!queue.isEmpty()) {
//			Point p = queue.poll();//주변에 영향주는 벽돌 정보
//			//벽돌의 크기-1만큼 주변 벽돌 처리
//			for (int d = 0; d < 4; d++) {
//				int nr = p.r;
//				int nc = p.c;
//				for (int k = 1; k < p.cnt; k++) {
//					nr += dr[d];
//					nc += dc[d];
//					if(nr>=0&&nc>=0&&nr<H&&nc<W && map[nr][nc]>0) {
//						if(map[nr][nc]>1) {
//							queue.offer(new Point(nr, nc, map[nr][nc]));
//						}
//						map[nr][nc] = 0;
//					}
//				}
//			}
//		}
//		
//	}

	static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static Stack<Integer> stack = new Stack<Integer>();

	static void down(int[][] map) {
		for (int c = 0; c < W; c++) {
			// 윗행부터 남은 벽돌 스택에 넣기
			for (int r = 0; r < H; r++) {
				if (map[r][c] > 0) {
					stack.push(map[r][c]);
					map[r][c] = 0;
				}
			} // 남은 벽돌은 스택에 들어있고 모든 칸은 빈칸 상태
			int nr = H - 1;
			while (!stack.isEmpty()) {
				map[nr--][c] = stack.pop();
			}
		}
	}
//	static void down(int[][] newMap) {
//		for (int c = 0; c < W; c++) {
//			int r = H-1;
//			while(r>0) {
//				if(newMap[r][c] ==0) {//빈칸이면 내릴 벽돌 찾기
//					int nr = r-1;
//					while(nr>0&&newMap[nr][c]==0) nr--;
//					newMap[r][c] = newMap[nr][c];
//					newMap[nr][c] = 0;
//				}
//				--r;
//			}
//		}
//	}
}

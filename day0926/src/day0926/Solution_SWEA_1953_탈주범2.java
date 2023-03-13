package day0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1953_탈주범2 {
	static int N, M, R, C, L;
	static int[][] map;
	static int[] dr= {-1, 1, 0, 0};
	static int[] dc= {0, 0, -1, 1};
	static boolean[][] visited;
	//터널 구조물의 타입
	static int[][] dir = {{},//0. 터널없음
						  {0,1,2,3},//1. 상하좌우
						  {0,1},//2. 상하
						  {2,3},//3. 좌우
						  {0,3},//4. 상우
						  {1,3},//5. 하우
						  {1,2},//6. 하좌
						  {0,2},//7. 상좌
	};
	static boolean[][] check = {
			{false,true,true,false,false,true,true,false},
			{false,true,true,false,true,false,false,true},
			{false,true,false,true,true,true,false,false},
			{false,true,false,true,false,false,true,true}
	};
	//0 1 2 3 4 5 6 7
	//0 1 1 0 0 1 1 0//상: 하 존재하는 터널
	//0	1 1	0 1	0 0 1//하: 상 존재하는 터널
	//0	1 0	1 1	1 0 0 //좌: 우 존재하는 터널
	//0	1 0	1 0	0 1 1//우: 좌 존재하는 터널
	static class Pos{
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0, index=0; j < M; j++, index+=2) {
					map[i][j] = s.charAt(index)-'0';
				}
			}
			//0은 터널X, 1은 상하좌우, 2는 상하, 3은 좌우, 4는 상우, 5는 하우, 6은 하좌, 7은 상좌
			int cnt =0;
			Queue<Pos> q = new LinkedList<Pos>();
			cnt++;
			visited[R][C] = true;
			q.offer(new Pos(R,C));
			while(--L>0 && q.size()>0) {
				int size = q.size();//현재 큐의 사이즈, 같은 레벨의 크기
				for (int i = 0; i < size; i++) {//현재 레벨의 크기 만큼만 탐색
					Pos pos = q.poll();	//q에서 거내기
					int type = map[pos.r][pos.c];
					for (int j = 0; j < dir[type].length; j++) {
						int nr = pos.r+dr[dir[type][j]];
						int nc = pos.c+dc[dir[type][j]];
						//꺼낸 위치에서 갈 수 있는 칸 확인
						if(0<=nr && nr<N && 0<=nc && nc<N &&
								check[dir[type][j]][map[nr][nc]] && !visited[nr][nc]) {
							cnt++;
							visited[nr][nc] = true;
							q.offer(new Pos(nr,nc));
							
						}
					}
				}
				//꺼낸 위치에서 갈 수있는 칸을 탐색, 미방문, 가능한 터널인지 확인
			}
			
			sb.append("#").append(test).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}

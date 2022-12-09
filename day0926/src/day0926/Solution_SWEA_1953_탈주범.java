package day0926;
import java.util.*;
import java.io.*;

public class Solution_SWEA_1953_탈주범 {
	static int N, M, R, C, L, count;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] dir = {
			{},//0~7 방향
			{0,1,2,3},//상:0 하:1 좌:2 우:3
			{0,1},
			{2,3},
			{0,3},
			{1,3},
			{1,2},
			{0,2}
	};
	static boolean[][] possible = {//다음 방향으로의 연결이 가능한지 [각방향명령어][상하좌우 4방향]
			{false,true,true,false,false,true,true,false},
			{false,true,true,false,true,false,false,true},
			{false,true,false,true,true,true,false,false},
			{false,true,false,true,false,false,true,true}
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0, index=0; j<M; j++, index+=2) {
					map[i][j] = s.charAt(index)-'0';
				}
			}
			count = 0;
			boolean[][] visited = new boolean[N][M];
			Queue<int[]> q = new ArrayDeque<int[]>();
			q.offer(new int[] {R, C});
			count++;
			visited[R][C] = true;
			while(--L>0 && q.size()>0) {
				int size = q.size();
				for(int i=0; i<size; i++) {
					int[] now = q.poll();
					int type = map[now[0]][now[1]];
					System.out.println(now[1]);
					for(int j=0; j<dir[type].length; j++) {
						int nr = now[0]+dr[dir[type][j]];
						int nc = now[1]+dc[dir[type][j]];
						if(0<=nr&&0<=nc&&nr<N&&nc<M&&possible[dir[type][j]][map[nr][nc]]&&!visited[nr][nc]) {
							count++;
							visited[nr][nc]=true;
							q.offer(new int[] {nr, nc});
						}
					}
				}
			}
			
			
			sb.append("#").append(test).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}

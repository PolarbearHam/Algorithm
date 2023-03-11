import java.util.*;
import java.io.*;

public class Solution_2382_미생물격리 {
	static int N, M, K, time, answer;
	static int[][] map;
	static int[] S, D;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<bacteria> q = new LinkedList<>();

		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int dr=0, dc=0, cnt=0, dir=0;
			answer = 0;
			q.clear();
			int[][] maxMap = new int[N][N];
			int[][] dirMap = new int[N][N];
			int[][] sumMap = new int[N][N];
			bacteria bac;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				dr = Integer.parseInt(st.nextToken());
				dc = Integer.parseInt(st.nextToken());
				cnt = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				q.offer(new bacteria(dr, dc, cnt, dir));
			}
			for(int time=0; time<M; time++) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					bac = q.poll();
					dr = bac.r;
					dc = bac.c;
					cnt = bac.count;
					dir = bac.dir;
					if(dir==1) {
						dr--;
					}else if(dir==2) {
						dr++;
					}else if(dir==3) {
						dc--;
					}else if(dir==4) {
						dc++;
					}
					if(dr==0||dc==0||dr==N-1||dc==N-1) {
						if(dir==1||dir==3) {
							dir++;
						}else {
							dir--;
						}
						cnt /=2;
					}
					if(maxMap[dr][dc] !=0) {
						if(maxMap[dr][dc]<cnt) {
							maxMap[dr][dc] = cnt;
							dirMap[dr][dc] = dir;
						}
						sumMap[dr][dc] += cnt;
					}else {
						maxMap[dr][dc] = cnt;
						dirMap[dr][dc] = dir;
						sumMap[dr][dc] = cnt;
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(maxMap[i][j]>0) {
							q.offer(new bacteria(i, j, sumMap[i][j], dirMap[i][j]));
							if(time!=M-1) {
								sumMap[i][j]=0;
								dirMap[i][j]=0;
								maxMap[i][j]=0;
							}
						}
					}
				}
			}
			while(q.size()>0) {
				bac = q.poll();
				answer += bac.count;
			}
			
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static class bacteria{
		int r;
		int c;
		int count;
		int dir;
		
		public bacteria(int r, int c, int count, int dir) {
			this.r = r;
			this.c = c;
			this.count = count;
			this.dir = dir;
		}
	}
}
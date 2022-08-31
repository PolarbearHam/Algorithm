package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16929_배열돌리기1_S1_함형준_496ms {
	public static StringBuilder sb = new StringBuilder();
	public static int N;
	public static int M;
	public static int R;
	public static int[][] map;
	public static int[][] result;
	public static int r;
	public static int c;
	public static int turn;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		result = new int[N][M];
		int nN = N;
		int nM = M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		r=0; c=-1; turn=1; int nr=0; int nc=-1; int nturn=1;
		int count = Math.min(N/2, M/2);
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < M; j++) {
				c+=turn;
				queue.add(map[r][c]);
			}
			N--;
			for (int j = 0; j < N; j++) {
				r+=turn;
				queue.add(map[r][c]);
			}
			M--;
			turn*=-1;
			for (int j = 0; j < M; j++) {
				c+=turn;
				queue.add(map[r][c]);
			}
			N--;
			for (int j = 0; j < N; j++) {
				r+=turn;
				queue.add(map[r][c]);
			}
			M--;
			turn*=-1;
			
			for (int j = 0; j < R; j++) {
				queue.add(queue.poll());
			}
			
			for (int j = 0; j < nM; j++) {
				nc+=nturn;
				result[nr][nc] = queue.poll();
			}
			nN--;
			for (int j = 0; j < nN; j++) {
				nr+=nturn;
				result[nr][nc] = queue.poll();
			}
			nM--;
			nturn*=-1;
			for (int j = 0; j < nM; j++) {
				nc+=nturn;
				result[nr][nc] = queue.poll();
			}
			nN--;
			for (int j = 0; j < nN; j++) {
				nr+=nturn;
				result[nr][nc] = queue.poll();
			}
			nM--;
			nturn*=-1;
			
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

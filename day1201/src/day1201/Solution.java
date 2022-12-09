package day1201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] dr= {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map, mini;
	static boolean[][] visited;
	static PriorityQueue<Node> q;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			mini = new int[N][N];
			visited = new boolean[N][N];
			q = new PriorityQueue<>((n1, n2)->n1.cost-n2.cost);
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					mini[i][j] = Integer.MAX_VALUE;
				}
			}
			
			solve();
			sb.append("#").append(test).append(" ").append(mini[N-1][N-1]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void solve() {
		mini[0][0] = 0;
		q.add(new Node(0,0,0));
		
		while(q.size()>0) {
			Node n = q.poll();
			visited[n.r][n.c]=true;
			for (int i = 0; i < 4; i++) {
				int nr = n.r+dr[i];
				int nc = n.c+dc[i];
				int ncost=0;
				if(nr<0||nc<0||nr>=N||nc>=N||visited[nr][nc])continue;
				if(map[nr][nc]==map[n.r][n.c]) {
					ncost=1;
				}else if(map[nr][nc]<map[n.r][n.c]) {
					ncost=0;
				}else {
					ncost=(map[nr][nc]-map[n.r][n.c])*2;
				}
				if(ncost+n.cost<mini[nr][nc]) {
					mini[nr][nc] = n.cost+ncost;
					q.offer(new Node(nr, nc, ncost+n.cost));
				}
			}
		}
		
	}

	static class Node{
		int r, c, cost;

		public Node(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
	}
}

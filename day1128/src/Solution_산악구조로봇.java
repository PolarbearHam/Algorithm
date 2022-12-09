import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_산악구조로봇 {
	static int T, N, min;
	static int[][] map;
	static int[][] mini;
	static boolean[][] visit;
	static int[] dr= {-1, 1, 0, 0};
	static int[] dc= {0, 0, -1, 1};
	static PriorityQueue<Node> q;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			mini = new int[N][N];
			visit = new boolean[N][N];
			q = new PriorityQueue<>((n1, n2)-> n1.cost-n2.cost);
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					mini[i][j] = Integer.MAX_VALUE;
				}
			}
			
			//다익스트라
			solve();
			
			sb.append("#").append(test).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void solve() {
		// 최초 시작점 pq에 담고 시작
		mini[0][0] = 0;
		q.offer(new Node(0,0,0));
		
		while(q.size()>0) {
			//현재 큐에 최소비용 노드 꺼내기->4방탐색 진행
			//범위체크+visit체크 통과후
			//다익스트라 비용 계산
			//꺼낸 노드로부터 사방탐색 비용 계산
			//현재 노드에서 4방탐색 방향의 비용 계산
			Node n = q.poll();
			visit[n.r][n.c]=true;
			for (int i = 0; i < 4; i++) {
				int nr = n.r+dr[i];
				int nc = n.c+dc[i];
				if(nr<0||nc<0||nr>=N||nc>=N||visit[nr][nc]) continue;
				
				int ncost=0;
				if(map[nr][nc]==map[n.r][n.c]) {
					ncost=1;
				}else if(map[nr][nc]<map[n.r][n.c]) {
					ncost=0;
				}else {
					ncost=(map[nr][nc]-map[n.r][n.c])*2;
				}
				if(n.cost+ncost<mini[nr][nc]) {
					mini[nr][nc] = n.cost+ncost;
					q.offer(new Node(nr, nc, mini[nr][nc]));
					
				}
			}
		}
		
	}

	static class Node{
		int r, c, cost;
		
		Node(int r, int c, int cost){
			this.r=r;
			this.c=c;
			this.cost=cost;
		}
	}
}

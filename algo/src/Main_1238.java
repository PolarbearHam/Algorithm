import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238 {
	static int N, M, X;
	static int[] arr;
	static int[][] map;
	static List<ArrayList<Node>> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			list.get(n).add(new Node(m, t));
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if(i==X) continue;
			int goResult = dijkstra(i, X);
			int backResult = dijkstra(X, i);
			
			max = Math.max(max, goResult+backResult);
		}
		System.out.println(max);
		
	}
	
	public static int dijkstra(int s, int e) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		q.offer(new Node(s, e));
		while(q.size()>0) {
			Node now = q.poll();
			int num = now.end;
			
			if(!visited[num]) {
				visited[num] = true;
				
				for (Node n : list.get(num)) {
					if(!visited[n.end] && dist[n.end] > (dist[num]+n.distance)) {
						dist[n.end] = dist[num]+n.distance;
						q.offer(new Node(n.end, dist[n.end]));
					}
				}
			}
		}
		return dist[e];
	}
	
	public static class Node implements Comparable<Node>{
		int end;
		int distance;
		
		public Node(int end, int distance) {
			this.end = end;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.distance-o.distance;
		}
	}
}

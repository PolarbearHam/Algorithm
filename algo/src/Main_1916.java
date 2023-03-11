import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main_1916 {
	static int N, M;
	static List<ArrayList<Node>> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			String[] srr = br.readLine().split(" ");
			int s = Integer.parseInt(srr[0]);
			int e = Integer.parseInt(srr[1]);
			int c = Integer.parseInt(srr[2]);
			
			list.get(s).add(new Node(e, c));
		}
		String[] srr = br.readLine().split(" ");
		
		System.out.println(dijkstra(Integer.parseInt(srr[0]), Integer.parseInt(srr[1])));
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
				for(Node n : list.get(num)) {
					if(!visited[n.end] && dist[n.end]>(dist[num]+n.cost)) {
						dist[n.end] = dist[num]+n.cost;
						q.offer(new Node(n.end, dist[n.end]));
					}
				}
			}
		}
		
		return dist[e];
	}
	
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
}

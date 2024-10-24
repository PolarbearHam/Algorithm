import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {
	static int V, E;
	static int INF = Integer.MAX_VALUE;
	static int[] dist;
	static List<Node>[] list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[V+1];
		list = new ArrayList[V+1];
		int start = Integer.parseInt(br.readLine());
		
		Arrays.fill(dist, INF);
		
		
		for(int i=1; i<V+1; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e, c));
		}
		
		StringBuilder sb = new StringBuilder();
		
		dijkstra(start);
		
		for(int i=1; i<V+1; i++) {
			if(dist[i]==INF) sb.append("INF\n");
			else sb.append(dist[i]+"\n");
		}
		System.out.println(sb);
		br.close();

	}
	
	public static class Node implements Comparable<Node>{
		int end;
		int cost;
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		queue.add(new Node(start, 0));
		dist[start] = 0;
		
		while(queue.size()>0) {
			Node cur = queue.poll();
			int now = cur.end;
			
			if(visited[now]==true) continue;
			visited[now] = true;
			
			for(Node n : list[now]) {
				if(dist[n.end]>dist[now]+n.cost) {
					dist[n.end] = dist[now]+n.cost;
					queue.add(new Node(n.end, dist[n.end]));
				}
			}
		}
	}
}

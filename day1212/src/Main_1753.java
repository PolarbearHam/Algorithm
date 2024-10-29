import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {
	static int V, E;
	static int[] dist;
	static ArrayList<Node>[] list;
	static int INF = 987654321;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		dist = new int[V+1];
		list = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			dist[i] = INF;
			list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e, c));
		}
		dijkstra(start);
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<V+1; i++) {
			if(dist[i]==INF) sb.append("INF\n");
			else sb.append(dist[i]+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> q= new PriorityQueue<>();
		dist[start] = 0;
		boolean[] visited = new boolean[V+1];
		q.add(new Node(start, 0));
		
		while(q.size()>0) {
			Node n = q.poll();
			int now = n.e;
			if(visited[now]) continue;
			visited[now] = true;
			
			for(Node node : list[now]) {
				if(dist[node.e]>dist[now]+n.c) {
					dist[node.e]= dist[now]+n.c;
					q.add(new Node(node.e, dist[node.e]));
				}
			}
		}
		
	}
	
	public static class Node implements Comparable<Node>{
		int e;
		int c;
		public Node(int e, int c) {
			this.e = e;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			return c-o.c;
		}
	}
}

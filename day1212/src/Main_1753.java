import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {
	static int V, E, K;
	static final int INF = 987654321;
	static List<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V+1];
		dist = new int[V+1];
		
		Arrays.fill(dist, INF);
		
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Node(v, w));
		}
		
		StringBuilder sb = new StringBuilder();
		dijkstra(K);
		
		for(int i=1; i<=V; i++) {
			if(dist[i]==INF) sb.append("INF\n");
			else sb.append(dist[i]+"\n");
		}
		System.out.println(sb.toString());
		
		
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		queue.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int now = cur.v;
			
			if(check[now]) continue;
			check[now] = true;
			
			for(Node n : list[now]) {
				if(dist[n.v] > dist[now]+n.w) {
					dist[n.v]= dist[now]+n.w;
					queue.add(new Node(n.v, dist[n.v]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int v;
		int w;
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node O) {
			return w - O.w;
		}
	}
}

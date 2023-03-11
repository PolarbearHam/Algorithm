import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504 {
	static int N, E, possible = Integer.MAX_VALUE, v1, v2;
	static List<ArrayList<Node>> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine(), " ");
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		int answer = Math.min(dijkstra(1, v1)+dijkstra(v1,v2)+dijkstra(v2, N), dijkstra(1,v2)+dijkstra(v2,v1)+dijkstra(v1,N));
		if(possible==-1) System.out.println(possible);
		else System.out.println(answer);
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
					if(!visited[n.end] && dist[n.end] > (dist[num]+n.distance)) {
						dist[n.end]= dist[num]+n.distance;
						q.offer(new Node(n.end, dist[n.end]));
					}
				}
			}
		}
		if(dist[e]==Integer.MAX_VALUE) possible = -1;
		return dist[e];
	}
	
	static class Node implements Comparable<Node>{
		int end;
		int distance;
		
		public Node(int end, int distance) {
			this.end = end;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node o){
			return this.distance-o.distance;
		}
	}
}

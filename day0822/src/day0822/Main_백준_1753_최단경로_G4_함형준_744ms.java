package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1753_최단경로_G4_함형준_744ms {
	static int V, E, K;
	static List<Node>[] list;
	static boolean[] visited;
	static int[] distance;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		distance = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			distance[i] = Integer.MAX_VALUE;
			list[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
		}
		find(K);
		for (int i = 1; i <= V; i++) {
			if(distance[i]==Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
				continue;
			}
			sb.append(distance[i]).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void find(int s) {
		distance[s]=0;
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(s, 0));
		while(!q.isEmpty()) {
			Node p = q.poll();
			visited[p.end] = true;
			for (Node n : list[p.end]) {
				if(!visited[n.end]) {
					if(distance[p.end]+n.weight < distance[n.end]) {
						distance[n.end] = distance[p.end]+n.weight;
						q.add(new Node(n.end, distance[n.end]));
					}
				}
			}
		}
	}
	
}

class Node implements Comparable<Node>{
	int end, weight;

	public Node(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}
	
}
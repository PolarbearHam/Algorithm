package day0822;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class GraphTest {
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	static int V;
	static Node[] adjList;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new Node[V];
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		System.out.println("Dfs");
		visited = new boolean[V];
		dfs(0);
		System.out.println("Bfs");
		bfs();
		
	}
	
	static void dfs(int cur) {
		
		visited[cur] = true;
		System.out.println(cur);
		for (Node temp = adjList[cur]; temp!=null; temp=temp.next) {
			if(!visited[temp.vertex]) {
				dfs(temp.vertex);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[V];
		
		q.offer(0);
		visited[0]=true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.println(cur);
			
			for (Node temp = adjList[cur]; temp !=null; temp= temp.next){
				if(!visited[temp.vertex]) {
					q.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
}

package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySortTest {
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	static Node[] adjList;
	static int[] inDegree;
	static int V;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		adjList = new Node[V];
		inDegree = new int[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}
		ArrayList<Integer> list = topologySort();
		if(list.size()==V) {//위상정렬 완성
			for (Integer i : list) {
				System.out.println(i+" ");
			}
			System.out.println();
		}else {
			System.out.println("cycle..");
		}
	}
	
	public static ArrayList<Integer> topologySort(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		for (int i = 0; i < V; i++) {
			if(inDegree[i]==0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			list.add(cur);
			for (Node temp = adjList[cur]; temp != null; temp=temp.next) {
				if(--inDegree[temp.vertex]==0) q.offer(temp.vertex);
			}
		}
		return list;
	}
	
	
}

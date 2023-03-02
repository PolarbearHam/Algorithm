import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1967 {
	static boolean[] visited;
	static int max=Integer.MIN_VALUE;
	static int N;
	static int max_idx;
	static ArrayList<Node> list[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			String[] t = br.readLine().split(" ");
			int parent = Integer.parseInt(t[0]);
			int child = Integer.parseInt(t[1]);
			int weight = Integer.parseInt(t[2]);
			list[parent].add(new Node(child, weight));
			list[child].add(new Node(parent, weight));
		}
		
		visited[1] = true;
		dfs(1,0);
		visited = new boolean[N+1];
		visited[max_idx] = true;
		dfs(max_idx, 0);
		System.out.println(max);
	}
	
	
	private static void dfs(int idx, int cnt) {
		if(max<cnt) {
			max = cnt;
			max_idx = idx;
		}
		for(Node n : list[idx]) {
			if(!visited[n.idx]) {
				visited[n.idx] = true;
				dfs(n.idx, cnt+n.weight);
			}
		}
		
	}


	public static class Node{
		int idx;
		int weight;
		
		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}
}

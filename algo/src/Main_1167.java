import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1167 {
	static ArrayList<Node>[] list;
	static int max=Integer.MIN_VALUE;
	static boolean[] visited;
	static int max_idx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			String[] srr = br.readLine().split(" ");
			int idx = Integer.parseInt(srr[0]);
			int j = 1;
			while(true) {
				int v_num = Integer.parseInt(srr[j]);
				if(v_num == -1) break;
				int weight = Integer.parseInt(srr[j+1]);
				list[idx].add(new Node(v_num, weight));
				j+=2;
			}
		}
		
		dfs(1, 0);
		visited = new boolean[N+1];
		dfs(max_idx, 0);
		
		System.out.println(max);
		
	}
	
	private static void dfs(int idx, int cnt) {
		if(max<cnt) {
			max = cnt;
			max_idx = idx;
		}
		visited[idx]=true;
		for (Node n : list[idx]) {
			if(!visited[n.idx]) {
				dfs(n.idx, cnt+n.weight);
				visited[n.idx]= true;
			}
		}
		
	}

	public static class Node{
		int idx;
		int weight;
		
		public Node (int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}
}

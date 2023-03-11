import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725 {
	static int N;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		int[] parents = new int[N+1];
		
		dfs(list, parents, N, 1, 0);
		
		for(int j=2; j<=N; j++) System.out.println(parents[j]);
	}


	private static void dfs(ArrayList<Integer>[] list, int[] parents, int n, int start, int parent) {
		parents[start] = parent;
		for (int i : list[start]) {
			if(i != parent) dfs(list, parents, n, i, start);
		}
		
	}
}

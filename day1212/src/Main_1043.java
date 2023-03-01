import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1043 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] know = new boolean[N+1];
		
		HashSet<Integer>[] party = new HashSet[M+1];
		for (int i = 1; i <= M; i++) {
			party[i] = new HashSet<>();
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= num; i++) {
			know[Integer.parseInt(st.nextToken())] = true;
		}
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i <= M; i++) {
			String[] srr = br.readLine().split(" ");
			int partyNum = Integer.parseInt(srr[0]);
			
			if(partyNum<=1) {
				party[i].add(Integer.parseInt(srr[1]));
				continue;
			}
			for (int j = 1; j < partyNum; j++) {
				int a = Integer.parseInt(srr[j]);
				int b = Integer.parseInt(srr[j+1]);
				if(find(a)!=find(b)) {
					union(a,b);
				}
				party[i].add(a);
				party[i].add(b);
				
			}
			
		}
		boolean[] visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if(know[i]&&!visited[i]) {
				int root = find(i);
				for (int j = 1; j <= N; j++) {
					if(find(j)==root) {
						know[j] = true;
						visited[j] = true;
					}
				}
			}
		}
		
		int result = 0;
		for (int i = 1; i <= M; i++) {
			boolean flag = false;
			for (int person : party[i]) {
				if(know[person]) {
					flag = true;
					break;
				}
			}
			if(!flag) result++;
		}
		System.out.println(result);
	}

	public static int find(int idx) {
		if(parent[idx]==idx) {
			return idx;
		}
		parent[idx] = find(parent[idx]);
		return parent[idx];
	}
	
	public static void union(int a, int b) {
		int parent_b = find(b);
		parent[parent_b] = a;
	}
}

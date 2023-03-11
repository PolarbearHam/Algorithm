import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15591 {
	static int N, Q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		List<int[]>[] pqr = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			pqr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			pqr[p].add(new int[] {q, r});
			pqr[q].add(new int[] {p, r});
			
		}
		
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			boolean[] visit = new boolean[N+1];
			visit[v] = true;
			Queue<Integer> q = new LinkedList<>();
			q.add(v);
			int count = 0;
			while(q.size()>0) {
				int cur = q.poll();
				for (int[] a : pqr[cur]) {
					if(!visit[a[0]] && a[1]>=k) {
						q.add(a[0]);
						visit[a[0]] = true;
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18352 {
	static int N, M, K;
	static final int INF = -1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new List[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			
		}
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		Queue<Integer> q = new ArrayDeque<>();
		q.add(x);
		dist[x] = 0;
		
		List<Integer> answer = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(dist[cur]>K) break;
			if(dist[cur]==K) answer.add(cur);
			
			for(int n : list[cur]) {
				if(dist[n] != INF) continue;
				dist[n] = dist[cur]+1;
				q.add(n);
			}
		}
		Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
		for(int cur : answer) {
			sb.append(cur).append("\n");
		}
		
		System.out.println(answer.isEmpty()? -1 : sb);

	}

}

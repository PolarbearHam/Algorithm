import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13549 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] visited = new int[100001];
		
		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(N, 1));
		visited[N] = 1;
		
		while(q.size()>0) {
			Pos now = q.poll();
			
			if(now.idx>=0 && now.idx+1<=100000) {
				if(visited[now.idx+1]==0||visited[now.idx+1]>now.time+1) {
					visited[now.idx+1] = now.time+1;
					q.add(new Pos(now.idx+1, now.time+1));
				}
			}
			
			if(now.idx-1>=0&&now.idx-1<=100000) {
				if(visited[now.idx-1]==0||visited[now.idx-1]>now.time+1) {
					visited[now.idx-1] = now.time+1;
					q.add(new Pos(now.idx-1, now.time+1));
				}
			}
			
			if(now.idx*2>=0&&now.idx*2<=100000) {
				if(visited[now.idx*2]==0||visited[now.idx*2]>now.time) {
					visited[now.idx*2] = now.time;
					q.add(new Pos(now.idx*2, now.time));
				}
			}
		}
		System.out.println(visited[K]-1);
		
	}
	
	static class Pos{
		int idx;
		int time;
		
		public Pos(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
	}
}

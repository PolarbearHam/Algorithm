import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_12851 {
	static int N, K, minTime=987654321, count=0;
	static int[] arr = new int[100001];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String[] srr = br.readLine().split(" ");
		
		N = Integer.parseInt(srr[0]);
		K = Integer.parseInt(srr[1]);
		
		if(N>=K) {
			System.out.println(N-K+"\n1");
			return;
		}
		bfs();
		System.out.println(minTime+"\n"+count);
		
	}
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(N);
		arr[N]=1;
		
		while(q.size()>0) {
			int now = q.poll();
			if(minTime<arr[now]) return;
			for (int i = 0; i < 3; i++) {
				int next;
				if(i==0) next = now+1;
				else if(i==1) next = now-1;
				else next = now*2;
				
				if(next<0||next>100000) continue;
				if(next==K) {
					minTime=arr[now];
					count++;
				}
				if(arr[next]==0||arr[next]==arr[now]+1) {
					q.offer(next);
					arr[next] = arr[now]+1;
				}
			}
		}
	}
}

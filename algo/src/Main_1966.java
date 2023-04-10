import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			Queue<Integer> q = new ArrayDeque<>();
			int max = 0;
			int[] important = new int[N];
			for(int i=0; i<N; i++) {
				int a = Integer.parseInt(st.nextToken());
				important[i] = a;
				q.add(a);
			}
			Arrays.sort(important);
			int impIdx = 0;
			int idx = M;
			while(true) {
				if(q.peek()==important[impIdx]) {
					q.poll();
				}
			}
		}
	}
}

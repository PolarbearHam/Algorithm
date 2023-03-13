import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10871 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < N; i++) {
			int a = q.poll();
			if(a<X) {
				sb.append(a+" ");
			}
		}
		System.out.println(sb.toString());
	}
}

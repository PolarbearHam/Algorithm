import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11279 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2)->{
			return o2-o1;
		});
		
		for (int i = 0; i < N; i++) {
			int op = Integer.parseInt(br.readLine());
			if(op==0) {
				if(q.isEmpty()) System.out.println(0);
				else System.out.println(q.poll());
			}
			else {
				q.add(op);
			}
		}
	}
}

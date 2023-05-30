import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11651 {
	static PriorityQueue<node> q = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.add(new node(x, y));
		}
		StringBuilder sb = new StringBuilder();
		while(q.size()>0) {
			node n = q.poll();
			sb.append(n.x).append(" ").append(n.y).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	public static class node implements Comparable<node>{
		int x;
		int y;
		public node(int x, int y) {
			this.x = x;
			this.y=y;
		}
		@Override
		public int compareTo(node o) {
			if(y!=o.y) return y-o.y;
			else return x-o.x;
		}
	}
}

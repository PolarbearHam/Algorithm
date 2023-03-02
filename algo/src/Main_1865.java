import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1865 {
	static int n, m, w;
	static int dis[];
	static ArrayList<Node>[] road;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			dis = new int[n+1];
			Arrays.fill(dis, 987645321);
			road = new ArrayList[n+1];
			
			for (int j = 0; j < n+1; j++) {
				road[j] = new ArrayList<>();
			}
			
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				road[a].add(new Node(b, c));
				road[b].add(new Node(a, c));
			}
			
			for (int j = 0; j < w; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				road[a].add(new Node(b, -c));
			}
			if(bellmanFord()) System.out.println("YES");
			else System.out.println("NO");
		}

	}
	public static boolean bellmanFord() {
		dis[1] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < road.length; j++) {
				for(Node next:road[j]) {
					if(dis[j]+next.time<dis[next.end]) {
						dis[next.end] = dis[j] + next.time;
					}
				}
			}
		}
		for (int i = 1; i < road.length; i++) {
			for(Node next: road[i]) {
				if(dis[i]+next.time<dis[next.end]) {
					return true;
				}
			}
		}
		return false;
	}
	public static class Node{
		int end;
		int time;
		public Node(int end, int time) {
			this.end = end;
			this.time = time;
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1446 {
	static int N, D;
	static List<List<Node>> list = new ArrayList<>();
	static int[] dist;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=10001; i++) {
			list.add(new ArrayList<>());
		}
		dist = new int[10001];
		for(int i=0; i<dist.length; i++) {
			dist[i] = i;
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			list.get(s).add(new Node(e, dis));
		}
		
		dijkstra(0);
		
		System.out.println(dist[D]);
	}
	
	static void dijkstra(int s) {
		if(s>D) return;
		
		if(dist[s+1] > dist[s]+1) dist[s+1] = dist[s]+1;
		
		for(int i=0; i<list.get(s).size(); i++) {
			if(dist[s]+list.get(s).get(i).dis < dist[list.get(s).get(i).e]) {
				dist[list.get(s).get(i).e] = dist[s]+list.get(s).get(i).dis;
			}
		}
		dijkstra(s+1);
		
	}
	
	static class Node{
		int e;
		int dis;
		
		public Node(int e, int dis) {
			this.e = e;
			this.dis = dis;
		}
	}
}

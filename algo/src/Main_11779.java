import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_11779 {
	static int n, m, count;
	static List<ArrayList<Node>> list = new ArrayList<>();
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, c));
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int answer = dijkstra(s, e);

		Stack<Integer> stk = new Stack<>();
		stk.push(e);
		while (arr[e] != 0) {
			count++;
			stk.push(arr[e]);
			e = arr[e];
		}
		System.out.println(answer);
		System.out.println(count + 1);
		while(stk.size()>0) {
			System.out.print(stk.pop()+" ");
		}

	}

	static int dijkstra(int s, int e) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		q.offer(new Node(s, e));
		while (q.size() > 0) {
			Node now = q.poll();
			int num = now.end;
			if(!visited[num]) {
				visited[num] = true;
				for (Node n : list.get(num)) {
					if (dist[n.end] > (dist[num] + n.cost)) {
						dist[n.end] = dist[num] + n.cost;
						q.add(new Node(n.end, dist[n.end]));
						arr[n.end] = num;
					}
				}
			}
		}
		return dist[e];
	}

	static class Node implements Comparable<Node> {
		int end;
		int cost;

		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}

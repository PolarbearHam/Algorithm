package review;

import java.io.*;
import java.util.*;

public class Kruskal {
	static int N;
	static int[][] edges;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			edges[i] = new int[] { from, to, weight };
		}
		Arrays.sort(edges, (o1,o2)->Integer.compare(o1[2], o2[2]));
		makeSet();
		int result = 0, cnt = 0;
		for (int[] edge : edges) {
			if(union(edge[0], edge[1])) {
				result += edge[2];
				if(cnt++==N-1) break;
			}
		}
		System.out.println(result);
		sc.close();

	}

	static void makeSet() {
		parent = new int[N];
		for (int i = 0; i < N; i++)
			parent[i] = i;
	}

	static int findSet(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = findSet(parent[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		parent[bRoot] = aRoot;
		return true;
	}
}

package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
	static int V;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//start->end way
		int start = 0;//start vertex
		int end = V-1;//end vertex
		int[] D = new int[V];
		boolean[] visited = new boolean[V];
		
		Arrays.fill(D, Integer.MAX_VALUE);
		//start vertex process
		D[start] = 0;
		int min, minVertex;
		for (int i = 0; i < V; i++) {
			// step1 minimum expensive
			min = Integer.MAX_VALUE;
			minVertex = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > D[j]) {
					min = D[j];
					minVertex = j;
				}
			}

			// step2 visit
			visited[minVertex] = true;
//			if (minVertex == end)	break; //문제가 Start -> end로의 최단이면 탈출

			// step3 minimum select
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjMatrix[minVertex][j] > 0 && D[j] > D[minVertex] + adjMatrix[minVertex][j]) {
					D[j] = D[minVertex] + adjMatrix[minVertex][j];
				}
			}
		}
		System.out.println(Arrays.toString(D));
		System.out.println(D[end]);
	}
}

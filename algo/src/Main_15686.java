import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15686 {
	static int N, M, min;
	static int[][] arr, dis;
	static int[] chiarr; 
	static boolean[] visited;
	static ArrayList<int[]> q = new ArrayList<int[]>();
	static ArrayList<int[]> chiq = new ArrayList<>();
	static ArrayList<int[]> choice = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		min = Integer.MAX_VALUE;
		arr = new int[N][N];
		dis = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(dis[i], Integer.MAX_VALUE);
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					q.add(new int[] {i, j});
				}
				if(arr[i][j]==2) {
					chiq.add(new int[] {i, j});
				}
			}
		}
		visited = new boolean[chiq.size()];
		back(0, 0);
		
		System.out.println(min);
		
	}

	private static void back(int depth, int start) {
		if(depth == M) {
			int sum = 0;
			for (int[] h : q){
				int mini = Integer.MAX_VALUE;
				for (int[] c : choice) {
					int d = Math.abs(h[0]-c[0])+Math.abs(h[1]-c[1]);
					mini = Math.min(mini, d);
				}
				sum += mini;
			}
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = start; i < chiq.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				choice.add(chiq.get(i));
				back(depth+1, i+1);
				choice.remove(choice.size()-1);
				visited[i]=false;
			}
		}
		
	}

	
}

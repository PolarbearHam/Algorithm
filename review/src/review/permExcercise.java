package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class permExcercise {
	public static int N, R, total;
	public static boolean[] visited;
	public static int[] arr;
	public static int[] a ;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		arr = new int[R];
		a = new int[N];
		for (int i = 1; i <= N; i++) {
			a[i-1] = i;
		}
		comb(0,0);
		System.out.println(total);
	}
	
	public static void perm(int start) {
		if(start==R) {
			total++;
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			arr[start] = a[i]; 
			visited[i] = true;
			perm(start+1);
			visited[i] = false;
		}
	}
	
	public static void comb(int depth, int start) {
		if(depth==R) {
			total++;
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = start; i < N; i++) {
			arr[depth] = a[i];
			comb(depth+1, i+1);
		}
	}
	public static void subs(int depth) {
		if(depth==N) {
			total++;
			for (int i = 0; i < N; i++) {
				System.out.print(visited[i]? a[i]:"X");
			}
			System.out.println();
			return;
		}
		visited[depth] = true;
		subs(depth+1);
		visited[depth] = false;
		subs(depth+1);
			
	}
}

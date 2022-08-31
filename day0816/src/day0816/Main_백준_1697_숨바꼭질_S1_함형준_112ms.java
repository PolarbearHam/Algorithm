package day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1697_숨바꼭질_S1_함형준_112ms {
	public static int N, K;
	public static int[] arr = new int[100001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int result = bfs(N);
		System.out.println(result);
	}
	
	public static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);
		int index = start;
		int n = 0;
		arr[index]=1;
		while(!q.isEmpty()) {
			n = q.poll();
			if(n==K) {
				return arr[n]-1;
			}
			if(n-1>=0&&arr[n-1]==0) {
				arr[n-1] = arr[n]+1;
				q.add(n-1);
			}
			if(n+1<=100000 && arr[n+1]==0) {
				arr[n+1] = arr[n]+1;
				q.add(n+1);
			}
			if(2*n<=100000 && arr[2*n]==0) {
				arr[2*n] = arr[n]+1;
				q.add(2*n);
			}
		}
		return -1;
		
	}
}

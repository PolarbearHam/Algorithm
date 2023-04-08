import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
 
public class Main_10866 {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
 
		int N = Integer.parseInt(br.readLine());
 
		for (int i = 0; i < N; i++) {
 
			String[] s = br.readLine().split(" ");
 
			// 첫 번째 단어에 대한 switch-case 
			switch (s[0]) {
 
				case "push_front": {
					dq.addFirst(Integer.parseInt(s[1]));
					break;
				}
				
				case "push_back": {
					dq.addLast(Integer.parseInt(s[1]));
					break;
				}
 
				case "pop_front": {
					if (dq.isEmpty()) {
						sb.append(-1).append('\n');
					} 
					else {
						sb.append(dq.pollFirst()).append('\n');
					}
					break;
				}
 
				case "pop_back": {
					if (dq.isEmpty()) {
						sb.append(-1).append('\n');
					} 
					else {
						sb.append(dq.pollLast()).append('\n');
					}
					break;
				}
 
				case "size": {
					sb.append(dq.size()).append('\n');
					break;
				}
 
				case "empty": {
					if (dq.isEmpty()) {
						sb.append(1).append('\n');
					} 
					else {
						sb.append(0).append('\n');
					}
					break;
				}
 
				case "front": {
					if (dq.isEmpty()) {
						sb.append(-1).append('\n');
					} 
					else {
						sb.append(dq.peekFirst()).append('\n');
					}
					break;
				}
 
				case "back": {
					if (dq.isEmpty()) {
						sb.append(-1).append('\n');
					} 
					else {
						sb.append(dq.peekLast()).append('\n');
					}
					break;
				}
			}
		}
		System.out.println(sb);
	}
	
	class Solution1 {
	    public int solution(int n, int v, int[] A, int[] B, int[] C) {
	        int answer = 0;
	        // int[][][] dp = new int[n][n][n];
	        // int max = -1;
	        // for(int i=0; i<n; i++){
	        //     for(int j=0; j<n; j++){
	        //         for(int k=0; k<n; k++){
	        //             int mul = A[i]*B[j]*C[k];
	        //             if(mul<v&&mul>max) max = mul;
	        //         }
	        //     }
	        // }
	        // return max;
	        
	        int[] dp = new int[2*n];
	        int max = -1;
	        if(A[0]*B[0]*C[0]>v) return -1;
	        int idx=0;

	        for(int i=0; i<n; i++){
	            for(int j=0; j<n; j++){
	                dp[idx++] = A[i]*B[j];
	            }
	        }
	        Arrays.sort(dp);
	        int cIdx=n-1;
	        
	        for(int i=2*n-1; i>=0; i--){
	            for(int j=n-1; j>=0; j--){
	                if(dp[i]*C[j]>v) return dp[i]*C[j];
	            }
	        }
	        return -1;
	    }
	}
	
	
}
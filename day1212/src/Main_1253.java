import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] arr = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		int result = 0;
		for(int i=0; i<N; i++) {
			int left = 0;
			int right = N-1;
			
			while(true) {
				if(left==i) left++;
				else if(right==i)right--;
				
				if(left>=right) break;
				
				if(arr[left]+arr[right]>arr[i]) right--;
				else if(arr[left]+arr[right]<arr[i]) left++;
				else {
					result++;
					break;
				}
				
				
			}
		}
		System.out.println(result);
		
		

	}

}

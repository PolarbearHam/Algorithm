import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N, C;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
				
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[N-1]-arr[0]+1; 
		
		while(left<right) {
			int mid = (left+right)/2;
			
			if(can(mid) < C) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		System.out.println(left-1);

	}
	public static int can(int distance) {
		int count = 1;
		int last = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			int locate = arr[i];
			
			if(locate-last >= distance) {
				count++;
				last = locate;
			}
		}
		return count;
	}

}

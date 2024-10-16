import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2343 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int left = 0;
		int right = 0;
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right += arr[i];
			left = Math.max(left, arr[i]);
		}
		
		while(left<=right) {
			int mid = (left+right)/2;
			int count = getCount(N, arr, mid);
			
			if(count>M) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(left);

	}
	
	public static int getCount(int n, int[] arr, int mid) {
		int sum = 0;
		int count = 0;
		for(int i=0; i<n; i++) {
			if(sum+arr[i]>mid) {
				sum=0;
				count++;
			}
			sum += arr[i];
		}
		
		if(sum!=0) count++;
		return count;
	}

}

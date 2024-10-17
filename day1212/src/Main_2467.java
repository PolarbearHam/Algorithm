import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2467 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
				
		int left = 0;
		int right = N-1;
		int ml = 0, mr = 0;
		long min = Long.MAX_VALUE;
		
		while(left<right) {
			long sum = arr[left]+arr[right];
			if(min>Math.abs(sum)) {
				min = Math.abs(sum);
				ml = left;
				mr = right;
			}
			if(sum>=0) {
				right--;
			}else {
				left++;
			}
		}
		
		System.out.println(arr[ml]+" "+arr[mr]);
		
//		long min = Long.MAX_VALUE;
//		int ml=0, mr=0;
//		
//		for(int i=0; i<N-1; i++) {
//			int left = i+1;
//			int right = N-1;
//			while(left<=right) {
//				int mid = (left+right)/2;
//				long sum = Math.abs(arr[i]+arr[mid]);
//				
//				if(min>sum) {
//					min = sum;
//					ml = i; mr=mid;
//				}
//				if(arr[mid]>=-arr[i]) {
//					right = mid-1;
//				}else {
//					left = mid+1;
//				}
//			}
//		}
//		System.out.println(arr[ml]+" "+arr[mr]);
	}

}

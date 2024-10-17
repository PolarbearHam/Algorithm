import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		long min = Long.MAX_VALUE;
		int ml = 0;
		int mr = 0;
		int left = 0;
		int right = N-1;
		
		while(left<right) {
			long sum = arr[left]+arr[right];
			if(min>Math.abs(sum)) {
				min = Math.abs(sum);
				ml = left; mr = right;
			}
			if(sum>=0) {
				right--;
			}else {
				left++;
			}
		}
		System.out.println(arr[ml]+" "+arr[mr]);

	}

}

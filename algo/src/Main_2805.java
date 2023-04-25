import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int min = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		
		while(min<max) {
			int mid = (min+max)/2;
			long sum =0;
			for(int height : arr) {
				if(height-mid>0) {
					sum+=(height-mid);
				}
			}
			if(sum<M) {
				max=mid;
			}else {
				min = mid+1;
			}
		}
		System.out.println(min-1);
	}
}

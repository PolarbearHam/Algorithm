import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0, mid=0, end=0;
		long min = Long.MAX_VALUE;
		int[] best = new int[3];
		for(int i=0; i<N-2; i++) {
			start = i;
			mid = i+1;
			end = N-1;
			while(mid<end) {
				long sum = arr[start]+arr[mid]+arr[end];
				if(min>Math.abs(sum)) {
					min = Math.abs(sum);
					best[0]=start;
					best[1]=mid;
					best[2]=end;
				}
				if(sum==0) {
					break;
				}else if(sum>0) {
					end--;
				}else {
					mid++;
				}
			}
		}
		System.out.println(arr[best[0]]+" "+arr[best[1]]+" "+arr[best[2]]);

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11497 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test=0; test<T; test++) {
			int N= Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int ans[] = new int[N];
			int left = 0;
			int right = N-1;
			
			for(int i=0; i<N; i++) {
				if(i%2==0) {
					ans[left] = arr[i];
					left++;
				}else {
					ans[right] = arr[i];
					right--;
				}
			}
			int min = Integer.MAX_VALUE;
			min = Math.abs(ans[0]-ans[N-1]);
			for(int i=1; i<N; i++) {
				min = Math.max(min, Math.abs(ans[i]-ans[i-1]));
			}
			System.out.println(min);
			
			
		}

	}

}

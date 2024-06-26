import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1205 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		long score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		if(N==0 && P>0) {
			System.out.println(1);
			return;
		}
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		
		if(N==P && score<=arr[arr.length-1]) {
			System.out.println(-1);
		}else {
			int rank = 1;
			for(int i=0; i<arr.length; i++) {
				if(score < arr[i]) {
					rank++;
				}else
					break;
			}
			System.out.println(rank);
		}
	}
}

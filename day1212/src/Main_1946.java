import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1946 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test=0; test<T; test++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			int count = 1;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int fir = Integer.parseInt(st.nextToken());
				int sec = Integer.parseInt(st.nextToken());
				arr[fir] = sec;
			}
			
			int vot = arr[1];
			for(int j=2; j<=N; j++) {
				if(arr[j]<vot) {
					vot = arr[j];
					count++;
				}
			}
			System.out.println(count);
		}

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15666 {
	static int[] arr, result;
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		combination(0, 0, sb);
		System.out.println(sb.toString());
	}
	
	public static void combination(int start, int cnt, StringBuilder sb) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
		}else {
			int num=0;
			for(int i=start; i<N; i++) {
				if(num==arr[i]) continue;
				
				result[cnt] = arr[i];
				combination(i, cnt+1, sb);
				num = arr[i];
			}
		}
		
	}
}

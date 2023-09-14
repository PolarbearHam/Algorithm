import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17266 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int result = 0;
		int[] position = new int[M];
		
		for(int i=0; i<M; i++) {
			position[i] = Integer.parseInt(st.nextToken());
		}
		
		int low = 1;
		int high = N;
		while(low<=high) {
			int mid = (low+high)/2;
			boolean flag = true;
			
			int point = 0;
			for(int i=0; i<position.length; i++) {
				if(position[i]-mid <= point) {
					point = position[i] + mid;
				}else {
					flag = false;
				}
			}
			if(N-point>0) flag = false;
			else flag = true;
			
			if(flag) {
				result = mid;
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		System.out.println(result);
	}
}

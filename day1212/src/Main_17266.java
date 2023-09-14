import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17266 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] position = new int[M+2];
		for(int i=0; i<M; i++) {
			position[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxDis = position[0];
		
		for(int i=1; i<M; i++) {
			if(((position[i]-position[i-1])&1)==0) {
				maxDis = Math.max(maxDis, (position[i] - position[i-1])/2);
			}else {
				maxDis = Math.max(maxDis, (position[i] - position[i-1]/2 + 1));
			}
		}
		maxDis = Math.max(maxDis, N-position[M-1]);
		
		System.out.println(maxDis);
		
	}
}

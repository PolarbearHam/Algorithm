import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10830 {
	static int N;
	static int[][] origin;
	static final int MOD = 1000;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		origin = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken())%MOD;
			}
		}
		
		int[][] result = pow(origin, B);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int[][] pow(int[][] origin, long B){
		if(B==1L) return origin;
		
		int[][] ret = pow(origin, B/2);
		ret = multiply(ret, ret);
		if(B%2==1L) {
			ret = multiply(ret, origin);
		}
		return ret;
	}
	
	public static int[][] multiply(int[][] o1, int[][] o2){
		int[][] ret = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		return ret;
	}
}

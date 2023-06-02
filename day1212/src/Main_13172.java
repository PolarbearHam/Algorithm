import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13172 {
	static final int MOD = 1000000007;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		long N = 1, S = 0;
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			S = s*N + S*n;
			N *= n;
			S %= MOD;
			N %= MOD;
		}
		
		if(S%N !=0) {
			System.out.println((reverse(N, MOD-2)*S)%MOD+"");
		}else {
			System.out.println(S/N+ "");
		}
		
	}
	public static long reverse(long N, int index) {
		if(index ==1) return N;
		long temp = reverse(N, index/2);
		if(index%2==1) return temp*temp%MOD*N%MOD;
		else return temp*temp%MOD;
	}
}

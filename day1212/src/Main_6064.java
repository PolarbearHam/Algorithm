import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6064 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int lcm = M*N/gcd(M,N);
			int n = 0;
			int ans = -1;
			
			while(n*M<lcm) {
				if((n*M + x-y)%N==0) {
					ans = n*M+x;
					break;
				}
				n++;
			}
			System.out.println(ans);
		}
	}
	
	public static int gcd(int n1, int n2) {
		if(n2==0) return n1;
		return gcd(n2, n1%n2);
	}
}

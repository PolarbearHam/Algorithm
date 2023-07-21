import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1052 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int rst = buy(N, K);
		System.out.println(rst);
	}
	public static int buy(int n, int k) {
		if(n <= k) return 0;
		
		for(int i=0; i<k-1; i++) {
			int base = 0;
			while(Math.pow(2, base)<n) {
				base++;
			}
			n -= Math.pow(2, base-1);
			
			if(n==0) return 0;
		}
		int base = 0;
		while(Math.pow(2, base)<n) {
			base++;
		}
		return (int) Math.pow(2, base) - n;
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2407 {
	static int n, r;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		
		for (int i = 0; i < r; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(n-i)));
			n2 = n2.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		BigInteger answer = n1.divide(n2);
		System.out.println(answer);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a=0, b=0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int d = gcd(a,b);
		
		System.out.println(d);
		System.out.println(a*b/d);
	}
	static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
}

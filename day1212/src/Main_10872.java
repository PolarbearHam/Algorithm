import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10872 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		System.out.println(recursive(N, 1));
		
	}
	public static int recursive(int n, int mul) {
		if(n<=1) {
			
			return mul;
		}
		return recursive(n-1, mul*n);
	}
}

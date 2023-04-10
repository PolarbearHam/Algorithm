import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11050 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 1;
		int n = 0;
		int r = 0;
		
		for (int i = N; i > N-K; i--) {
			answer *= i;
		}
		for (int i = K; i > 0; i--) {
			answer /= i;
		}
		System.out.println(answer);
	}
}

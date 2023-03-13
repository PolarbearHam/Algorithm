import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1676 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count =0;

		while(N>=5) {
			count += N/5;
			N = N/5;
		}
		System.out.println(count);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10870 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] fibo = new int[21];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2; i<21; i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		System.out.println(fibo[N]);
	}

}

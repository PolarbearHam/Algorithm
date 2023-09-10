import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_25314 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		N = N/4;
		
		if(N==1) {
			System.out.println("long int");
		}else {
			for(int i=0; i<N; i++) {
				System.out.print("long ");
			}
			System.out.println("int");
		}
	}
}

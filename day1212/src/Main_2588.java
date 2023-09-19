import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2588 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int B = Integer.parseInt(s);
		int b1 = s.charAt(0)-48;
		int b2 = s.charAt(1)-48;
		int b3 = s.charAt(2)-48;
		
		System.out.println(A*b3);
		System.out.println(A*b2);
		System.out.println(A*b1);
		System.out.println(A*B);
		
		
	}
}

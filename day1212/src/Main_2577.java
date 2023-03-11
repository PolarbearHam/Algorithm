import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2577 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int mul=1;
		for (int i = 0; i < 3; i++) {
			int a = Integer.parseInt(br.readLine());
			mul = mul*a;
		}
		int[] arr = new int[10];
		while(mul!=0) {
			int temp = mul;
			mul = mul/10;
			arr[temp%10]++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
	}
}

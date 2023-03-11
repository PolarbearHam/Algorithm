import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3052 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[42];
		for (int i = 0; i < 10; i++) {
			arr[Integer.parseInt(br.readLine())%42]++;
		}
		int count=0;
		for (int i = 0; i < 42; i++) {
			if(arr[i]>0)count++;
		}
		System.out.println(count);
	}
}

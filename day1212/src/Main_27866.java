import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_27866 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = new char[1000];
		arr = br.readLine().toCharArray();
		int i = Integer.parseInt(br.readLine());
		System.out.println(arr[i-1]);
	}
}

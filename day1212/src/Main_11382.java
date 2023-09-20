import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11382 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		System.out.println(Long.parseLong(s[0])+Long.parseLong(s[1])+Long.parseLong(s[2]));
	}
}

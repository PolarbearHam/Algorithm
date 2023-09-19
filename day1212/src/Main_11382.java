import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11382 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		System.out.println(Integer.parseInt(s[0])+Integer.parseInt(s[1])+Integer.parseInt(s[2]));
	}
}

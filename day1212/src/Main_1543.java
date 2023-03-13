import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1543 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String s2 = br.readLine();
		
		int len = s.length();
		int len2 = s2.length();
		
		s = s.replace(s2, "");
		System.out.println((len-s.length())/len2);
	}
}

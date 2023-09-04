import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10988 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		String s1 = "";
		
		for(int i=s.length()-1; i>=0; i--) {
			s1+=s.charAt(i);
		}
		if(s.equals(s1)) System.out.println(1);
		else System.out.println(0);

	}

}

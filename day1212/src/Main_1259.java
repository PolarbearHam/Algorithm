import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;

public class Main_1259 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			boolean flag = true;
			
			if(s.equals("0")) break;
			
			for (int i = 0; i < s.length()/2; i++) {
				if(s.charAt(i)!=s.charAt(s.length()-1-i)) flag = false;
			}
			if(flag) System.out.println("yes");
			else System.out.println("no");
		}

	}

}

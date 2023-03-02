import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9935 {
	static String origin;
	static String bomb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		origin = br.readLine();
		bomb = br.readLine();
		
		int orilen = origin.length();
		int bomlen = bomb.length();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < orilen; i++) {
			char c = origin.charAt(i);
			sb.append(c);
			if(sb.length()>=bomlen) {
				boolean isSame = true;
				for (int idx = 0; idx < bomlen; idx++) {
					char c1 = sb.charAt(sb.length()-bomlen+idx);
					char c2 = bomb.charAt(idx);
					if(c1!=c2) {
						isSame = false;
						break;
					}
				}
				if(isSame) {
					sb.delete(sb.length()-bomb.length(), sb.length());
				}
			}
		}
		if(sb.length()==0) {
			System.out.println("FRULA");
		}else {
			System.out.println(sb.toString());
		}
	}
}

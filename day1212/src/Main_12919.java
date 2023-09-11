import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12919 {
	static String S, T;
	static int ans, len;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		len = T.length();
		ans = dfs(S, T);
		System.out.println(ans);
	}
	
	public static int dfs(String s, String t) {
		if(s.length()==t.length()) {
			if(s.equals(t)) {
				return 1;
			}
			return 0;
		}
		int an = 0;
		if(t.charAt(0)=='B') {
			String substring = t.substring(1);
			StringBuilder sb = new StringBuilder(substring);
			String str = sb.reverse().toString();
			an += dfs(s, str);
		}
		
		if(t.charAt(t.length()-1)=='A') {
			an += dfs(s, t.substring(0, t.length()-1));
		}
		return an>0? 1 : 0;
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1120 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		
		int alen = a.length();
		int blen = b.length();
		int ans = alen;
		for (int i = 0; i <= blen-alen; i++) {
			int cnt=0;
			for (int j = 0; j < alen; j++) {
				if(a.charAt(j)!=b.charAt(i+j)) {
					cnt++;
				}
			}
			ans = Math.min(cnt, ans);
		}
		System.out.println(ans);
	}
}

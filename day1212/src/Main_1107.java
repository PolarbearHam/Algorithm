import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String now = br.readLine();
		int N = Integer.parseInt(now);
		int t = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < t; i++) {
			broken[Integer.parseInt(st.nextToken())]=true;
		}
		
		int result = Math.abs(N-100);
		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean flag = false;
			for (int j = 0; j < len; j++) {
				if(broken[str.charAt(j)-'0']) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				int min = Math.abs(N-i)+len;
				result = Math.min(min, result);
			}
		}
		System.out.println(result);
	}

}

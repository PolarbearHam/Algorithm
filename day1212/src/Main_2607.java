import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2607 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String first = br.readLine();
		int result = 0;
		
		for(int i=0; i<N-1; i++) {
			String str = br.readLine();
			int cnt = 0;
			int[] word = new int[26];
			for(int j=0; j<first.length(); j++) {
				word[first.charAt(j)-65]++;
			}
			for(int j=0; j<str.length(); j++) {
				if(word[str.charAt(j)-65]>0) {
					cnt++;
					word[str.charAt(j)-65]--;
				}
			}
			if(first.length()==str.length()&&(first.length()==cnt||first.length()-1==cnt)) {
				result++;
			}else if(first.length()==str.length()-1&&str.length()-1==cnt) {
				result++;
			}else if(first.length()==str.length()+1&&str.length()==cnt) {
				result++;
			}
		}
		System.out.println(result);
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1251 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int len = s.length();
		List<String> arr = new ArrayList<>();
		StringBuilder s1, s2, s3, sb;
		for(int i=1; i<len; i++) {
			for(int j=i+1; j<len; j++) {
				s1 = new StringBuilder(s.substring(0, i));
				s2 = new StringBuilder(s.substring(i, j));
				s3 = new StringBuilder(s.substring(j));
				sb = new StringBuilder();
				sb.append(s1.reverse()).append(s2.reverse()).append(s3.reverse());
				arr.add(sb.toString());
			}
		}
		Collections.sort(arr);
		System.out.println(arr.get(0));
	}
}

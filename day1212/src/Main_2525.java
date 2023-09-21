import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2525 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		int c = Integer.parseInt(br.readLine());
		int h = (b+c)/60;
		int m = (b+c)%60;
		h = (a+h)%24;
		System.out.println(h+" "+m);
	}
}

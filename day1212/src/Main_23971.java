import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23971 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int H, W, N, M;
//		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] s = br.readLine().split(" ");
		H = Integer.parseInt(s[0]);
		W = Integer.parseInt(s[1]);
		N = Integer.parseInt(s[2]);
		M = Integer.parseInt(s[3]);
		int count=0;
		
		for(int i=0; i<H; i+=N+1) {
			for(int j=0; j<W; j+=M+1) {
				count++;
			}
		}
		System.out.println(count);
	}
}

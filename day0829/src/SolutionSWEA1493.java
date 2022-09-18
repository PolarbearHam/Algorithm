import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionSWEA1493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int[] coordiA = getcoordi(x);
			int[] coordiB = getcoordi(y);
			
			int[] newCoord = {coordiA[0]+coordiB[0], coordiA[1]+coordiB[1]};
			
			int ans = getValue(newCoord);
			sb.append("#").append(test).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int[] getcoordi(int r) {
		int count = 1;
		for (int i = 1; ; i++) {
			for (int x = 1, y=i; x <= i ; x++, y--) {
				if(r==count) {
					return new int[] {x, y};
				}
				count++;
			}
		}
	}
	
	static int getValue(int[] rc) {
		int count = 1;
		for (int i = 1; ; i++) {
			for (int x = 1, y=i; x <= i; x++, y--) {
				if(x==rc[0]&&y==rc[1]) {
					return count;
				}
				count++;
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9461 {
	static Long[] arr = new Long[101];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			arr[0] = 0L;
			arr[1] = 1L;
			arr[2] = 1L;
			arr[3] = 1L;
			
			sb.append(recur(N)).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static long recur(int n) {
		if(arr[n]==null) {
			arr[n] = recur(n-2)+recur(n-3);
		}
		return arr[n];
	}
}

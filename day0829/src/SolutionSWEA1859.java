import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionSWEA1859 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int day = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] future = new int[day];
			for (int i = 0; i < future.length; i++) {
				future[i] = Integer.parseInt(st.nextToken());
			}
			int benefit = future[day-1];
			long ans = 0;
			for (int i = day-2; i >=0 ; i--) {
				if(benefit>future[i]) {
					ans+=benefit-future[i];
				}
				else {
					benefit=future[i];
				}
			}
			sb.append("#").append(test).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}

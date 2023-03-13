import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[10];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			double sum = 0;
			for (int i = 1; i < arr.length-1; i++) {
				sum += arr[i];
			}
			sum = Math.round(sum/8);
			sb.append("#").append(test).append(" ").append(String.format("%.0f", sum)).append("\n");
		}
		System.out.println(sb.toString());
	}
}

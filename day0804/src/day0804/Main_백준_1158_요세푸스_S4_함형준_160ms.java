package day0804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_1158_요세푸스_S4_함형준_160ms {
	public static int N;
	public static int K;
	public static int circle;
	public static int L;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}
		
		sb.append("<");
		while(!arr.isEmpty()) {
			circle = (circle+(K-1))%arr.size();
			sb.append(arr.get(circle)+", ");
			arr.remove(circle);
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.deleteCharAt(sb.lastIndexOf(" "));
		sb.append(">");
		System.out.println(sb);
	}
}

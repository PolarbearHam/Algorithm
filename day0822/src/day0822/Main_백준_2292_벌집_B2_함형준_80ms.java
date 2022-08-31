package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2292_벌집_B2_함형준_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp = 1;
		int ans = 1;
		while(N>temp) {
			temp = temp + 6*ans;
			ans++;
		}
		System.out.println(ans);

	}
}

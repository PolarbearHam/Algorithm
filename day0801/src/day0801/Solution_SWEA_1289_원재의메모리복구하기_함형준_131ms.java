package day0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1289_원재의메모리복구하기_함형준_131ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			char a = '0';
			int count = 0;
			
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)!=a) {
					count +=1;
					a=s.charAt(i);
				}
			}
			System.out.printf("#%d %d\n", test_case, count);
		}
	}
}

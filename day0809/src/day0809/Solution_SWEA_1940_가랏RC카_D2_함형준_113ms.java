package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1940_가랏RC카_D2_함형준_113ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			int sumSpeed = 0;
			int speed = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = 0;
				command = Integer.parseInt(st.nextToken());
				if(command!=0) {
					speed = Integer.parseInt(st.nextToken());
				}
				switch (command) {
				case 0:
					sum = sum+sumSpeed;
					if(sum<=0) {
						sum=0;
						sumSpeed=0;
					}
					break;
				case 1:
					sumSpeed = speed+sumSpeed;
					sum = sum+sumSpeed;
					break;
				case 2:
					speed = -speed;
					sumSpeed = sumSpeed+speed;
					sum = sum+sumSpeed;
					if(sum<=0) {
						sum=0;
						sumSpeed=0;
					}
					break;
				
				}
			}
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}

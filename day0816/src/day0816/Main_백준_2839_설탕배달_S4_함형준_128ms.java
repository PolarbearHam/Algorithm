package day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2839_설탕배달_S4_함형준_128ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int bag = 0;
		while(N>=0) {
			if(N%5==0) {
				bag += (N/5);
				sb.append(bag);
				break;
			}
			N-=3;
			bag+=1;
		}
		if(N<0) sb.append(-1);
		System.out.println(sb);
	}
}

package day0926;

import java.util.*;
import java.io.*;

public class Solution_SWEA_4008 {
	static int N, answer, min, max;
	static int[] operation;//0+ 1- 2* 3/
	static int[] number, opcount= {0,0,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());
			operation=new int[N-1];
			answer = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				opcount[i] = Integer.parseInt(st.nextToken());
			}
			
			number = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0);
			answer = max-min;
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void permutation(int index) {
		if(index == N-1) {
			int result = cal();
			min = min>result? result:min;
			max = max<result? result:max;
			return;
		}
		for(int i=0; i<4; i++) {
			if(opcount[i]>0) {
				opcount[i]--;
				operation[index] = i;
				permutation(index+1);
				opcount[i]++;
			}
		}
	}

	private static int cal() {
		int result = number[0];
		int nidx = 1;
		
		for(int i=0; i<N-1; i++) {
			switch(operation[i]) {
			case 0:
				result += number[nidx++];
				break;
			case 1:
				result -= number[nidx++];
				break;
			case 2:
				result *= number[nidx++];
				break;
			case 3:
				result /= number[nidx++];
				break;
			}
		}
		return result;
	}
}

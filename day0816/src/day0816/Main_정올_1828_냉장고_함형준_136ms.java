package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_1828_냉장고_함형준_136ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] ref = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ref[i][0] = Integer.parseInt(st.nextToken());
			ref[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ref, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}
				return o1[0]-o2[0];
			}
		});
		int count = 1;
		int big = ref[0][1];
		
		for (int i = 1; i < ref.length; i++) {
			if(ref[i][0]<=big) {
				if(ref[i][1]<big) big = ref[i][1];
				continue;
			}else {
				big = ref[i][1];
				count++;
			}
		}
		System.out.println(count);
		
		
	}
}

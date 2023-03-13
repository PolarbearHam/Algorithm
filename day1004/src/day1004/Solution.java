package day1004;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int answer = -1;
		int n = 4;
		int[][] wires = {{1,2},{2,3},{3,4}};
		
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(map[i], 10000);
        }
        String s = "AEIOU";
        System.out.println(s.valueOf("A"));
        for(int i=0; i<n-1; i++){
            for(int j=0; j<2; j++){
                map[wires[i][j]]
                				[wires[i]
                		[j]] = 1;
            }
        }
        for(int i=0; i<n; i++){
            System.out.println(map[i]);
        }
	}
}

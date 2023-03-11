package day1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2239_스도쿠_G4_함형준_552ms {
	public static int[][] arr = new int[9][9];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {			
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		sudoku(0,0);
	}
	
	static void sudoku(int row, int col) {
		if(col == 9) {
			sudoku(row+1, 0);
			return;
		}
		
		if(row==9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());;
			System.exit(0);
		}
		
		if(arr[row][col]==0) {
			for (int i = 1; i <= 9; i++) {
				if(possibility(row, col, i)) {
					arr[row][col] = i;
					sudoku(row, col+1);
				}
			}
			arr[row][col] = 0;
			return;
		}
		
		sudoku(row, col+1);
	}
	
	static boolean possibility(int row, int col, int value) {
		for (int i = 0; i < 9; i++) {
			if(arr[row][i]==value) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if(arr[i][col]==value) {
				return false;
			}
		}
		int setR = (row/3)*3;
		int setC = (col/3)*3;
		
		for (int i = setR; i < setR+3; i++) {
			for (int j = setC; j < setC+3; j++) {
				if(arr[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
}

package day0801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BufferedReaderScannerTest {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("inputTC.txt"));
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long start = System.nanoTime();
//		int TC = sc.nextInt();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
//			int N = sc.nextInt();
			int N = Integer.parseInt(br.readLine());
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
//					sum += sc.nextInt();
					sum+=Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
		long end = System.nanoTime();
		System.out.println((end-start)/1_000_000_000.0 + "s");
	}
}

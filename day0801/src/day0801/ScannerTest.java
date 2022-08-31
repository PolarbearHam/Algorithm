package day0801;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("who are we");
		int no = sc.nextInt();
		System.out.println("we are "+no);
		System.out.println("who are our expression");
		String msg = sc.next();
		System.out.println("our expression is "+msg);
	}
}

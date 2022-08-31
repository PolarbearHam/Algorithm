package review;

import java.util.Arrays;

public class Perm2 {
	static int N=4, R=3, C=0;
	static int[] a= {1,2,3,4}, b=new int[R];
	static boolean[] v=new boolean[N];
	public static void main(String[] args) {
//		permutation 4P3 = 4*3*2 = 24	duplicated permutation 4N3 = 4^3 = 64
//		combination 4C3 = 4				duplicated combination 4H3 = (4+3 - 1)C3 = 6C3 = 20
		permcomb(0,0);
//		subs(0); //subset 2^4 = 16
		System.out.println(C);
	}
	public static void permcomb(int depth, int start) {
		if(depth==R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}
		for (int i = start; i < N; i++) {
//			if(v[i]) continue;//duplicate combination
//			v[i]=true;
			b[depth] = a[i];
//			permcomb(depth+1, 0);//permutation
			permcomb(depth+1, i);//combination
//			v[i]=false;
		}
	}
	public static void comb(int depth, int start) {
		if(depth==R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}
		for (int i = start; i < N; i++) {
			b[depth] = a[i];
//			comb(depth+1, i+1);//combination
			comb(depth+1, i);//duplicated combination
		}
	}
	public static void subs(int depth) {
		if(depth==N) {
			for (int i = 0; i < N; i++) {
				System.out.print(v[i]? a[i]:"X");
			}
			System.out.println();
			C++;
			return;
		}
		v[depth] = true;
		subs(depth+1);
		v[depth] = false;
		subs(depth+1);
	}
}

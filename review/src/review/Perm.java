package review;

import java.util.Arrays;

public class Perm {
	static int N=4, R=3, C=0;
	static int[] a= {1,2,3,4}, b=new int[R];
	static boolean[] v=new boolean[N];
	public static void main(String[] args) {
		comb(0, 0);
		System.out.println(C);
	}
	public static void perm(int depth) {
		if(depth==R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i]=true;
			b[depth] = a[i];
			perm(depth+1);
			v[i]=false;
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
			comb(depth+1, i+1);//combination
//			comb(depth+1, i);//duplicated combination
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

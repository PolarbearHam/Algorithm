import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2263 {
	static int n, idx;
	static int[] in, post, pre;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		in = new int[n];
		post = new int[n];
		pre = new int[n];
		
		String[] srr = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			in[i] = Integer.parseInt(srr[i]);
		}
		srr = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			post[i] = Integer.parseInt(srr[i]);
		}
		getPreOrder(0, n-1, 0, n-1);
		
		for(int i:pre) {
			System.out.print(i+" ");
		}
		
	}

	private static void getPreOrder(int is, int ie, int ps, int pe) {
		if(is<=ie&&ps<=pe) {
			pre[idx++] = post[pe];
			int pos = is;
			for(int i=is; i<=ie; i++) {
				if(in[i]==post[pe]) {
					pos = i;
					break;
				}
			}
			getPreOrder(is, pos-1, ps, ps+pos-is-1);
			getPreOrder(pos+1, ie, ps+pos-is, pe-1);
		}
		
	}
}

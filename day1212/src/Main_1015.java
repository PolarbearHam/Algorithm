import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1015 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = A[i];
		}
		Arrays.sort(B);
		String s = "";
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(A[i]==B[j]) {
					s += j+" ";
					B[j] = -1;
					break;
				}
			}
		}
		System.out.println(s);
	}

}

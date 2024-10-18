import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1213 {
	static int[] acgt = new int[4];
	static int[] arr = new int[4];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			acgt[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<p; i++) {
			if(str.charAt(i)=='A') arr[0]++;
			if(str.charAt(i)=='C') arr[1]++;
			if(str.charAt(i)=='G') arr[2]++;
			if(str.charAt(i)=='T') arr[3]++;
		}
		if(check()) answer++;
		int left = 0;
		for(int i=p; i<s; i++) {
			left = i-p;
			if(str.charAt(left)=='A') arr[0]--;
			if(str.charAt(left)=='C') arr[1]--;
			if(str.charAt(left)=='G') arr[2]--;
			if(str.charAt(left)=='T') arr[3]--;
			
			if(str.charAt(i)=='A') arr[0]++;
			if(str.charAt(i)=='C') arr[1]++;
			if(str.charAt(i)=='G') arr[2]++;
			if(str.charAt(i)=='T') arr[3]++;
			
			if(check()) answer++;
		}
		System.out.println(answer);
	}
	
	public static boolean check() {
		for(int i=0; i<4; i++) {
			if(acgt[i]>arr[i]) {
				return false;
			}
		}
		return true;
	}

}

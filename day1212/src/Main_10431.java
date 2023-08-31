import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_10431 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int P = Integer.parseInt(br.readLine());
		
		for(int test = 1; test<=P; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[20];
			int a = Integer.parseInt(st.nextToken());
			int cnt =0;
			for(int i=0; i<arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<i; j++) {
					if(arr[j]>arr[i]) {
						cnt++;
					}
				}
			}
			System.out.println(test+" "+cnt);
		}
	}
}

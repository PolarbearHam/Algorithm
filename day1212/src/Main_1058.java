import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1058 {
	static int N;
	static int arr[][];
	static int max = Integer.MAX_VALUE>>2;
	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			
			for(int j=1; j<=N; j++) {
				char ch = str.charAt(j-1);
				
				if(ch=='Y') arr[i][j]=1;
				else if(i!=j) arr[i][j] = max;
			}
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j || j==k || i==k) continue;
					else if(arr[i][j] > arr[i][k]+arr[k][j]) arr[i][j] = arr[i][k]+arr[k][j];
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			int tmp = 0;
			
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				else if(arr[i][j] <= 2) tmp++;
			}
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10989 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[10001];
		
		for(int i=0; i<N; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}
		br.close();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<10001; i++) {
			while(cnt[i]>0) {
				sb.append(i).append("\n");
				cnt[i]--;
			}
		}
		System.out.println(sb);
	}
}

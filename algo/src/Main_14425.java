import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14425 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if(set.contains(s)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}

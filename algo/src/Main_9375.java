import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_9375 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				String[] srr = br.readLine().split(" ");
				if(map.containsKey(srr[1])) {
					map.put(srr[1], map.get(srr[1])+1);
				}else {
					map.put(srr[1], 1);
				}
			}
			int result = 1;
			for(int i : map.values()) {
				result *= (i+1);
			}
			System.out.println(result-1);
		}
	}
}

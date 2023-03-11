import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1620 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int idx = 1;
		HashMap<String, String> map = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			map.put(s, Integer.toString(i));
			map.put(Integer.toString(i), s);
		}
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			System.out.println(map.get(s));
		}
	}
}

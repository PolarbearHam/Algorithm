import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_22233 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Boolean> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), true);
		}
		int cnt = N;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			while(st.hasMoreTokens()) {
				String keyWord = st.nextToken(); 
				if(map.containsKey(keyWord)) {
					map.remove(keyWord);
					cnt--;
				}
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
	}

}

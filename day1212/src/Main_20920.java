import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main_20920 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> wordMap = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			if(s.length()>=M) {
				Integer cnt = wordMap.getOrDefault(s, 0);
				wordMap.put(s, cnt+1);
			}
		}
		List<String> words = wordMap.keySet().stream().collect(Collectors.toList());
		
		words.sort((o1, o2)->{
			int c1 = wordMap.get(o1);
			int c2 = wordMap.get(o2);
			
			if(c1==c2) {
				if(o1.length()==o2.length()) {
					return o1.compareTo(o2);
				}
				return o2.length()-o1.length();
			}
			return c2-c1;
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<words.size(); i++) {
			sb.append(words.get(i)).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
}

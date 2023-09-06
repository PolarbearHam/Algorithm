import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_25757 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int p = getPlayerNumber(st.nextToken().charAt(0));
		HashSet<String> hs = new HashSet<>();
		int cnt = 0;
		while(N-->0) {
			String cur = br.readLine();
			cnt+= hs.contains(cur)?0:1;
			hs.add(cur);
		}
		System.out.println(cnt/p);
		
	}
	
	public static int getPlayerNumber(char c) {
		switch(c) {
			case 'Y': return 1;
			case 'F': return 2;
			case 'O': return 3;
		}
		return -1;
	}
}

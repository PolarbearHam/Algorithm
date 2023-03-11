import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11656 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		PriorityQueue<String> list = new PriorityQueue<>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.substring(i));
		}
		StringBuilder sb = new StringBuilder();
		
		while(list.size()>0) {
			sb.append(list.poll()).append("\n");
		}
		System.out.println(sb.toString());
	}
}

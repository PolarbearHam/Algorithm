import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11866 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(i+1);
		}
		sb.append("<");
		int index = 0;
		int divide = N;
		while(N>1) {
			index = (index+(K-1)) % N;
			
			sb.append(list.remove(index)).append(", ");
			N--;
		}
		sb.append(list.remove(0)).append(">");
		System.out.println(sb.toString());
	}
}

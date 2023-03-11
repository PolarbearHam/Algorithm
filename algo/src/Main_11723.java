import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int bitset = 0;
		StringTokenizer st;

		while(M-- >0) {
			st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken();
			int num;
			
			switch(op) {
			case "add" :
				num=Integer.parseInt(st.nextToken());
				bitset |=(1<<(num-1));
				break;
			case "remove" :
				num = Integer.parseInt(st.nextToken());
				bitset = bitset & ~(1 << (num-1));
				break;
			case "check" :
				num = Integer.parseInt(st.nextToken());
				sb.append((bitset & (1<<(num-1))) != 0 ? "1\n" : "0\n");
				break;
			case "toggle" :
				num = Integer.parseInt(st.nextToken());
				bitset ^= (1<<(num-1));
				break;
			case "all" :
				bitset |= (~0);
				break;
			case "empty" :
				bitset &= 0;
				break;
			}
		}
		System.out.println(sb.toString());

	}

}

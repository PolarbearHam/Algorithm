import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_5430 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> deq;
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- >0) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			deq = new ArrayDeque<>();
			
			for (int i = 0; i < n; i++) {
				deq.add(Integer.parseInt(st.nextToken()));
			}
			
			AC(command, deq);
		}
		System.out.println(sb);
	}

	private static void AC(String command, ArrayDeque<Integer> deq) {
		boolean isRight = true;
		for(char cmd: command.toCharArray()) {
			if(cmd=='R') {
				isRight = !isRight;
				continue;
			}
			
			if(isRight) {
				if(deq.pollFirst()==null) {
					sb.append("error\n");
					return;
				}
			}else {
				if(deq.pollLast()==null) {
					sb.append("error\n");
					return;
				}
			}
		}
		makeString(deq, isRight);
	}

	private static void makeString(ArrayDeque<Integer> deq, boolean isRight) {
		sb.append("[");
		if(deq.size()>0) {
			if(isRight) {
				sb.append(deq.pollFirst());
				while(deq.size()>0) {
					sb.append(",").append(deq.pollFirst());
				}
			}else {
				sb.append(deq.pollLast());
				while(deq.size()>0) {
					sb.append(",").append(deq.pollLast());
				}
			}
		}
		sb.append("]").append("\n");
	}
}

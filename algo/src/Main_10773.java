import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<K; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a!=0) stack.add(a);
			else if(a==0) stack.pop();
		}
		int result = 0;
		while(stack.size()>0) {
			result += stack.pop();
		}
		System.out.println(result);
	}
}

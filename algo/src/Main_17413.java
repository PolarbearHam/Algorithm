import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main_17413 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int slen = s.length();
		boolean flag = false;
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < slen; i++) {
			if(s.charAt(i)=='<') {
				flag = true;
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(s.charAt(i));
			}
			else if(s.charAt(i)=='>') {
				flag = false;
				System.out.print(s.charAt(i));
			}
			else if(flag) {
				System.out.print(s.charAt(i));
			}
			else if(!flag) {
				if(s.charAt(i)==' ') {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(s.charAt(i));
				}else {
					stack.push(s.charAt(i));
				}
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
	}
}

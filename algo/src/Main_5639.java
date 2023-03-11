import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_5639 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		Node root = new Node(Integer.parseInt(br.readLine()));
		while(true) {
			s = br.readLine();
			if(s ==null||s.equals("")) break;
			root.insert(Integer.parseInt(s));
		}
		postOrder(root);
	}
	
	static class Node{
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
		}
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		void insert(int n) {
			if(n<this.data) {
				if(this.left==null) this.left = new Node(n);
				else this.left.insert(n);
			}else {
				if(this.right==null) this.right = new Node(n);
				else this.right.insert(n);
			}
		}
	}
	public static void postOrder(Node node) {
		if(node==null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);
	}
}

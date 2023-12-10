import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_9934 {
	static int k;
	static int[] arr;
	static List<ArrayList<Integer>> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		int l = (int)Math.pow(2, k)-1;
		arr = new int[l];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<l; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList<>();
		for(int i=0; i<k; i++) {
			list.add(new ArrayList<>());
		}
		
		dfs(0, l, 0);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i <k; i++) {
			for(int j : list.get(i)) {
				sb.append(j).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void dfs(int start, int end, int depth) {
		if(depth==k) {
			return;
		}
		
		int mid = (start+end)/2;
		list.get(depth).add(arr[mid]);
		
		dfs(start, mid, depth+1);
		dfs(mid+1, end, depth+1);
		
	}

}

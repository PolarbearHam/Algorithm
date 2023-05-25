import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15663 {
	static int N, M;
	static int[] arr, result;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		combi(0, sb);
		System.out.println(sb.toString());
	}
	
	public static void combi(int start, StringBuilder sb) {
		if(start==M) {
			for(int i=0; i<M;  i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		}else {
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					int cnt = 0;
					for(int j=0; j<list.size(); j++) {
						if(arr[i]==list.get(j)) {
							cnt++;
						}
					}
					if(cnt==0) {
						visited[i] = true;
						result[start] = arr[i];
						list.add(arr[i]);
						combi(start+1, sb);
						visited[i] = false;
					}else {
						continue;
					}
				}
			}
		}
		
	}
}

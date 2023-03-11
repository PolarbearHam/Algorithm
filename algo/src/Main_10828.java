import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10828 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10000];
		int idx = -1;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken();
			
			switch(op) {
			case "push":
				idx++;
				arr[idx] = Integer.parseInt(st.nextToken());
				break;
			case "top":
				if(arr[0]==0) {
					System.out.println(-1);
				}else {
					System.out.println(arr[idx]);
				}
				break;
			case "pop":
				if(arr[0]==0) {
					System.out.println(-1);
				}else {
					System.out.println(arr[idx]);
					arr[idx--]=0;
				}
				break;
			case "size":
				int count=0;
				while(true) {
					if(arr[count]==0) break;
					count++;
				}
				System.out.println(count);
				break;
			case "empty":
				if(arr[0]==0) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			}
		}

	}

}

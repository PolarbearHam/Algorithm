import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2096 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] maxDp = new int[3];
		int[] minDp = new int[3];
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(i==0) {
				maxDp[0] = minDp[0] = x;
				maxDp[1] = minDp[1] = y;
				maxDp[2] = minDp[2] = z;
			}else {
				int preMaxDp0 = maxDp[0], preMaxDp2 = maxDp[2];
				maxDp[0] = Math.max(maxDp[0], maxDp[1])+x;
				maxDp[2] = Math.max(maxDp[2], maxDp[1])+z;
				maxDp[1] = Math.max(Math.max(preMaxDp0, maxDp[1]), preMaxDp2)+y;
				
				int preMinDp0 = minDp[0], preMinDp2 = minDp[2];
				minDp[0] = Math.min(minDp[0],  minDp[1])+x;
				minDp[2] = Math.min(minDp[2],  minDp[1])+z;
				minDp[1] = Math.min(Math.min(preMinDp0, minDp[1]), preMinDp2)+y;
			}
		}
		System.out.println(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]))+" "+ Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
		
	}
}

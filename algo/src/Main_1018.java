import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018 {
	public static boolean[][] arr;
	public static int min = 64;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j)=='W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}
		
		int N_row = N-7;
		int M_col = M-7;
		
		for(int i=0; i<N_row; i++) {
			for(int j=0; j<M_col; j++) {
				find(i, j);
			}
		}
		System.out.println(min);
	}
	public static void find(int r, int c) {
		int end_r = r+8;
		int end_c = c+8;
		int count = 0;
		
		boolean TF = arr[r][c];
		
		for (int i = r; i < end_r; i++) {
			for (int j = c; j < end_c; j++) {
				if(arr[i][j] != TF) {
					count++;
				}
				TF = (!TF);
			}
			TF = !TF;
		}
		count = Math.min(count, 64-count);
		min = Math.min(min, count);
	}
}

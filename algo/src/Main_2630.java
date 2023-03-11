import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630 {
	static int N, white, blue;
	static int[][] map;
	//0 - white, 1 - blue
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		partition(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	public static void partition(int row, int col, int size) {
		if(check(row, col, size)) {
			if(map[row][col]==0) {
				white++;
			}else {
				blue++;
			}
			return;
		}
		int nSize = size/2;
		
		partition(row, col, nSize);
		partition(row, col+nSize, nSize);
		partition(row+nSize, col, nSize);
		partition(row+nSize, col+nSize, nSize);
	}
	
	public static boolean check(int row, int col, int size) {
		int color = map[row][col];
		for (int i = row; i < row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(map[i][j]!=color) return false;
			}
		}
		return true;
	}
	
}

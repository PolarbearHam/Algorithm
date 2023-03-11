import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {
	static int[][] map;
	static int[] count= {0, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0, 0, N);
		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);
	}
	public static void partition(int r, int c, int size) {
		if(counting(r, c, size)) {
			if(map[r][c]==-1) {
				count[0]++;
			}else if(map[r][c]==0) {
				count[1]++;
			}else {
				count[2]++;
			}
			return;
		}
		int nSize = size/3;
		
		partition(r, c, nSize);
		partition(r, c+nSize, nSize);
		partition(r, c+2*nSize, nSize);
		
		partition(r+nSize, c, nSize);
		partition(r+nSize, c+nSize, nSize);
		partition(r+nSize, c+2*nSize, nSize);
		
		partition(r+2*nSize, c, nSize);
		partition(r+2*nSize, c+nSize, nSize);
		partition(r+2*nSize, c+2*nSize, nSize);
	}
	public static boolean counting(int r, int c, int size) {
		
		int color = map[r][c];
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(color != map[i][j]) return false;
			}
		}
		return true;
	}
}

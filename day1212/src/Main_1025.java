import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1025 {
	static int N, M;
	static int[][] arr;
	static int result = -1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[10][10];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j)-48;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int mi = -N; mi<N; ++mi) {
					for(int mj= -M; mj<M; ++mj) {
						if(mi==0 && mj==0) {
							continue;
						}
						int t = 0;
						int ni = i;
						int nj = j;
						while(ni>=0 && ni<N && nj>=0 && nj<M) {
							t = 10 * t + arr[ni][nj];
							if(Math.abs(Math.sqrt(t)-(int)Math.sqrt(t))<1e-10) {
								result = Math.max(result, t);
							}
							ni += mi;
							nj += mj;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}

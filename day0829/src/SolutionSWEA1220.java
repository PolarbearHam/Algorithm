import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SolutionSWEA1220 {
	static int[][] map;
	static int N;//1 N, 2 S, U N, D S
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= 10; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < 100; i++) {
				String s = br.readLine();
				for (int j = 0, index=0; j < 100; j++, index+=2) {
					map[i][j] = s.charAt(index)-48;
				}
			}
			int sum =0;
			for (int i = 0; i < 100; i++) {
				int last = 0;
				for (int j = 0; j < 100; j++) {
					if(map[j][i]==1) {
						last=1;
					}
					else if(map[j][i]==2) {
						if(last==1) {
							sum++;
						}
						last=2;
					}
				}
			}
			sb.append("#").append(test).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}

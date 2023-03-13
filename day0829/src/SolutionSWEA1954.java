import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SolutionSWEA1954 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int turn = 1;
			int sum = 1;
			int x = 0, y = -1;
			while(true) {
				for (int i = 0; i < N; i++) {
					y+=turn;
					map[x][y] = sum++;
				}
				N--;
				for (int i = 0; i < N; i++) {
					x+=turn;
					map[x][y] = sum++;
				}
				turn *= -1;
				if(N==0)break;
			}
			sb.append("#").append(test).append("\n");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}

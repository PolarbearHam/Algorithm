import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1236 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int r = 0;
		int c = 0;
		char[][] map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		for(int i=0; i<N; i++) {
			boolean flag = true;
			for(int j=0; j<M; j++) {
				if(map[i][j]=='X') {
					flag = false;
					break;
				}
			}
			if(flag) r++;
		}
		for(int i=0; i<M; i++) {
			boolean flag = true;
			for(int j=0; j<N; j++) {
				if(map[j][i]=='X') {
					flag = false;
					break;
				}
			}
			if(flag) c++;
		}
		System.out.println(r>c?r:c);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {
	static int N, M, min;
	static int[][] transMap;
	static char[][] map;
	static boolean[][][] visited;
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static int[] dr= {-1, 1, 0, 0};
	static int[] dc= {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(N-1==0&&M-1==0) {
			System.out.println(1);
			System.exit(0);
		}
		
		map = new char[N][M];
		transMap = new int[N][M];
		visited = new boolean[2][N][M];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		q.add(new int[] {0, 0, 0});

		while(q.size()>0) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now[0]+dr[i];
				int nc = now[1]+dc[i];
				
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(map[nr][nc]=='1') {
					if(now[2]==0&&!visited[1][nr][nc]) {
						visited[now[2]][nr][nc] = true;
						transMap[nr][nc] = transMap[now[0]][now[1]]+1;
						q.offer(new int[] {nr, nc, 1});
					}
				}
				else {
					if(!visited[now[2]][nr][nc]) {
						visited[now[2]][nr][nc] = true;
						transMap[nr][nc] = transMap[now[0]][now[1]]+1;
						q.offer(new int[] {nr, nc, now[2]});
					}
				}
				if(nr==N-1&&nc==M-1) {
					System.out.println(transMap[nr][nc]+1);
					System.exit(0);
				}
			}
		}
		System.out.println(-1);
	}

}

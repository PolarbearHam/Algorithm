import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21736 {
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][] visited;
	static int answer;
	static Queue<int[]> q = new ArrayDeque<>();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String a = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = a.charAt(j);
				if(map[i][j]=='I') {
					q.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		find();
		if(answer==0) System.out.println("TT");
		else System.out.println(answer);
	}
	
	public static void find() {
		while(q.size()>0) {
			int[] rc = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = rc[0]+dr[i];
				int nc = rc[1]+dc[i];
				
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc]=='X') {
					visited[nr][nc] = true;
					continue;
				}
				if(map[nr][nc]=='P') {
					answer++;
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
				else if(map[nr][nc]=='O') {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}

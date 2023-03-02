import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17780 {
	static int N, K, ans;
	static int[][] horse, color;
	static LinkedList<Node>[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	private static class Node{
		int n, d;
		Node(int n, int d){
			this.n = n;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		color = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		horse = new int[K][2];
		map = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			
			if(d==1) d=0;
			else if(d==4) d=1;
			horse[i][0] = r;
			horse[i][1] = c;
			
			map[r][c].add(new Node(i, d));
		}
		bfs();
	}

	private static void bfs() {		
		for (int t = 1; t <= 1000; t++) {
			for (int k = 0; k < K; k++) {
				int r = horse[k][0];
				int c = horse[k][1];
				int d = map[r][c].get(0).d;
				
				if(map[r][c].get(0).n != k) continue;
				
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr<0||nc<0||nr>=N||nc>=N||color[nr][nc]==2) {
					map[r][c].get(0).d = d = (d+2)%4; 
					nr = r+dr[d];
					nc = c+dc[d];
					if(nr<0||nc<0||nr>=N||nc>=N||color[nr][nc]==2) {
						continue;
					}else {
						if(move(r, c, nr, nc, color[nr][nc])) {
							System.out.println(t);
							return;
						}
					}
				}else {
					if(move(r, c, nr, nc, color[nr][nc])) {
						System.out.println(t);
						return;
					}
				}
			}
		}
		System.out.println("-1");
	}
	
	private static boolean move(int r, int c, int nr, int nc, int color) {
		if(color==0) {
			while(map[r][c].size()>0) {
				Node temp = map[r][c].removeFirst();
				horse[temp.n][0] = nr;
				horse[temp.n][1] = nc;
				map[nr][nc].add(temp);
			}
		}else {
			while(map[r][c].size()>0) {
				Node temp = map[r][c].removeLast();
				horse[temp.n][0] = nr;
				horse[temp.n][1] = nc;
				map[nr][nc].add(temp);
			}
		}
		if(map[nr][nc].size()>=4) return true;
		else return false;
	}
}

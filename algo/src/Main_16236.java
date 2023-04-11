import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static ArrayList<int[]> fishes;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					q.add(new int[] {i, j, 0});
					map[i][j] = 0;
				}
			}
		}
		int eat = 0;
		int time = 0;
		int height = 2;
		while(true) {
			LinkedList<int[]> fish = new LinkedList<>();
			int[][] dist = new int[N][N];
			
			while(q.size()>0) {
				int[] now = q.poll();
				
				for(int i=0; i<4; i++) {
					int nr = now[0]+dr[i];
					int nc = now[1]+dc[i];
					
					if(nr>=0 && nc>=0 && nr<N && nc<N && dist[nr][nc]==0 && map[nr][nc]<=height) {
						dist[nr][nc] = dist[now[0]][now[1]]+1;
						q.add(new int[] {nr, nc, dist[nr][nc]});
						if(1<=map[nr][nc] && map[nr][nc]<=6 && map[nr][nc]<height) fish.add(new int[] {nr, nc, dist[nr][nc]});
					}
				}
			}
			
			if(fish.size()==0) {
				System.out.println(time);
				return;
			}
			int[] currentFish = fish.get(0);
			for (int i = 1; i < fish.size(); i++) {
				if(currentFish[2]>fish.get(i)[2]) {
					currentFish = fish.get(i);
				}
				else if(currentFish[2]==fish.get(i)[2]) {
					if(currentFish[0]>fish.get(i)[0]) currentFish = fish.get(i);
					else if(currentFish[0]==fish.get(i)[0]) {
						if(currentFish[1]>fish.get(i)[1]) currentFish = fish.get(i);
					}
				}
				
			}
			time += currentFish[2];
			eat++;
			map[currentFish[0]][currentFish[1]]=0;
			if(eat == height) {
				height++;
				eat = 0;
			}
			q.add(new int[] {currentFish[0], currentFish[1], 0});
		}
	}
}

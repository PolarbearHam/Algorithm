import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_2 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					q.add(new int[] {i, j, 0});
					map[i][j]=0;
				}
			}
		}
		
		int eat = 0;
		int time = 0;
		int height = 2;
		while(true) {
			ArrayList<int[]> fish = new ArrayList<>();
			int[][] dist = new int[n][n];
			
			while(q.size()>0) {
				int[] now = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = now[0]+dr[i];
					int nc = now[1]+dc[i];
					
					if(nr>=0 && nc>=0 && nr<n && nc<n && dist[nr][nc]==0 && map[nr][nc]<=height) {
						dist[nr][nc] = dist[now[0]][now[1]]+1;
						q.add(new int[] {nr,nc,dist[nr][nc]});
						if(map[nr][nc]>=1 && map[nr][nc]<=6 && map[nr][nc]<height) {
							fish.add(new int[] {nr, nc, dist[nr][nc]});
						}
					}
				}
			}
			if(fish.size()==0) {
				System.out.println(time);
				return;
			}
			int[] nowFish = fish.get(0);
			for (int i = 1; i < fish.size(); i++) {
				if(nowFish[2]>fish.get(i)[2]) {
					nowFish = fish.get(i);
				}else if(nowFish[2]==fish.get(i)[2]){
					if(nowFish[0]>fish.get(i)[0]) nowFish = fish.get(i);
					else if(nowFish[0]==fish.get(i)[0]) {
						if(nowFish[1]>fish.get(i)[1]) nowFish = fish.get(i);
					}
				}
			}
			time+=nowFish[2];
			eat++;
			map[nowFish[0]][nowFish[1]] = 0;
			if(eat==height) {
				height++;
				eat = 0;
			}
			q.add(new int[] {nowFish[0], nowFish[1], 0});
		}
	}
}

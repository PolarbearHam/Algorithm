import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4014_활주로건설_함형준 {
	static int N, X, ans;
	static int[][] map, map2;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			map2 = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0, index=0; j < N; j++, index+=2) {
					map2[j][i] = map[i][j] = s.charAt(index)-48;
				}
			}
			sb.append("#").append(test).append(" ").append(ans=process()).append("\n");
		}
		System.out.println(sb.toString());
	}
	static int process() {
		int count =0;
		for (int i = 0; i < N; i++) {
			if(makeRoad(map[i])) count++;
			if(makeRoad(map2[i])) count++;
		}
		return count;
	}
	
	static boolean makeRoad(int[] road) {
		int beforeHeight = road[0], size=0;
		int j=0;
		while(j<N) {
			if(beforeHeight == road[j]) {
				size++;
				j++;
			}else if(beforeHeight+1==road[j]) {//오르막경사로 설치 체크
				if(size<X) return false;
				
				beforeHeight++;
				size=1;
				j++;
			}else if(beforeHeight-1==road[j]) {
				int count=0;
				for (int k = j; k < N; k++) {
					if(road[k]!=beforeHeight-1) return false;
					if(++count==X) break;
				}
				if(count<X)return false;
				beforeHeight--;
				j+=X;
				size=0;
			}else {
				return false;
			}
		}
		return true;
	}
	
}

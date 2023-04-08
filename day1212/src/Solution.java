import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
		int n = 3;
		int m =3;
		long[][] a = {{1,4,5},{3,8,2},{10,0,6}};
		System.out.println(solution(n,m,a));
	}

    public static long solution(int n, int m, long[][] a) {
        long answer = 0;
        
        for(int i=0; i<n; i++){
            visited = new boolean[n][m];
            q.add(new int[]{i, 0});
            visited[i][0] = true;
            
            answer = Math.max(bfs(i, a, n, m), answer);
        }

        return answer;
    }

    public static long bfs(int l, long[][] a, int n, int m){
        long sum = a[l][0];

        while(q.size()>0){
            int[] rc = q.poll();
            for(int i=0; i<3; i++){
                int nr = rc[0]+dr[i];
                int nc = rc[1]+dc[i];
                if(nr<0||nc<0||nr>=n||nc>=m) continue;
                if(visited[nr][nc]) continue;
                int count =0;
                for(int j=0; j<4; j++){
                    int sr = nr+dr[j];
                    int sc = nc+dc[j];
                    if(sr<0||sc<0||sr>=n||sc>=m) continue;
                    if(visited[sr][sc]) count++;
                }
                if(count>=3) continue;
                sum+=a[nr][nc];
                visited[nr][nc]=true;
                q.add(new int[]{nr, nc});
                System.out.println(Arrays.toString(visited[0]));
            }
        }
        return sum;
    }
}
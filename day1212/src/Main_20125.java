import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_20125 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] map;
	static int N, leftA, rightA, leftL, rightL, back;
	static int[] heart = new int[2];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='_') continue;
				else if(map[i][j]=='*') {
					if(checkHeart(i, j)==0) {
						heart[0] = i;
						heart[1] = j;
					}
				}
			}
		}
		int copyR = heart[0];
		int copyC = heart[1]-1;
		int answerR = heart[0];
		int answerC = heart[1];
		while(true) {
			if(copyC<0||map[copyR][copyC]=='_') break;
			if(map[copyR][copyC]=='*') {
				leftA++;
			}
			copyC--;
		}
		copyC = heart[1]+1;
		while(true) {
			if(copyC>=N||map[copyR][copyC]=='_') break;
			if(map[copyR][copyC]=='*') rightA++;
			copyC++;
		}
		copyC = heart[1];
		copyR = heart[0]+1;
		while(true) {
			if(copyR>=N||map[copyR][copyC]=='_') {
				heart[0] = copyR;
				heart[1] = copyC-1;
				break;
			}
			if(map[copyR][copyC]=='*') back++;
			copyR++;
		}
		copyR = heart[0];
		copyC = heart[1];
		while(true) {
			if(copyR>=N||map[copyR][copyC]=='_') break;
			if(map[copyR][copyC]=='*') leftL++;
			copyR++;
		}
		copyR = heart[0];
		copyC = heart[1]+2;
		while(true) {
			if(copyR>=N||map[copyR][copyC]=='_') break;
			if(map[copyR][copyC]=='*') rightL++;
			copyR++;
		}
		System.out.println(answerR+" "+answerC);
		System.out.println(leftA+" "+rightA+" "+back+" "+leftL+" "+rightL);
	}
	
	static int checkHeart(int r, int c) {
		int flag = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr<0||nc<0||nr>=N||nc>=N) continue;
				if(map[nr][nc]=='_') {
					flag = -1;
					break;
				}
			}
		}
		return flag;
		
	}
}

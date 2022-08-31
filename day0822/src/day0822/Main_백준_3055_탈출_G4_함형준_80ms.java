package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class location{
	int r, c; // y가 R(행) / x가 C(열)
	public location(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main_백준_3055_탈출_G4_함형준_80ms {
	static final String FAIL = "KAKTUS";	// 실패시 출력 문구
	static int R,C;				   			// 지도 크기 R : 행, C : 열
	static int time;						// 최종 걸린 시간 (답)
	static char [][] map;		   			// 지도정보
	static int [] dr = {-1,1,0,0}; 			// direction Row    행 이동 방향 
	static int [] dc = {0,0,-1,1}; 			// direction Column 열 이동 방향
	
	static char [][] visit;		  // visit 확인 지도
	static Queue<location> loc; // 고슴도치 위치 BFS용 queue
	static Queue<location> water; // 물 위치 BFS용 queue
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new char[R][C];
		String str;		// input 받는 임시변수		

		loc = new LinkedList<location>();
		water = new LinkedList<location>();
		
		// . 비어있는 곳
		// * 물이 차있는 곳
		// X 돌이 있는 곳
		// D 비버굴
		// S 고슴도치
		// map에 지도정보 받으면서 visit 초기화하고 현재 위치 (cr, cc) 확인
		for(int i=0; i<R; i++) {
			str = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j]=='*') {
					visit[i][j] = 'x';
					water.offer(new location(i,j));
				}
				else if (map[i][j]=='D') visit[i][j] = 'g';
				else if (map[i][j]=='X') visit[i][j] = 'x';
				else if (map[i][j]=='.') visit[i][j] = 'p';
				else {
					// 고슴도치 현재 위치는 이동하기 때문에 홍수를 위한 빈칸처리
					map[i][j] = '.';
					visit[i][j] = 'x';
					loc.offer(new location(i,j));
				}
				
			}			
		}
		bfs();
		if(time==-1)System.out.println(FAIL);
		else System.out.println(time);
	}
	
	
	static void bfs() {
		// 시간 순으로 확인하기
		for(time = 1; ;time++) {

			// 1. 물 채우기
			int wSize = water.size();
			for (int i=0; i<wSize; i++) {
				location cur = water.poll();
				
				// 사방으로
				for(int j=0; j<=3; j++) {
					int nr = cur.r + dr[j];
					int nc = cur.c + dc[j];
					
					// 지도 범위 초과시 continue
					if (nr < 0 || nc < 0 || nr>=R || nc>=C) continue;
					
					if (map[nr][nc] =='.') {
						map[nr][nc] = '*';
						water.add(new location(nr,nc));
					}
				}
			}

			// 2. 고슴도치 이동하기
			int lSize = loc.size();
			// 고슴도치 이동 불가능할경우 FAIL 처리
			if (lSize==0) {
				time = -1;
				return;
			}
			for(int i=0; i<lSize; i++) {
				location cur = loc.poll();
				
				// 사방으로
				for(int j=0; j<=3; j++) {
					int nr = cur.r + dr[j];
					int nc = cur.c + dc[j];
					
					// 지도 범위 초과시 continue
					if (nr < 0 || nc < 0 || nr>=R || nc>=C) continue;
					// 목표 도달했을 경우 현재 time 출력위해 return
					if (map[nr][nc] =='D') return; 
					if (map[nr][nc] == '.' && visit[nr][nc] ==  'p') 
					{
						visit[nr][nc] = 'x';
						loc.add(new location(nr,nc));
					}
				}
			}
		}
		
	}
	
}
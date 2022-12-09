import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//2개 구역 분리 = 부분집합
//분리된 2개 구역 연결 = 인접행렬+bfs
public class Solution_지역구나누기 {
	static int T, N, min;
	static int[][] matrix;//matrix[1][3] = 1과 3 연결
	static boolean[] select, visit;//부분집합에 사용  / bfs로 그래프 연결구조를 matrix를 이용해 따짐
	static Queue<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			
			//자료구조 초기화
			//static 변수들 초기화
			matrix = new int[N+1][N+1];//1부터 시작
			select = new boolean[N+1];// 부분집합에서 사용
			visit = new boolean[N+1];// bfs 사용 
			min = Integer.MAX_VALUE;
			
			//구역 정보를 인접행렬 입력 처리
			//matrix 배열 완성
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			//0 dummy, 1~N 사용 <= 0 index 인구수를 저장하는데 활용
			//matrix[2][0] <= 구역, 마을 2번의 인구수 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				matrix[i][0] = Integer.parseInt(st.nextToken());
			}
			//N이 4
			//0 0 0 0 0
			//3 0 0 1 1 <= 1번의 인구수는 3, 1에서 3, 4 연결
			
			//풀이
			subset(1);
			
			sb.append("#").append(test).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	//2개 구역으로 나누는 부분집합의 모든 경우의 수
	private static void subset(int srcIdx) {
		//재귀 호출 기저조건
		if(srcIdx == N+1) {
			//하나의 경우의 수가 완성
			//select 배열이 완성(각각 true 이거나 false)
			check();//이어지는 문제 풀이 조건체크 최소값 갱신
			return;
		}
		
		//true = A그룹
		select[srcIdx] = true;
		subset(srcIdx+1);
		//false = B그룹
		select[srcIdx] = false;
		subset(srcIdx+1);
	}

	private static void check() {
		//초기화
		//visit, q.clear
		Arrays.fill(visit, false);
		q.clear();
		
		//A
		//a 연결 확인
		for (int i = 1; i <= N; i++) {
			if(select[i]) {
				visit[i] = true;
				q.offer(i);
				break;
			}
		}
		
		if(q.size()==0) return;
		
		while(q.size()>0) {
			int v = q.poll();//3번 마을이라면 3번 마을에서 갈 수 있는 다른 마을을 찾아서 다시 큐에 담는다.
			
			for (int i = 1; i <= N; i++) {
				if(matrix[v][i]==1) {
					int adj = i;
					if(adj != 0 && !visit[adj] && select[adj]) {
						visit[adj] = true;
						q.offer(adj);
					}
				}
			}
		}
		//B
		for (int i = 1; i <= N; i++) {
			if(!select[i]) {
				visit[i] = true;
				q.offer(i);
				break;
			}
		}
		
		if(q.size()==0) return;
		
		while(q.size()>0) {
			int v = q.poll();//3번 마을이라면 3번 마을에서 갈 수 있는 다른 마을을 찾아서 다시 큐에 담는다.
			
			for (int i = 1; i <= N; i++) {
				if(matrix[v][i]==1) {
					int adj = i;
					if(adj != 0 && !visit[adj] && !select[adj]) {
						visit[adj] = true;
						q.offer(adj);
					}
				}
			}
		}
		//최종적으로 visit 배열이 모두 true 가 되면 A, B 모두 연결
		//위 조건에 한해서 인구수의 차이를 계산 => 최소값 갱신
		for (int i = 1; i <= N; i++) {
			if(!visit[i])return;
		}
		
		//두 개의 그룹이 모든 마을이 연결
		int sumA = 0;
		int sumB = 0;
		
		for (int i = 1; i <= N; i++) {
			if(select[i]) sumA+=matrix[i][0];
			else sumB+=matrix[i][0];
		}
		
		min = Math.min(min, Math.abs(sumA-sumB));
	}
}

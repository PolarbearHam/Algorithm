import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Solution {
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, -1, 1, 0 };
	static Queue<int[]> q = new ArrayDeque<>();
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		int n = 3;
		int m = 3;
		long[][] a = { { 1, 4, 5 }, { 3, 8, 2 }, { 10, 0, 6 } };
		String[] kor = {"AAA","BCD", "AAAAA", "ZY"};
		String[] usa = {"AB", "AA", "TTTT"};
		String[] incs = {"BCD AAA", "AB AAA TTTT BCD", "AA AAAAA AB", "AAA AB BCD"};
		
		System.out.println(solution(n, m, a));
		System.out.println(solution("1234567"));
		System.out.println(solution(kor, usa, incs));
	}
	public static int solution(String[] kor, String[] usa, String[] incs) {
		int answer = -1;
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < kor.length; i++) {
			for(int j=0; j<usa.length; j++) {
				map.put(kor[i], usa[j]);
				int sum = 0 ;
				for (int k = 0; k < incs.length; k++) {
					StringTokenizer st = new StringTokenizer(incs[k], " ");
					while(st!=null) {
						
					}
				}
			}
		}
		System.out.println(map.get(kor[0]));
		for (int i = 0; i < incs.length; i++) {
			
		}
		return answer;
	}
	public static int[] solution(String[][] folders, String[][] files, String[] selected, String[] excepted) {
		int[] answer = {};
		int sum = 0;
		int count = 0 ;
		HashMap<String, String> folder = new HashMap<>();
		for (int i = 0; i < folders.length; i++) {
			folder.put(folders[i][0], folders[i][1]);
		}
		HashMap<String, String[]> file = new HashMap<>();
		for (int i = 0; i < files.length; i++) {
			String[] srr = {files[i][1], files[i][2]};
			file.put(files[i][0], srr);
		}
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<selected.length; i++) {
			list.add(selected[i]);
			for(String key : folder.keySet()) {
				if(selected[i].equals(folder.get(key))) {
					list.add(key);
				}
			}
		}
		ArrayList<String> except = new ArrayList<>();
		for(int i=0; i<excepted.length; i++) {
			except.add(excepted[i]);
		}
		
		for (int i = 0; i < list.size(); i++) {
			for(String key : file.keySet()) {
				if(file.get(key)[1].equals(list.get(i))){
					int len = file.get(key)[0].length();
					if(except.contains(key)) {}
					else if(file.get(key)[0].charAt(len-1)=='B') {
						if(len>3&&file.get(key)[0].charAt(len-2)=='K') {
							sum += Integer.parseInt(file.get(key)[0].substring(0, len-3))*1024;
							count++;
						}else {
							sum += Integer.parseInt(file.get(key)[0].substring(0, len-2));
							count++;
						}
					}
				}
			}
		}
		answer[0] = sum;
		answer[1] = count;
		return answer;
	}
	

	public static long solution(int n, int m, long[][] a) {
		long answer = 0;

		for (int i = 0; i < n; i++) {
			visited = new boolean[n][m];
			q.add(new int[] { i, 0 });
			visited[i][0] = true;

			answer = Math.max(bfs(i, a, n, m), answer);
		}

		return answer;
	}

	public static long bfs(int l, long[][] a, int n, int m) {
		long sum = a[l][0];

		while (q.size() > 0) {
			int[] rc = q.poll();
			for (int i = 0; i < 3; i++) {
				int nr = rc[0] + dr[i];
				int nc = rc[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (visited[nr][nc])
					continue;
				int count = 0;
				for (int j = 0; j < 4; j++) {
					int sr = nr + dr[j];
					int sc = nc + dc[j];
					if (sr < 0 || sc < 0 || sr >= n || sc >= m)
						continue;
					if (visited[sr][sc])
						count++;
				}
				if (count >= 3)
					continue;
				sum += a[nr][nc];
				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });
				System.out.println(Arrays.toString(visited[0]));
			}
		}
		return sum;
	}

	public static int solution(String number) {
		int answer = 1;
		int i = 1;
		StringBuilder sb = new StringBuilder();
		if (number.length() == 1 && number.charAt(0) - 48 == 0)
			return 1;
		if (number.length() == 1 && number.charAt(0) - 48 != 0)
			return 2;

		for (int j = 0; j <= number.length(); j++) {
			sb.append(" ");
		}
		sb.setCharAt(0, number.charAt(0));
		sb.setCharAt(1, (char) (number.charAt(0) + 1));
		
		System.out.println(number);
		System.out.println(number.charAt(6));
		while (true) {
			if (sb.toString().substring(0, number.length()).equals(number.substring(0, number.length())))
				break;
			if (number.charAt(i) == sb.charAt(i)) {
			} else if (sb.charAt(i) == ' ') {
				sb.setCharAt(i, number.charAt(i));
				sb.setCharAt(i + 1, (char) (number.charAt(i) + 1));
				answer++;
			} else if (sb.charAt(i) != number.charAt(i)) {
				if (number.charAt(i) == '0') {
					sb.setCharAt(i, '0');
					answer++;
				} else {
					sb.setCharAt(i, number.charAt(i));
					sb.setCharAt(i + 1, (char) (number.charAt(i) + 1));
					answer += 2;
				}
			}
			i++;
		}
		System.out.println(sb.charAt(sb.length()-1));
		System.out.println(sb.length());
		System.out.println(number.length());
		if (sb.length() > number.length()&&sb.charAt(sb.length()-1)!=' ') {
			sb.deleteCharAt(number.length());
			answer++;
		}
		System.out.println(sb.toString());
		return answer;
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_3758 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 0; test<T; test++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());//number of teams
			int k = Integer.parseInt(st.nextToken());//number of problems
			int t = Integer.parseInt(st.nextToken());//my team number
			int m = Integer.parseInt(st.nextToken());//number of log entry
			
			Team[] list = new Team[n];
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int id = Integer.parseInt(st.nextToken());
				int number = Integer.parseInt(st.nextToken());
				int score = Integer.parseInt(st.nextToken());
				
				if(list[id-1]==null) {
					list[id-1] = new Team();
					list[id-1].id = id;
					list[id-1].scoreList = new int[k+1];
				}
				list[id-1].scoreList[number] = Math.max(score, list[id-1].scoreList[number]);
				list[id-1].submitNum++;
				list[id-1].lastSubmit = i;
			}
			for(int i=0; i<n; i++) {
				int sum = 0;
				for(int j=1; j<=k; j++) {
					sum += list[i].scoreList[j];
				}
				list[i].totalScore = sum;
			}
			Arrays.sort(list, new Comparator<Team>() {
				@Override
				public int compare(Team o1, Team o2) {
					if(o1.totalScore==o2.totalScore) {
						if(o1.submitNum==o2.submitNum) {
							return o1.lastSubmit-o2.lastSubmit;
						}
						return o1.submitNum-o2.submitNum;
					}
					return o2.totalScore-o1.totalScore;
				}
			});
			
			for(int i=0; i<n; i++) {
				if(list[i].id==t) {
					System.out.println(i+1);
					break;
				}
			}
		}

	}
	
	public static class Team{
		int id;
		int[] scoreList;
		int submitNum;
		int lastSubmit;
		int totalScore;
	}

}

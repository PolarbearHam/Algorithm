import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1268 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][5];
		boolean[][] list = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<5; i++) {
			ArrayList<Integer>[] temp = new ArrayList[10];
			for(int j=0; j<n; j++) {
				if(temp[arr[j][i]]==null) temp[arr[j][i]] = new ArrayList<>();
				temp[arr[j][i]].add(j);
			}
			
			for(int j=0; j<n; j++) {
				int num = arr[j][i];
				ArrayList<Integer> data = temp[num];
				
				for(int k=0; k<data.size(); k++) {
					if(j==data.get(k)) continue;
					list[j][data.get(k)] = true;
				}
			}
		}
		
		int max = 0;
		int index = 0;
		for(int i=0; i<n; i++) {
			int num = 0;
			for(int j=0; j<n; j++) {
				if(list[i][j]) num++;
			}
			if(max<num) {
				max = num;
				index = i;
			}
		}
		System.out.println(index+1);
		
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20529 {
	private static int distance(String p1, String p2, String p3) {
		int distance = 0;
		for(int i=0; i<4; i++) {
			distance += (p1.charAt(i) != p2.charAt(i)? 1 : 0);
			distance += (p2.charAt(i) != p3.charAt(i)? 1 : 0);
			distance += (p3.charAt(i) != p1.charAt(i)? 1 : 0);
		}
		return distance;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int cnt = 0;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = N >32? 33:N;
			String[] person = new String[max];
			for(int j=0; j<max; j++) person[j] = st.nextToken();
			int min = 12;
			end : for(int k=0; k<max; k++) {
				for(int l=k+1; l<max; l++) {
					for(int m=l+1;m<max; m++) {
						min = Math.min(min, distance(person[k], person[l], person[m]));
						if(min == 0) {
							break end;
						}
					}
				}
			}
			System.out.println(min);
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2920 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int last = Integer.parseInt(st.nextToken());
		int flag = 0;
		if(last==1) {
			for (int i = 0; i < 7; i++) {
				int now = Integer.parseInt(st.nextToken());
				if(last+1==now) {
					last = now;
				}else {
					System.out.println("mixed");
					flag=1;
					break;
				}
			}
			if(flag==0) {
				System.out.println("ascending");
				return;
			}
		}else if(last==8) {
			for (int i = 0; i < 7; i++) {
				int now = Integer.parseInt(st.nextToken());
				if(last-1==now) {
					last = now;
				}else {
					System.out.println("mixed");
					flag=1;
					break;
				}
			}
			if(flag==0) {
				System.out.println("descending");
				return;
			}
		}else {
			System.out.println("mixed");
		}
		
	}
}

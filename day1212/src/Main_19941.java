import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19941 {
	static char[] crr;
	static int answer =0;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		crr = br.readLine().toCharArray();
		
		for(int i=0; i<N; i++) {
			if(crr[i]=='P') {
				int index = Math.max(i-K, 0);
				boolean check = false;
				for(int j=index; j<i; j++) {
					if(burgerCheck(j)) {
						check = true;
						break;
					}
				}
				if(!check) {
					index = i+K >= N? N-1 : i+K;
					for(int j=i+1; j<=index; j++) {
						if(burgerCheck(j)) break;
					}
				}
			}
		}
		System.out.println(answer);
	}
	
	static boolean burgerCheck(int index) {
		if(crr[index]=='H') {
			crr[index]='X';
			answer++;
			return true;
		}
		return false;
	}
}

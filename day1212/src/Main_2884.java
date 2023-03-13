import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2884 {
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if(M-45<0) {
			if(H-1<0) H = 23;
			else H = H-1;
			M = (60-45+M)%60;
		}else {
			M = M-45;
		}
		System.out.println(H+" "+M);
	}
}

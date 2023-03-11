import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2562 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int idx = 0;
		for(int i=0; i<9; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(max<temp) {
				max = temp;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx+1);
	}
}

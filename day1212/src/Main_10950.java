import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10950 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int answer = Integer.parseInt(st.nextToken());
			System.out.println(answer+Integer.parseInt(st.nextToken()));
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2448 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] map = new String[N];
		map[0] = "  *  ";
		map[1] = " * * ";
		map[2] = "*****";
		
		for (int i = 1; 3*(int)Math.pow(2, i) <= N; i++) {
			makeBigStar(i, map);
		}
		for (int i = 0; i < N; i++) {
			System.out.println(map[i]);
		}
	}
	
	static void makeBigStar(int k, String[] map) {
		int bottom = 3*(int)Math.pow(2, k);
		int middle = bottom/2;
		
		for (int i = middle; i < bottom; i++) {
			map[i] = map[i-middle]+" "+map[i-middle];
		}
		
		String space = "";
		while(space.length()<middle) {
			space+=" ";
		}
		for (int i = 0; i < middle; i++) {
			map[i] = space + map[i]+space;
		}
	}
}

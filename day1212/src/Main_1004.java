import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1004 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test=0; test<T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			int through = 0;
			
			
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				boolean hasStartContain = hasContain(startX, startY, x, y, r);
				boolean hasEndContain = hasContain(endX, endY, x, y, r);
				
				if(!(hasStartContain&&hasEndContain) && (hasStartContain || hasEndContain)){
					through++;
				}
			}
			System.out.println(through);
		}
		
	}


	private static boolean hasContain(int xo, int yo, int x, int y, int r) {
		return Math.sqrt(Math.pow(xo-x, 2)+Math.pow(yo-y, 2))<r;
	}
}

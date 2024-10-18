import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25206 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		double score=0;
		double mul=0;
		String trash;
		for(int i=0; i<20; i++) {
			st = new StringTokenizer(br.readLine());
			trash = st.nextToken();
			double s = Double.parseDouble(st.nextToken());
			trash = st.nextToken();
			switch(trash) {
			case "A+":
				mul += s*4.5;
				score += s;
				break;
			case "A0":
				mul += s*4.0;
				score += s;
				break;
			case "B+":
				mul += s*3.5;
				score += s;
				break;
			case "B0":
				mul += s*3.0;
				score += s;
				break;
			case "C+":
				mul += s*2.5;
				score += s;
				break;
			case "C0":
				mul += s*2.0;
				score += s;
				break;
			case "D+":
				mul += s*1.5;
				score += s;
				break;
			case "D0":
				mul += s*1.0;
				score += s;
				break;
			case "P":
				break;
			case "F":
				mul += s*0;
				score += s;
				break;
			}
		}
		System.out.printf("%.04f", mul/score);

	}

}

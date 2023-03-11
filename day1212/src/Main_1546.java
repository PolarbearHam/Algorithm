import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1546 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]>max) max=(int)arr[i];
		}
		
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i]/max*100;
		}
		double avg=0;
		for (int i = 0; i < N; i++) {
			avg+=arr[i];
		}
		System.out.println(avg/N);
	}
}

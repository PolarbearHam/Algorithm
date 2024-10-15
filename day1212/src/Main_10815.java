import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815 {
	static int[] nArr, mArr;
	static int N=0, M=0;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		nArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nArr);
		
		M = Integer.parseInt(br.readLine());
		mArr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<M; i++) {
			sb.append(find(mArr[i])+" ");	
		}
		
		System.out.println(sb);
		

	}
	public static int find(int target) {
		int left = 0;
		int right = N-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			int midValue = nArr[mid];
			
			if(target>midValue) {
				left = mid+1;
			}else if(target<midValue) {
				right = mid-1;
			}else return 1;
		}
		return 0;
		
	}

}

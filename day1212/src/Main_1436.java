import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1436 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		
		int num = 666;
		int count=1;
		while(count!=a) {
			num++;
			if(String.valueOf(num).contains("666"))count++;
		}
		System.out.println(num);
	}
}

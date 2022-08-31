package day0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1244_스위치켜고끄기_함형준_144ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 스위치 개수
		char[] swi = br.readLine().replace(" " , "").toCharArray(); // 스위치 상태
		
		int n = Integer.parseInt(br.readLine()); //학생 수
		//남 : 1  | 여 : 2
		//학생 수 n만큼 반복
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken()); // 성별
			int k = Integer.parseInt(st.nextToken()); // 학생이 받은 수 

			switch(s) {
			case 1: //남학생
				//배수 돌아야하니까
				// j += 받은 수
				for (int j = k; j <= swi.length; j += k) {
					change(j-1, swi);  // 스위치 - 1 = 배열 인덱스이므로
				}
				break;
				
			case 2: //여학생
				k--; // 스위치 - 1 = 배열 인덱스이므로
				change(k, swi);
				int num = (k < Math.abs(swi.length-1 - k) ? k : Math.abs(swi.length - k - 1));
				
                if(k > 0 && k < swi.length - 1) {
    				//기준 + j 비교하니까 1부터
					for (int j = 1; j <= num; j++) {
						//둘이 같으면
						if(swi[k - j] == swi[k + j]) {
							change(k-j, swi);
							change(k+j, swi);
							continue;
						}else {
							//둘이 다르면 멈추기
							break;
						}
					}
                }
				
			}
		}
        //한 줄에 20개씩 출력
		for (int i = 0; i < swi.length; i++) {
			System.out.print(swi[i] + " ");
			if((i+1) % 20 == 0) {
				System.out.println();
			}
		}
	}
	
	//1 -> 0
	//0 -> 1
	static void change(int i, char[] swi) {
		if(swi[i]=='1') swi[i] ='0';
		else swi[i] = '1';
	}
}

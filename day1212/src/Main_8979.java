import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_8979 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Country> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			
			list.add(new Country(number, gold, silver, bronze, 0));
		}
		Collections.sort(list);
		int rate = 1;
		int cnt =1;
		if(list.get(0).number==K) {
			System.out.println(1);
			return ;
		}
		for(int i=1; i<N; i++) {
			Country prev = list.get(i-1);
			Country cur = list.get(i);
			
			if((prev.gold != cur.gold) || (prev.silver!=cur.silver) || (prev.bronze != cur.bronze)) {
				rate += cnt;
				cnt = 1;
			}else {
				cnt++;
			}
			if(cur.number==K) {
				System.out.println(rate);
				break;
			}
		}
	}
	
	public static class Country implements Comparable<Country>{
		int number;
		int gold;
		int silver;
		int bronze;
		int rate;
		public Country(int number, int gold, int silver, int bronze, int rate) {
			this.number = number;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.rate = rate;
		}
		
		@Override
		public int compareTo(Country o) {
			if(this.gold==o.gold) {
				if(this.silver==o.silver) {
					return o.bronze-this.bronze;
				}else {
					return o.silver-this.silver;
				}
			}else {
				return o.gold-this.gold;
			}
		}
	}
}

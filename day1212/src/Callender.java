import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Callender {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		Map<Integer, Integer> days = new HashMap<Integer, Integer>();
		
		int year = now.getYear();
		int month = now.getMonthValue();
		if(month==2) {
			if((year%4==0)&&(year%100!=0)||(year%400)==0) days.put(2, 29);
			else days.put(2, 28);
		}
		days.put(1, 31);
		days.put(3, 31);
		days.put(5, 31);
		days.put(7, 31);
		days.put(8, 31);
		days.put(10, 31);
		days.put(12, 31);
		days.put(4, 30);
		days.put(6, 30);
		days.put(9, 30);
		days.put(11, 30);
		System.out.println("현재 달의 날수는 "+days.get(month));
	}
}

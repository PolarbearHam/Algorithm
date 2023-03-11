import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main_1302 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = new String();
		HashMap<String, Integer> list = new HashMap<>();
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			if(list.containsKey(s)) {
				list.replace(s, list.get(s)+1);
			}else {
				list.put(s, 1);
			}
		}
		int max = 0;
		for (String a : list.keySet()) {
			max = Math.max(max, list.get(a));
		}
		
		ArrayList<String> al = new ArrayList<>(list.keySet());
		Collections.sort(al);
		for (String a : al) {
			if(list.get(a)==max) {
				System.out.println(a);
				break;
			}
		}
	}

}

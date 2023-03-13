import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st;
			TreeMap<Integer, Integer> tree = new TreeMap<>();
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				String op = st.nextToken();
				int a = 0;

				switch (op) {
				case "I":
					a = Integer.parseInt(st.nextToken());
					tree.put(a, tree.getOrDefault(a, 0) + 1);
					break;
				case "D":
					if (tree.size() > 0) {
						a = Integer.parseInt(st.nextToken()) == 1 ? tree.lastKey() : tree.firstKey();
						if (tree.put(a, tree.get(a) - 1) == 1)
							tree.remove(a);
					}
					break;
				}
			}
			if (tree.size() == 0)
				System.out.println("EMPTY");
			else
				System.out.println(tree.lastKey()+" "+tree.firstKey());
		}
	}
}

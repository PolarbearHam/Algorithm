package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_백준_1786_찾기_P5_함형준_528ms {
	static int search, count;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		list = new ArrayList<Integer>();
		kmp(T, P);

//		sb.insert(0, count).insert(1, "\n");
		sb.append(count).append("\n");
		for (int i = 0; i < count; i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}

	static int[] makeTable(String pattern) {
		int n = pattern.length();
		int[] table = new int[n];
		int idx = 0;
		for (int i = 1; i < n; i++) {
			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(idx)) {
				idx += 1;
				table[i] = idx;
			}
		}
		return table;
	}

	static void kmp(String parent, String pattern) {
		int[] table = makeTable(pattern);
		int n1 = parent.length();
		int n2 = pattern.length();

		int idx = 0;
		for (int i = 0; i < n1; i++) {
			while (idx > 0 && parent.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			if (parent.charAt(i) == pattern.charAt(idx)) {
				if (idx == n2 - 1) {
					count++;
					list.add(i-idx+1);
//					sb.append(i - idx + 1).append(" ");
					idx = table[idx];
				} else {
					idx += 1;
				}
			}
		}
	}
}

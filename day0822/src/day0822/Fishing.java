package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fishing {
	static class Gate{
		int pos;
		int fisher;
		public Gate(int pos, int fisher) {
			super();
			this.pos = pos;
			this.fisher = fisher;
		}
	}
	static int N;
	static Gate[] gates;
	static int min, fisherCount;
	static boolean[] selected;
	static int[] map;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	static void dfs(int cnt, int sum) {
		if(sum>=min) return;
		if(cnt==3) {
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			if(selected[i])continue;
			selected[i] = true;
			dfs(cnt+1, sum + inFisher(i, gates[i].fisher, true));
			outFisher(i);
			
			if(gates[i].fisher % 2 == 0) {
				dfs(cnt+1, sum+inFisher(i, gates[i].fisher, false));
				outFisher(i);
			}
			
			selected[i] = false;
		}
	}
	
	static int inFisher(int idx, int fisher, boolean flag) {
		int distance = 0;
		fisherCount = 0;
		int sum = 0;
		
		while(fisherCount < fisher) {
			sum += flag? left(idx, distance) : right(idx, distance);
			if(fisherCount == fisher) break;
			sum += flag? right(idx, distance) : left(idx, distance);
			distance++;
		}
		
		return sum;
	}
	
	static int left(int idx, int distance) {
		int left = gates[idx].pos - distance;
		
		if(left>0 && map[left]==0) {
			map[left] = idx;
			fisherCount++;
			return distance+1;
		}
		return 0;
	}
	static int right(int idx, int distance) {
		int right = gates[idx].pos + distance;
		if(right<=map.length && map[right]==0) {
			map[right] = idx;
			fisherCount++;
			return distance + 1;
		}
		return 0;
	}
	static void outFisher(int idx) {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(map[i]==idx) {
				map[i] = 0;
				cnt++;
			}
			if(cnt==gates[idx].fisher) return;
		}
	}
}

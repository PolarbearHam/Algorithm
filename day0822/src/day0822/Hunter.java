package day0822;

import java.util.ArrayList;

public class Hunter {
	static int N;
	static ArrayList<Node> monsters;
	static ArrayList<Node> customers;
	static boolean[] visitedMonsters;
	static boolean[] visitedCustomers;
	static int min;
	
	static class Node{
		int r;
		int c;
		int n;
		public Node(int r, int c, int n) {
			super();
			this.r = r;
			this.c = c;
			this.n = n;
		}
	}
	
	public static void main(String[] args) {
		//manhatan 1,1=>4,3 (4-1)+(3-1) = 5
		
	}
	static void dfs(int cnt, int distance, int r, int c) {
		if(distance>=min) return;
		if(cnt== monsters.size()*2) {
			min = Math.min(min, distance);
		}
		
		for (Node monster : monsters) {
			if(visitedMonsters[monster.n]) continue;
			int d = getDistance(monster.r, monster.c, r, c);
			visitedMonsters[monster.n] = true;
			dfs(cnt+1, distance+d, monster.r, monster.c);
			visitedMonsters[monster.n] = false;
		}
		
		for (Node customer : customers) {
			int n = Math.abs(customer.n);
			if(visitedCustomers[n]||!visitedMonsters[n]) continue;
			
			int d = getDistance(customer.r, customer.c, r, c);
			visitedCustomers[n] = true;
			dfs(cnt+1, distance+d, customer.r, customer.c);
			visitedCustomers[n] = false;
		}
	}
	static int getDistance(int nr, int nc, int r, int c) {
		return Math.abs(nr-r) + Math.abs(nc-c);
	}
}

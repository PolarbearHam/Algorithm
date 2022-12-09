import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_알고스탁 {
	static int T, Ms, Ma, N, L, money, maxBenefit;
	static int[][] val;
	static List<Stock> stockList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Ms = Integer.parseInt(st.nextToken());
			Ma = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			val = new int[N][L+1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j <= L; j++) {
					val[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			money = Ms;
			
			for (int i = 0; i < L; i++) {
				stockList.clear();
				for (int j = 0; j < N; j++) {
					if(val[j][i+1]>val[j][i]) {
						stockList.add(new Stock(val[j][i], val[j][i+1], val[j][i+1]-val[j][i]));
					}
				}
				maxBenefit = 0;
				
				if(stockList.size()==1) {
					Stock s = stockList.get(0);
					maxBenefit = money / s.nowVal * s.diff;
				}else if(stockList.size()>1) {
					dfs(0, money, 0);
				}
				
				money+=maxBenefit;
				
				money+=Ma;
			}
			int ans = money-(Ms+Ma*L);
			sb.append("#").append(test).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static void dfs(int idx, int money, int benefit) {
		if(idx==stockList.size()) {
			maxBenefit = Math.max(maxBenefit, benefit);
			return;
		}
		
		Stock stock = stockList.get(idx);
		
		dfs(idx+1, money, benefit);
		
		if(money-stock.nowVal>=0) {
			dfs(idx, money-stock.nowVal, benefit+stock.diff);
		}
	}
	
	static class Stock{
		int nowVal, diff, nextVal;
		public Stock(int nowVal, int nextVal, int diff) {
			this.nowVal = nowVal;
			this.nextVal = nextVal;
			this.diff = diff;
		}
		
	}
}

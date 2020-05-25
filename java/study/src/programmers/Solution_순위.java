package programmers;

public class Solution_¼øÀ§ {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] {
			{4, 3},
			{4, 2},
			{3, 2},
			{1, 2},
			{2, 5}
		}));
	}
	
	static int max = 10000;
	public static int solution(int n, int[][] results) {
		int[][] G = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i == j) G[i][j] = 0;
				else G[i][j] = max;
			}
		}
		
		for (int i = 0; i < results.length; i++) {
			G[results[i][0]][results[i][1]] = 1;
		}
		
		for (int v = 1; v <= n; v++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					G[i][j] = G[i][j] < G[i][v] + G[v][j] ? G[i][j] : G[i][v] + G[v][j];
				}
			}
		}
		
		int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			boolean flag = true;
			for (int j = 1; j <= n; j++) {
				if(G[i][j] == max && G[j][i] == max) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				answer++;
			}
		}
		
		return answer;
	}
}

package programmers;


public class Solution_2nŸ�ϸ� {
	public static void main(String[] args) {
		System.out.println(solution(4));
	}
	
	public static int solution(int n) {
		if(n == 1) {
			return 1;
		} else if(n == 2) {
			return 2;
		}
		
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
		}
		
		return dp[n];
	}
}

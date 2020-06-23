package programmers;

public class Solution_타일장식물 {
	public static void main(String[] args) {
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(80));
	}
	
	public static long solution(int N) {
		long[] dp = new long[N + 1];
		
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		return dp[N] * 4 + dp[N - 1] * 2;
	}
}

package programmers;

public class Solution_예산 {
	/**
	 * 처음에 min을 배열의 가장 작은 값으로 지정해서 구현
	 * 하지만 테스트케이스 9번이 계속 틀림
	 * 그래서 min을 그냥 0으로 바꾸니까 통과됨
	 * 아마도 배열의 모든 값보다 작은 값이 답이였던 것 같음
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[] {120, 110, 140, 150}, 485));
	}
	
	static int answer;
	public static int solution(int[] budgets, int M) {
		// 1. 모든 요청이 배정될수 있는지 확인한다.
		int min = 0;
		int max = 0;
		long sum = 0;
		
		for (int i = 0; i < budgets.length; i++) {
			sum += budgets[i];
			max = budgets[i] > max ? budgets[i] : max;
		}
		
		// 2-1. 배정될 수 있다면 가장 높은 값을 리턴한다.
		if(sum <= M) {
			return max;
		}
		
		// 2-2. 배정될 수 없다면 이분탐색을 이용해 최대의 상한선을 구한다.
		answer = 0;
		function(min, max, budgets, M);
		
		return answer;
	}
	
	static void function(int min, int max, int[] budgets, int M) {
		if(min <= max) {
			// 상한선을 구한다.
			int mid = (min + max) / 2;
			
			long sum = 0;
			
			for (int i = 0; i < budgets.length; i++) {
				sum += budgets[i] < mid ? budgets[i] : mid;
			}
			
			if(sum <= M) {
				answer = mid > answer ? mid : answer;
				function(mid + 1, max, budgets, M);
			} else {	// sum > M
				function(min, mid - 1, budgets, M);
			}
		}
		
	}
}

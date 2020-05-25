package programmers;

public class Solution_���� {
	/**
	 * ó���� min�� �迭�� ���� ���� ������ �����ؼ� ����
	 * ������ �׽�Ʈ���̽� 9���� ��� Ʋ��
	 * �׷��� min�� �׳� 0���� �ٲٴϱ� �����
	 * �Ƹ��� �迭�� ��� ������ ���� ���� ���̿��� �� ����
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[] {120, 110, 140, 150}, 485));
	}
	
	static int answer;
	public static int solution(int[] budgets, int M) {
		// 1. ��� ��û�� �����ɼ� �ִ��� Ȯ���Ѵ�.
		int min = 0;
		int max = 0;
		long sum = 0;
		
		for (int i = 0; i < budgets.length; i++) {
			sum += budgets[i];
			max = budgets[i] > max ? budgets[i] : max;
		}
		
		// 2-1. ������ �� �ִٸ� ���� ���� ���� �����Ѵ�.
		if(sum <= M) {
			return max;
		}
		
		// 2-2. ������ �� ���ٸ� �̺�Ž���� �̿��� �ִ��� ���Ѽ��� ���Ѵ�.
		answer = 0;
		function(min, max, budgets, M);
		
		return answer;
	}
	
	static void function(int min, int max, int[] budgets, int M) {
		if(min <= max) {
			// ���Ѽ��� ���Ѵ�.
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

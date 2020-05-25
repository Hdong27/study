package programmers;

public class Solution_�Ա��ɻ� {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {7, 10}));
	}
	
	public static long solution(int n, int[] times) {
		long min = 1;
		long max = 0;
		
		// �ִ� �ð� max ���ϱ�
		for (int i = 0; i < times.length; i++) {
			max = times[i] > max ? times[i] : max;
		}
		
		max *= n;
		long answer = max;
		
		while(min <= max) {
			long mid = (min + max) / 2;
			
			// mid ��ŭ�� �ð����� ó���� �� �ִ��� Ȯ���Ѵ�.
			long count = 0;
			
			for (int i = 0; i < times.length; i++) {
				count += mid / times[i];
			}
			
			if(count >= n) {
				answer = mid < answer ? mid : answer;
				max = mid - 1;
			} else {	// count < n
				min = mid + 1;
			}
		}
		
		return answer;
	}
}

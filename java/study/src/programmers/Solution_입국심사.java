package programmers;

public class Solution_입국심사 {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {7, 10}));
	}
	
	public static long solution(int n, int[] times) {
		long min = 1;
		long max = 0;
		
		// 최대 시간 max 구하기
		for (int i = 0; i < times.length; i++) {
			max = times[i] > max ? times[i] : max;
		}
		
		max *= n;
		long answer = max;
		
		while(min <= max) {
			long mid = (min + max) / 2;
			
			// mid 만큼의 시간으로 처리할 수 있는지 확인한다.
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

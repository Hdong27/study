package programmers;

import java.util.Arrays;

public class Solution_Â¡°Ë´Ù¸® {
	public static void main(String[] args) {
		System.out.println(solution(25, new int[] {2, 14, 11, 21, 17}, 2));
	}
	
	public static int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		
		int answer = 0;
		int left = 1;
		int right = distance;
		
		while(left <= right) {
			int cnt = 0;
			int prev = 0;
			int mid = (left + right) / 2;
			
			for (int i = 0; i < rocks.length; i++) {
				if(rocks[i] - prev < mid) {
					cnt++;
				} else {
					prev = rocks[i];
				}
			}
			
			if(distance - prev < mid) cnt++;
			
			if(cnt <= n) {
				answer = mid > answer ? mid : answer;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return answer;
	}
}

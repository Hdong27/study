package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_라면공장 {
	public static void main(String[] args) {
		System.out.println(solution(4, new int[] {4, 10, 15}, new int[] {20, 5, 10}, 30));
	}
	
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		
		int[] arr = new int[k + 1];
		
		for (int i = 0; i < dates.length; i++) {
			arr[dates[i]] = supplies[i];
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		int index = 0;
		for (int i = 0; i < k; i++) {
			if(stock == 0) {
				for (int j = index; j <= i; j++) {
					pq.add(arr[j]);
				}
				index = i + 1;
				stock += pq.poll();
				answer++;
			}
			
			stock--;
		}
		
		return answer;
	}
}

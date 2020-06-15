package programmers;

import java.util.PriorityQueue;

public class Solution_´õ¸Ê°Ô {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {
			1, 2, 3, 9, 10, 12	
		}, 7));
	}
	
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
		
		int answer = 0;
		
		while(pq.size() > 1 && pq.peek() < K) {
			answer++;
			
			pq.add(pq.poll() + pq.poll() * 2);
		}
		
		return pq.peek() < K ? -1 : answer;
	}
}

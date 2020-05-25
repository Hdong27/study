package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_이중우선순위큐 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {
				"I 16","D 1"
		})));
		System.out.println(Arrays.toString(solution(new String[] {
				"I 7","I 5","I -5","D -1"
		})));
	}
	
	public static int[] solution(String[] operations) {
		PriorityQueue<Integer> pqMax = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		PriorityQueue<Integer> pqMin = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		int countMax = 0;
		int countMin = 0;
		
		for (int i = 0; i < operations.length; i++) {
			StringTokenizer st = new StringTokenizer(operations[i], " ");
			
			if(st.nextToken().equals("I")) {
				int number = Integer.parseInt(st.nextToken());
				
				pqMax.add(number);
				pqMin.add(number);
				
			} else {	// == "D"
				int com = Integer.parseInt(st.nextToken());
				
				if(com == 1) {
					// 최댓값 삭제
					if(pqMax.isEmpty()) continue;
					
					pqMax.poll();
					countMax++;
				} else {	// com == -1
					// 최솟값 삭제
					if(pqMin.isEmpty()) continue;
					
					pqMin.poll();
					countMin++;
				}
			}
			
			if(pqMax.size() == countMin) {
				countMin = 0;
				
				while(!pqMax.isEmpty()) {
					pqMax.poll();
				}
			}
			
			if(pqMin.size() == countMax) {
				countMax = 0;
				
				while(!pqMin.isEmpty()) {
					pqMin.poll();
				}
			}
		}
		
		int[] answer = new int[] {pqMax.isEmpty() ? 0 : pqMax.poll(), pqMin.isEmpty() ? 0 : pqMin.poll()};
		
		return answer;
	}
}

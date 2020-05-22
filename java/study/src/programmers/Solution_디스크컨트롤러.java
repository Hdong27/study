package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_디스크컨트롤러 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {
			{1, 9},
			{0, 3},
			{2, 6}
		}));
	}
	
	public static int solution(int[][] jobs) {
		// jobs를 시작 시간 순으로 정렬한다.
		Arrays.sort(jobs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// 작업시간이 가장 짧은 순으로 정렬하는 우선순위 큐를 만든다.
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int index = 0;
		int time = 0;	// 현재 시간
		
		int answer = 0;
		
		// 모든 작업을 완료할때 까지 반복한다.
		while(true) {
			// 현재 시간보다 시작 시점이 앞서면 pq에 넣는다.
			while(index < jobs.length && jobs[index][0] <= time) {
				pq.add(new int[] {jobs[index][0], jobs[index][1]});
				index++;
			}
			
			// pq의 가장 앞에 있는 작업을 진행한다.
			if(!pq.isEmpty()) {
				int[] temp = pq.poll();
				time += temp[1];
				answer += time - temp[0];
			} else {
				if(index >= jobs.length) break;
				else time++;
			}
		}
		
		return answer / jobs.length;
	}
	
}

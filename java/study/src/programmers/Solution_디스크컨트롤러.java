package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_��ũ��Ʈ�ѷ� {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {
			{1, 9},
			{0, 3},
			{2, 6}
		}));
	}
	
	public static int solution(int[][] jobs) {
		// jobs�� ���� �ð� ������ �����Ѵ�.
		Arrays.sort(jobs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// �۾��ð��� ���� ª�� ������ �����ϴ� �켱���� ť�� �����.
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int index = 0;
		int time = 0;	// ���� �ð�
		
		int answer = 0;
		
		// ��� �۾��� �Ϸ��Ҷ� ���� �ݺ��Ѵ�.
		while(true) {
			// ���� �ð����� ���� ������ �ռ��� pq�� �ִ´�.
			while(index < jobs.length && jobs[index][0] <= time) {
				pq.add(new int[] {jobs[index][0], jobs[index][1]});
				index++;
			}
			
			// pq�� ���� �տ� �ִ� �۾��� �����Ѵ�.
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

package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution_기능개발 {
	public static void main(String[] args) {
		
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int index = 0;
		
		List<Integer> list = new ArrayList<>();
		while(index < progresses.length) {
			// 개발
			for (int i = 0; i < progresses.length; i++) {
				if(progresses[i] >= 100) continue;
				progresses[i] += speeds[i];
			}
			
			int count = 0;
			// 배포 가능여부
			while(index < progresses.length && progresses[index] >= 100) {
				count++;
				index++;
			}
			
			if(count > 0) list.add(count);
		}
		
		int[] answer = new int[list.size()];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}

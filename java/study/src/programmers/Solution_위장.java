package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_¿ß¿Â {
	public static void main(String[] args) {
		
	}
	
	public static int solution(String[][] clothes) {
		Map<String, List<String>> hm = new HashMap<>();
		
		for (int i = 0; i < clothes.length; i++) {
			if(!hm.containsKey(clothes[i][1])) {
				hm.put(clothes[i][1], new ArrayList<>());
			}
			hm.get(clothes[i][1]).add(clothes[i][0]);
		}
		
		int answer = 1;
		
		for (String key : hm.keySet()) {
			answer += hm.get(key).size() + 1;
		}
		
		return answer - 1;
	}
}

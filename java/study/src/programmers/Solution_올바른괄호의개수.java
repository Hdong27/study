package programmers;

import java.util.HashSet;
import java.util.Set;

public class Solution_올바른괄호의개수 {
	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(7));
		System.out.println(solution(8));
		System.out.println(solution(9));
		System.out.println(solution(10));
		System.out.println(solution(11));
		System.out.println(solution(12));
		System.out.println(solution(13));
		System.out.println(solution(14));
	}
	
	static Set<String> hs;
	public static int solution(int n) {
		hs = new HashSet<>();
		
		dfs(n - 1, n - 1, "(");
		
		return hs.size();
	}
	
	public static void dfs(int left, int right, String s) {
		if(left == 0 && right == 0) {
			s += ")";
			
			if(isPossible(s)) {
				hs.add(s);
			}
			return;
		}
		
		if(left > 0) dfs(left - 1, right, s + "(");
		if(right > 0) dfs(left, right - 1, s + ")");
	}
	
	public static boolean isPossible(String s) {
		char[] stack = new char[s.length() + 1];
		int top = -1;
		
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			
			if(temp == '(') {
				stack[++top] = '(';
			} else {
				if(top < 0) {
					return false;
				}
				
				top--;
			}
		}
		
		if(top > -1) {
			return false;
		}
		
		return true;
	}
}

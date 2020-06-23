package programmers;

public class Solution_¼è¸·´ë±â {
	public static void main(String[] args) {
		System.out.println(solution("()(((()())(())()))(())"));
	}
	
	public static int solution(String arrangement) {
		int answer = 0;
		
		char[] stack = new char[arrangement.length()];
		int top = -1;
		
		boolean flag = true;
		
		for (int i = 0; i < arrangement.length(); i++) {
			char temp = arrangement.charAt(i);
			
			if(temp == '(') {
				stack[++top] = '(';
				flag = true;
			} else {
				if(flag) {
					top--;
					answer += top + 1;
				} else {
					top--;
					answer++;
				}
				flag = false;
			}
		}
		
		return answer;
	}
}

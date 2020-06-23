package programmers;

public class Solution_큰수만들기 {
	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
		System.out.println(solution("987654321", 5));
	}
	
	public static String solution(String numbers, int k) {
		StringBuilder sb = new StringBuilder();
		
		int left = 0;
		int right = k;	// 뒤로 한칸 씩만 이동
		
		while(sb.length() < numbers.length() - k) {
			int max = -1;
			int maxIndex = 0;
			
			for (int i = left; i <= right; i++) {
				if(max < numbers.charAt(i) - '0') {
					max = numbers.charAt(i) - '0';
					maxIndex = i;
				}
			}
			
			sb.append(max);
			left = maxIndex + 1;
			right++;
		}
		
		return sb.toString();
	}
}

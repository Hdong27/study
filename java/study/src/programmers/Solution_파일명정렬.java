package programmers;

import java.util.Arrays;

public class Solution_파일명정렬 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {
				"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
		})));
		System.out.println(Arrays.toString(solution(new String[] {
				"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
		})));
	}
	
	public static String[] solution(String[] files) {
		File[] arr = new File[files.length];
		
		for (int i = 0; i < arr.length; i++) {
			String temp = files[i];
			
			String head = "";
			String number = "";
			head = temp.charAt(0) + "";
			boolean headFlag = false;
			for (int j = 1; j < temp.length(); j++) {
				if(headFlag) {	// head가 모두 작성됨
					if(temp.charAt(j) >= '0' && temp.charAt(j) <= '9') {
						number += temp.charAt(j);
					} else {
						break;
					}
				} else {	// head가 아직 작성 안됨
					if(temp.charAt(j) >= '0' && temp.charAt(j) <= '9') {
						number += temp.charAt(j);
						headFlag = true;	// head 완성
					} else {
						head += temp.charAt(j);
					}
				}
			}
			
			arr[i] = new File(temp, head, Integer.parseInt(number));
		}
		
		Arrays.sort(arr);
		
		String[] answer = new String[arr.length];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr[i].fullName;
		}
		
		return answer;
	}
	
	static class File implements Comparable<File>{
		String fullName;
		String head;
		int number;
		
		public File(String fullName, String head, int number) {
			this.fullName = fullName;
			this.head = head.toLowerCase();
			this.number = number;
		}

		@Override
		public int compareTo(File o) {
			// head 기준으로 정렬
			for (int i = 0; i < (this.head.length() < o.head.length() ? this.head.length() : o.head.length()); i++) {
				if(this.head.charAt(i) != o.head.charAt(i)) {
					return this.head.charAt(i) - o.head.charAt(i);
				}
			}
			
			// head의 길이로 정렬, 길이가 같으면 number 기준으로 정렬
			if(this.head.length() == o.head.length()) {
				return this.number - o.number;
			} else {
				return this.head.length() - o.head.length();
			}
			
		}
	}
}

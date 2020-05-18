package programmers;

import java.util.Arrays;

public class Solution_���ϸ����� {
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
				if(headFlag) {	// head�� ��� �ۼ���
					if(temp.charAt(j) >= '0' && temp.charAt(j) <= '9') {
						number += temp.charAt(j);
					} else {
						break;
					}
				} else {	// head�� ���� �ۼ� �ȵ�
					if(temp.charAt(j) >= '0' && temp.charAt(j) <= '9') {
						number += temp.charAt(j);
						headFlag = true;	// head �ϼ�
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
			// head �������� ����
			for (int i = 0; i < (this.head.length() < o.head.length() ? this.head.length() : o.head.length()); i++) {
				if(this.head.charAt(i) != o.head.charAt(i)) {
					return this.head.charAt(i) - o.head.charAt(i);
				}
			}
			
			// head�� ���̷� ����, ���̰� ������ number �������� ����
			if(this.head.length() == o.head.length()) {
				return this.number - o.number;
			} else {
				return this.head.length() - o.head.length();
			}
			
		}
	}
}

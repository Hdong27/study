package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_전화번호목록 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {
				"12", "123", "1235", "567", "88"
		}));
	}
	
	public static boolean solution(String[] phone_book) {
		
		Arrays.sort(phone_book, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		for (int i = 0; i < phone_book.length - 1; i++) {
			String temp = phone_book[i];
			int len = temp.length();
			for (int j = i + 1; j < phone_book.length; j++) {
				if(temp.equals(phone_book[j].substring(0, len))) {
					return false;
				}
			}
		}
		
		return true;
	}
}

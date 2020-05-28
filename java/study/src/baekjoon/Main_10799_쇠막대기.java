package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10799_¼è¸·´ë±â {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		
		char[] stack = new char[100001];
		int top = 0;
		boolean flag = true; // true : (, false : )
		int result = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			
			if(temp == '(') {
				flag = true;
				stack[++top] = '(';
			} else if(temp == ')') {
				if(flag) {
					top--;
					result += top;
				} else {
					top--;
					result++;
				}
				flag = false;
			}
		}
		
		System.out.println(result);
	}
}

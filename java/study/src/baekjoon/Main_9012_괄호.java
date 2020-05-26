package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9012_°ýÈ£ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 0; t < T; t++) {
			char[] stack = new char[51];
			int top = -1;
			
			String s = br.readLine().trim();
			
			boolean flag = true;
			for (int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);
				
				if(temp == '(') {
					stack[++top] = '(';
				} else if(temp == ')') {
					if(top < 0) {
						flag = false;
						break;
					} else {
						top--;
					}
				}
			}
			
			if(flag && top == -1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}

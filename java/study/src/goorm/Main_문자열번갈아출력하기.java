package goorm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_문자열번갈아출력하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		int left = 0;
		int right = input.length() - 1;
		
		while(left <= right) {
			bw.append(input.charAt(left++));
			if(left > right) break;
			bw.append(input.charAt(right--));
		}
		
		bw.flush();
	}
}

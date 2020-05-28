package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1373_2진수8진수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine().trim();
		
		int com = s.length() % 3;
		// com 만큼 계산
		
		if(com == 1) {
			int n = s.charAt(0) == '1' ? 1 : 0;
			bw.append(n + "");
		} else if(com == 2) {
			int n = 2 + (s.charAt(1) == '1' ? 1 : 0);
			bw.append(n + "");
		}
		
		for (int i = com; i < s.length(); i += 3) {
			int n = (s.charAt(i) == '1' ? 4 : 0) + (s.charAt(i + 1) == '1' ? 2 : 0) + (s.charAt(i + 2) == '1' ? 1 : 0);
			
			bw.append(n + "");
		}
		
		bw.flush();
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1212_8진수2진수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine().trim();
		
		for (int i = 0; i < s.length(); i++) {
			char n = s.charAt(i);
			
			switch(n) {
			case '0':
				bw.append(i == 0 ? "0" : "000");
				break;
			case '1':
				bw.append(i == 0 ? "1" : "001");
				break;
			case '2':
				bw.append(i == 0 ? "10" : "010");
				break;
			case '3':
				bw.append(i == 0 ? "11" : "011");
				break;
			case '4':
				bw.append("100");
				break;
			case '5':
				bw.append("101");
				break;
			case '6':
				bw.append("110");
				break;
			case '7':
				bw.append("111");
				break;
			}
		}
		
		bw.flush();
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1436_¿µÈ­°¨µ¶¼ò {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		for (int i = 666; i < Integer.MAX_VALUE; i++) {
			if(String.valueOf(i).contains("666")) {
				N--;
			}
			
			if(N == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}

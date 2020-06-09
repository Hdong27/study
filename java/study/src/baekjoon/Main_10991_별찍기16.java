package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10991_º°Âï±â16 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N - i; j++) {
				bw.append(' ');
			}
			
			for (int j = 0; j <= i; j++) {
				bw.append("* ");
			}
			
			bw.append("\n");
		}
		
		bw.flush();
	}
}

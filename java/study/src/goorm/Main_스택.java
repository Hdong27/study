package goorm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_Ω∫≈√ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] stack = new int[10];
		int top = -1;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int part = Integer.parseInt(br.readLine());
			
			if(part == 0) {
				int num = Integer.parseInt(br.readLine());
				if(top >= 9) {
					bw.append("overflow\n");
				} else {
					stack[++top] = num;
				}
			} else if(part == 1) {
				if(top < 0) {
					bw.append("underflow\n");
				} else {
					top--;
				}
			} else {
				break;
			}
		}
		
		for (int i = 0; i <= top; i++) {
			bw.append(stack[i] + " ");
		}
		
		bw.flush();
	}
}

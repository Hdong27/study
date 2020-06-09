package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14915_진수변환기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(N == 0) {
			System.out.println(0);
		} else {
			String result = "";
			
			while(N > 0) {
				int temp = N % M;
				N /= M;
				
				if(temp >= 10) {
					temp = 'A' + (temp % 10);
					result = (char)temp + result;
				} else {
					result = temp + result;
				}
			}
			
			System.out.println(result);
		}
	}
}

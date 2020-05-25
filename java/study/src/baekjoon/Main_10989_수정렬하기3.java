package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10989_수정렬하기3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] num = new int[10001];
		int max = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			max = max < n ? n : max;
			num[n]++;
		}
		
		for (int i = 0; i <= max; i++) {
			while(num[i] > 0) {
				bw.append(i + "\n");
				num[i]--;
			}
		}
		
		bw.flush();
	}
}

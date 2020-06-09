package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2448_º°Âï±â11 {
	static char[][] arr = {
			{' ', ' ', '*', ' ', ' '},
			{' ', '*', ' ', '*', ' '},
			{'*', '*', '*', '*', '*'}
	};
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		
		map = new char[N][2 * N - 1];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				map[i][j] = ' ';
			}
		}
		
		function(N / 3, 0, 0);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				bw.append(map[i][j]);
			}
			bw.append("\n");
		}
		
		bw.flush();
	}
	
	static void function(int n, int x, int y) {
		if(n == 1) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 5; j++) {
					map[x + i][y + j] = arr[i][j];
				}
			}
			return;
		}
		
		function(n / 2, x, y + 3 * n / 2);
		function(n / 2, x + 3 * n / 2, y);
		function(n / 2, x + 3 * n / 2, y + 3 * n);
	}
}

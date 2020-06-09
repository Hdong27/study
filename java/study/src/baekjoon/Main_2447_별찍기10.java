package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2447_별찍기10 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		
		char[][] map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = ' ';
			}
		}
		
		// 3 * 3 짜리 만들기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) map[i][j] = ' ';
				else map[i][j] = '*';
			}
		}
		
		int index = 3;
		while(index < N) {
			int index2 = index * 2;
			for (int i = 0; i < index; i++) {
				for (int j = 0; j < index; j++) {
					map[i][j+index] = map[i][j];
					map[i][j+index2] = map[i][j];
					map[i+index][j] = map[i][j];
					map[i+index][j+index2] = map[i][j];
					map[i+index2][j] = map[i][j];
					map[i+index2][j+index] = map[i][j];
					map[i+index2][j+index2] = map[i][j];
				}
			}
			
			index *= 3;
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.append(map[i][j]);
			}
			bw.append("\n");
		}
		bw.flush();
		
	}
}

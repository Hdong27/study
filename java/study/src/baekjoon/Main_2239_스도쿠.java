package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2239_스도쿠 {
	static int[][] map;
	static boolean finish;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		finish = false;
		dfs(0, 0);
		
		
	}
	
	static void dfs(int x, int y) {
		// 종료조건
		if(finish) {
			return;
		}
		// 인덱스가 넘어갈 경우
		if(x >= 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			finish = true;
			return;
		}
		
		if(y >= 9) {
			dfs(x + 1, 0);
			return;
		}
		
		// 로직
		if(map[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {
				if(isPossible(x, y, i)) {
					map[x][y] = i;
					dfs(x, y + 1);
					map[x][y] = 0;
				}
			}
		} else {
			dfs(x, y + 1);
		}
	}
	
	static boolean isPossible(int x, int y, int val) {
		// 가로
		for (int i = 0; i < 9; i++) {
			if(y == i) continue;
			if(map[x][i] == val) {
				return false;
			}
		}
		
		// 세로
		for (int i = 0; i < 9; i++) {
			if(x == i) continue;
			if(map[i][y] == val) {
				return false;
			}
		}
		
		// 대각선
		int sX = (x / 3) * 3;
		int sY = (y / 3) * 3;
		
		for (int i = sX; i < sX + 3; i++) {
			for (int j = sY; j < sY + 3; j++) {
				if(x == i && y == j) continue;
				if(map[i][j] == val) {
					return false;
				}
			}
		}
		
		return true;
	}
}

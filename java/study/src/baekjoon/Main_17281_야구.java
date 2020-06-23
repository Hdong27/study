package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17281_야구 {
	static boolean[] check;
	static int[] save;
	static int[][] map;
	static int N, max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		max = 0;
		N = Integer.parseInt(br.readLine().trim());	// 이닝 수
		
		map = new int[N][9];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j * 2) - '0';
			}
		}
		
		check = new boolean[10];	// 2 ~ 9
		save = new int[8];
		comb(0);
		
		System.out.println(max);
	}
	
	static void function() {
		int[] arr = new int[9];
		
		int index = 0;
		int i = 0;
		
		while(index <= 8) {
			if(index == 3) {
				arr[index] = 0;
			} else {
				arr[index] = save[i];
				i++;
			}
			index++;
		}
		
		// 최대 점수를 구한다.
		int inning = 0;	// 현재 이닝
		index = 0;	// 현재 타자 번호
		
		int score = 0;	// 현재까지의 점수
		while(inning < N) {
			int out = 0;
			// out이 3개가 될때까지 진행
			boolean[] ru = new boolean[4];	// 루의 상황, 0 : 홈, ... 3 : 3루
			while(out < 3) {
				switch(map[inning][arr[index]]) {
				case 0:
					out++;
					break;
				case 1:
					if(ru[3]) {
						score++;
						ru[3] = false;
					}
					if(ru[2]) {
						ru[3] = true;
						ru[2] = false;
					}
					if(ru[1]) {
						ru[2] = true;
						ru[1] = false;
					}
					ru[1] = true;
					break;
				case 2:
					if(ru[3]) {
						score++;
						ru[3] = false;
					}
					if(ru[2]) {
						score++;
						ru[2] = false;
					}
					if(ru[1]) {
						ru[3] = true;
						ru[1] = false;
					}
					ru[2] = true;
					break;
				case 3:
					if(ru[3]) {
						score++;
						ru[3] = false;
					}
					if(ru[2]) {
						score++;
						ru[2] = false;
					}
					if(ru[1]) {
						score++;
						ru[1] = false;
					}
					ru[3] = true;
					break;
				case 4:
					if(ru[3]) {
						score++;
						ru[3] = false;
					}
					if(ru[2]) {
						score++;
						ru[2] = false;
					}
					if(ru[1]) {
						score++;
						ru[1] = false;
					}
					score++;
					break;
				}
				index++;
				if(index == 9) {
					index = 0;
				}
			}
			inning++;
		}
		
		if(score > max) {
			max = score;
		}
	}
	
	static void comb(int cnt) {
		if(cnt == 8) {
			function();
			return;
		}
		
		for (int i = 1; i <= 8; i++) {
			if(!check[i]) {
				check[i] = true;
				save[cnt] = i;
				comb(cnt + 1);
				check[i] = false;
			}
		}
	}
}

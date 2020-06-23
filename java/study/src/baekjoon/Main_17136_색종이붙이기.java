package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17136_색종이붙이기 {
	static int N = 10;
	static int[][] map;
	static int min;
	static int[] paper;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[N][N];
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j * 2) - '0';
				if(map[i][j] == 1) {
					count++;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		paper = new int[6];
		
		dfs(0, 0, count, 0);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	// x좌표, y좌표, 1의 갯수, 사용한 종이 갯수
	static void dfs(int x, int y, int count, int pCount) {
		// 1이 모두 사라졌으면 최솟값을 갱신한다.
		if(count == 0) {
			min = pCount < min ? pCount : min;
			return;
		}
		
		// 현재 최소값보다 종이가 많이 사용되면 하는 의미가 없다.
		if(pCount >= min) return;
		
		// y인덱스가 범위를 넘어갔을 경우 x인덱스를 1더한다.
		if(y >= N) {
			dfs(x + 1, 0, count, pCount);
			return;
		}
		
		// x인덱스가 범위를 넘어갔을 경우 끝낸다.
		if(x >= N) {
			return;
		}
		
		if(map[x][y] == 1) {
			// 색종이를 붙어야 하면 붙일 수 있는 색종이를 하나씩 확인한다.
			for (int p = 5; p >= 1; p--) {
				// 5 x 5, 4 x 4, ... 1 x 1 ( 큰 종이부터 확인 )
				if(paper[p] < 5) {
					int sum = 0;
					for (int i = x; i < x + p && i < N; i++) {
						for (int j = y; j < y + p && j < N; j++) {
							sum += map[i][j];
						}
					}
					
					// 모든 칸이 1이면 색종이를 붙여본다.
					if(sum == p * p) {
						for (int i = x; i < x + p; i++) {
							for (int j = y; j < y + p; j++) {
								map[i][j] = 0;
							}
						}
						
						paper[p]++;
						dfs(x, y, count - sum, pCount + 1);
						paper[p]--;
						
						for (int i = x; i < x + p; i++) {
							for (int j = y; j < y + p; j++) {
								map[i][j] = 1;
							}
						}
					}
				}
			}
		} else {
			// 색종이를 붙이지 않을 경우 다음으로 진행
			dfs(x, y + 1, count, pCount);
		}
	}
}

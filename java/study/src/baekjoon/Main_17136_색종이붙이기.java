package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17136_�����̺��̱� {
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
	
	// x��ǥ, y��ǥ, 1�� ����, ����� ���� ����
	static void dfs(int x, int y, int count, int pCount) {
		// 1�� ��� ��������� �ּڰ��� �����Ѵ�.
		if(count == 0) {
			min = pCount < min ? pCount : min;
			return;
		}
		
		// ���� �ּҰ����� ���̰� ���� ���Ǹ� �ϴ� �ǹ̰� ����.
		if(pCount >= min) return;
		
		// y�ε����� ������ �Ѿ�� ��� x�ε����� 1���Ѵ�.
		if(y >= N) {
			dfs(x + 1, 0, count, pCount);
			return;
		}
		
		// x�ε����� ������ �Ѿ�� ��� ������.
		if(x >= N) {
			return;
		}
		
		if(map[x][y] == 1) {
			// �����̸� �پ�� �ϸ� ���� �� �ִ� �����̸� �ϳ��� Ȯ���Ѵ�.
			for (int p = 5; p >= 1; p--) {
				// 5 x 5, 4 x 4, ... 1 x 1 ( ū ���̺��� Ȯ�� )
				if(paper[p] < 5) {
					int sum = 0;
					for (int i = x; i < x + p && i < N; i++) {
						for (int j = y; j < y + p && j < N; j++) {
							sum += map[i][j];
						}
					}
					
					// ��� ĭ�� 1�̸� �����̸� �ٿ�����.
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
			// �����̸� ������ ���� ��� �������� ����
			dfs(x, y + 1, count, pCount);
		}
	}
}

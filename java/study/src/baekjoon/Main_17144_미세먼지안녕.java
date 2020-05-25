package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_�̼������ȳ� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] clean = new int[2][2];
		int index = 0;
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == -1) {
					clean[index++] = new int[] {i, j};
				} else {
					result += map[i][j];
				}
			}
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while(T > 0) {
			// 1. �̼����� Ȯ��
			int[][] map2 = new int[N][M];
			map2[clean[0][0]][clean[0][1]] = -1;
			map2[clean[1][0]][clean[1][1]] = -1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > 0) {
						// �̼������� �����ϱ� Ȯ���� ��Ų��.
						int temp = map[i][j] / 5; // �̼������� Ȯ��� ��
						
						int count = 0;
						for (int k = 0; k < 4; k++) {	// 4�������� �̼������� Ȯ���Ų��.
							int x = i + dx[k];
							int y = j + dy[k];
							
							if(x >= 0 && x < N && y >= 0 && y < M && map[x][y] != -1) {
								map2[x][y] += temp;
								count++;
							}
						}
						
						map2[i][j] += map[i][j] - count * temp;
					}
				}
			}
			
			// map2�� ��Ƶ� Ȯ�������� map�� �����Ѵ�.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = map2[i][j];
				}
			}
			
			// 2. ����û���� �۵�
			// ����û���� ���� ������ ������ �����Ѵ�.
			result -= map[clean[0][0] - 1][clean[0][1]];
			
			// ������ ��ĭ�� ����.
			// ��
			for (int i = clean[0][0] - 1; i > 0; i--) {
				map[i][0] = map[i - 1][0];
			}
			// ��
			for (int i = 0; i < M - 1; i++) {
				map[0][i] = map[0][i + 1];
			}
			// ��
			for (int i = 0; i < clean[0][0]; i++) {
				map[i][M - 1] = map[i + 1][M - 1];
			}
			// ��
			for (int i = M - 1; i > 1; i--) {
				map[clean[0][0]][i] = map[clean[0][0]][i - 1];
			}
			map[clean[0][0]][clean[0][1] + 1] = 0;
			
			// ����û���� �Ʒ��� ������ ������ �����Ѵ�.
			result -= map[clean[1][0] + 1][clean[1][1]];
			// ��
			for (int i = clean[1][0] + 1; i < N - 1; i++) {
				map[i][0] = map[i + 1][0];
			}
			// ��
			for (int i = 0; i < M - 1; i++) {
				map[N - 1][i] = map[N - 1][i + 1];
			}
			// ��
			for (int i = N - 1; i > clean[1][0]; i--) {
				map[i][M - 1] = map[i - 1][M - 1];
			}
			// ��
			for (int i = M - 1; i > 1; i--) {
				map[clean[1][0]][i] = map[clean[1][0]][i - 1];
			}
			map[clean[1][0]][clean[1][1] + 1] = 0;
			
			T--;
		}
		
		System.out.println(result);
	}
}

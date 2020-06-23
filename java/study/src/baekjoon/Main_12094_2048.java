package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12094_2048 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		
		// 0 : 상, 1 : 하, 2 : 좌, 3 : 우
		for (int a = 0; a < 4; a++) {
			int[][] map2 = move(map, a);
			for (int b = 0; b < 4; b++) {
				int[][] map3 = move(map2, b);
				for (int c = 0; c < 4; c++) {
					int[][] map4 = move(map3, c);
					for (int d = 0; d < 4; d++) {
						int[][] map5 = move(map4, d);
						for (int e = 0; e < 4; e++) {
							int[][] map6 = move(map5, e);
							for (int f = 0; f < 4; f++) {
								int[][] map7 = move(map6, f);
								for (int g = 0; g < 4; g++) {
									int[][] map8 = move(map7, g);
									for (int h = 0; h < 4; h++) {
										int[][] map9 = move(map8, h);
										for (int i = 0; i < 4; i++) {
											int[][] map10 = move(map9, i);
											for (int j = 0; j < 4; j++) {
												int[][] map11 = move(map10, j);
												
												for (int x = 0; x < N; x++) {
													for (int y = 0; y < N; y++) {
														if(map11[x][y] > max) {
															max = map11[x][y];
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static int[][] move(int[][] map, int dir) {
		int[][] map2 = new int[N][N];
		switch(dir) {
		case 0:	// 상
			for (int y = 0; y < N; y++) {
				// 같은 수를 합치면서 당긴다.
				int[] q = new int[N];
				int rear = -1;
				
				for (int i = 0; i < N; i++) {
					if(map[i][y] > 0) {
						q[++rear] = map[i][y];
					}
				}
				
				int index = 0;
				for (int i = 0; i <= rear; i++) {
					if(i < rear && q[i] == q[i+1]) {
						map2[index++][y] = q[i] * 2;
						i++;
					} else {
						map2[index++][y] = q[i];
					}
				}
			}
			break;
		case 1:	// 하
			for (int y = 0; y < N; y++) {
				// 같은 수를 합치면서 당긴다.
				int[] q = new int[N];
				int rear = -1;
				
				for (int i = N - 1; i >= 0; i--) {
					if(map[i][y] > 0) {
						q[++rear] = map[i][y];
					}
				}
				
				int index = N - 1;
				for (int i = 0; i <= rear; i++) {
					if(i < rear && q[i] == q[i+1]) {
						map2[index--][y] = q[i] * 2;
						i++;
					} else {
						map2[index--][y] = q[i];
					}
				}
			}
			break;
		case 2:	// 좌
			for (int x = 0; x < N; x++) {
				int[] q = new int[N];
				int rear = -1;
				
				for (int i = 0; i < N; i++) {
					if(map[x][i] > 0) {
						q[++rear] = map[x][i];
					}
				}
				
				int index = 0;
				for (int i = 0; i <= rear; i++) {
					if(i < rear && q[i] == q[i+1]) {
						map2[x][index++] = q[i] * 2;
						i++;
					} else {
						map2[x][index++] = q[i];
					}
				}
			}
			break;
		case 3:	// 우
			for (int x = 0; x < N; x++) {
				int[] q = new int[N];
				int rear = -1;
				
				for (int i = N - 1; i >= 0; i--) {
					if(map[x][i] > 0) {
						q[++rear] = map[x][i];
					}
				}
				
				int index = N - 1;
				for (int i = 0; i <= rear; i++) {
					if(i < rear && q[i] == q[i+1]) {
						map2[x][index--] = q[i] * 2;
						i++;
					} else {
						map2[x][index--] = q[i];
					}
				}
			}
			break;
		}
		
		return map2;
	}
}

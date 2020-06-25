package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		boolean[][] map = new boolean[101][101];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());	// 방향 ( 0 : x++, 1 : y--, 2 : x--, 3 : y++ )
			int g = Integer.parseInt(st.nextToken());	// 세대 번호
			
			// 0 : 한줄
			// 1 : 두줄
			// 2 ~ 10 : 반복
			List<Integer> list = new ArrayList<>();
			
			// 무조건 0 이상이기 때문에 (x, y) 부터 한줄 그린다.
			list.add(d);
			
			if(g >= 1) {
				// 1도 그린다.
				list.add((list.get(0) + 1) % 4);
				if(g >= 2) {
					// g까지 반복시킨다.
					for (int j = 2; j <= g; j++) {
						int len = list.size();
						int mid = len / 2;
						
						for (int k = 0; k < mid; k++) {
							list.add((list.get(k) + 2) % 4);
							
						}
						
						for (int k = mid; k < len; k++) {
							list.add(list.get(k));
						}
					}
				}
			}
			
			map[x][y] = true;
			// 방향을 가지고 커브 그리기
			for (Integer dir : list) {
				x += dx[dir];
				y += dy[dir];
				
				map[x][y] = true;
			}
			
		}
		
		
		// 사각형 갯수 구하기
		int result = 0;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// (i, j), (i + 1, j), (i, j + 1), (i + 1, j + 1)
				if(map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	static int N;
	static int[][] map;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		result = 0;
		
		// 시작 지점은 (0, 0), (0, 1)
		dfs(0, 0, 0, 1);
		
		System.out.println(result);
	}
	
	static void dfs(int x1, int y1, int x2, int y2) {
		if(x2 == N - 1 && y2 == N - 1) {
			result++;
			return;
		}
		
		if(x1 == x2) {	// 파이프가 가로로
			if(y2 + 1 < N && map[x2][y2 + 1] == 0) {
				dfs(x2, y2, x2, y2 + 1);
				if(x2 + 1 < N && map[x2 + 1][y2] == 0 && map[x2 + 1][y2 + 1] == 0) {
					dfs(x2, y2, x2 + 1, y2 + 1);
				}
			}
		} else if(y1 == y2) {	// 파이프가 세로로
			if(x2 + 1 < N && map[x2 + 1][y2] == 0) {
				dfs(x2, y2, x2 + 1, y2);
				if(y2 + 1 < N && map[x2][y2 + 1] == 0 && map[x2 + 1][y2 + 1] == 0) {
					dfs(x2, y2, x2 + 1, y2 + 1);
				}
			}
		} else {	// 파이프가 대각선으로
			if(x2 + 1 < N && y2 + 1 < N && map[x2 + 1][y2] == 0 && map[x2][y2 + 1] == 0 && map[x2 + 1][y2 + 1] == 0) {
				dfs(x2, y2, x2 + 1, y2 + 1);
			}
			if(x2 + 1 < N && map[x2 + 1][y2] == 0) {
				dfs(x2, y2, x2 + 1, y2);
			}
			if(y2 + 1 < N && map[x2][y2 + 1] == 0) {
				dfs(x2, y2, x2, y2 + 1);
			}
		}
	}
}

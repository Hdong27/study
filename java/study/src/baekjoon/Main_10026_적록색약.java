package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10026_적록색약 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		char[][] map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		int[][] q = new int[N*N][2];
		int front = -1;
		int rear = -1;
		
		boolean[][] visited = new boolean[N][N];
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					result++;
					visited[i][j] = true;
					q[++rear] = new int[] {i, j};
					
					while(front < rear) {
						int[] location = q[++front];
						
						for (int k = 0; k < 4; k++) {
							int x = location[0] + dx[k];
							int y = location[1] + dy[k];
							
							if(x >= 0 && x < N && y >= 0 && y < N && !visited[x][y] && map[location[0]][location[1]] == map[x][y]) {
								visited[x][y] = true;
								q[++rear] = new int[] {x, y};
							}
						}
					}
				}
			}
		}
		
		System.out.print(result + " ");
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		
		q = new int[N*N][2];
		front = -1;
		rear = -1;
		
		visited = new boolean[N][N];
		result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					result++;
					visited[i][j] = true;
					q[++rear] = new int[] {i, j};
					
					while(front < rear) {
						int[] location = q[++front];
						
						for (int k = 0; k < 4; k++) {
							int x = location[0] + dx[k];
							int y = location[1] + dy[k];
							
							if(x >= 0 && x < N && y >= 0 && y < N && !visited[x][y] && map[location[0]][location[1]] == map[x][y]) {
								visited[x][y] = true;
								q[++rear] = new int[] {x, y};
							}
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
}

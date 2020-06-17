package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19236_청소년상어 {
	static int score;
	static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[4][4];	// 물고기의 번호만
		
		Fish[] fishs = new Fish[17];
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				map[i][j] = n;
				fishs[n] = new Fish(i, j, n, d, true);
			}
		}
		
		
		// 가장 먼저 (0, 0)의 물고기를 먹는다.
		int d = fishs[map[0][0]].d;
		int sum = fishs[map[0][0]].n;
		fishs[map[0][0]].live = false;
		map[0][0] = 0;
		
		score = 0;	// 총 점수
		
		dfs(0, 0, d, sum, map, fishs);
		
		System.out.println(score);
	}
	
	static void dfs(int x, int y, int d, int sum, int[][] map, Fish[] fishs) {
		// 최댓값 갱신
		if(score < sum) {
			score = sum;
		}

		// 맵 및 물고기 정보 복사
		int[][] map2 = copyMap(map);
		Fish[] fishs2 = copyFish(fishs);
		
		// 1. 물고기가 1번부터 이동한다.
		for (int i = 1; i <= 16; i++) {
			if(fishs2[i].live) {	// 물고기가 아직 살아있으면
				int count = 0;
				while(count < 8) {
					int fX = fishs2[i].x + dx[fishs2[i].d];
					int fY = fishs2[i].y + dy[fishs2[i].d];
					
					if(fX >= 0 && fX < 4 && fY >= 0 && fY < 4 && !(x == fX && y == fY)) {	// 물고기가 범위를 나가지 않고 그 곳이 상어가 있는 곳이 아니면
						// 물고기는 해당 방향으로 이동한다.
						if(map2[fX][fY] == 0) {	// 그 위치가 다른 물고기가 없으면
							map2[fishs2[i].x][fishs2[i].y] = 0; 
							map2[fX][fY] = i;
							fishs2[i].x = fX;
							fishs2[i].y = fY;
						} else {	// 다른 물고기가 있으면
							// map의 n 값 변경
							// Fish의 x, y값 변경
							
							map2[fishs2[i].x][fishs2[i].y] = map2[fX][fY];
							fishs2[map2[fX][fY]].x = fishs2[i].x;
							fishs2[map2[fX][fY]].y = fishs2[i].y;
							
							map2[fX][fY] = i;
							fishs2[i].x = fX;
							fishs2[i].y = fY;
						}
						break;	// 물고기가 이동했음
					} else {
						fishs2[i].d++;
						if(fishs2[i].d > 8) {
							fishs2[i].d = 1;
						}
					}
					count++;
				}
			}
		}
		
		// 물고기가 모두 이동하면 상어가 이동하고 잡아먹는다.
		for (int i = 1; i < 4; i++) {
			int nx = x + dx[d] * i;
			int ny = y + dy[d] * i;
			
			if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map2[nx][ny] > 0) {	// 상어의 이동이 범위 안이고 그 칸에 물고기가 있으면
				// 물고기를 잡아먹고 그 방향으로 이동한다.
				int n = map2[nx][ny];
				map2[nx][ny] = 0;
				fishs2[n].live = false;
				dfs(nx, ny, fishs2[n].d, sum + n, map2, fishs2);
				fishs2[n].live = true;
				map2[nx][ny] = n;
			}
		}
	}
	
	static int[][] copyMap(int[][] map) {
		int[][] map2 = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				map2[i][j] = map[i][j];
			}
		}
		
		return map2;
	}
	
	static Fish[] copyFish(Fish[] fishs) {
		Fish[] fishs2 = new Fish[17];
		
		for (int i = 1; i <= 16; i++) {
			fishs2[i] = new Fish(fishs[i].x, fishs[i].y, fishs[i].n, fishs[i].d, fishs[i].live);
		}
		
		return fishs2;
	}
	
	static class Fish {
		int x;	// x좌표
		int y;	// y좌표
		int n;	// 번호
		int d;	// 방향
		boolean live;	// 살아있는지
		
		public Fish(int x, int y, int n, int d, boolean live) {
			this.x = x;
			this.y = y;
			this.n = n;
			this.d = d;
			this.live = live;
		}
	}
}

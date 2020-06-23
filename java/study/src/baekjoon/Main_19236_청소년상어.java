package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19236_û�ҳ��� {
	static int score;
	static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[4][4];	// ������� ��ȣ��
		
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
		
		
		// ���� ���� (0, 0)�� ����⸦ �Դ´�.
		int d = fishs[map[0][0]].d;
		int sum = fishs[map[0][0]].n;
		fishs[map[0][0]].live = false;
		map[0][0] = 0;
		
		score = 0;	// �� ����
		
		dfs(0, 0, d, sum, map, fishs);
		
		System.out.println(score);
	}
	
	static void dfs(int x, int y, int d, int sum, int[][] map, Fish[] fishs) {
		// �ִ� ����
		if(score < sum) {
			score = sum;
		}

		// �� �� ����� ���� ����
		int[][] map2 = copyMap(map);
		Fish[] fishs2 = copyFish(fishs);
		
		// 1. ����Ⱑ 1������ �̵��Ѵ�.
		for (int i = 1; i <= 16; i++) {
			if(fishs2[i].live) {	// ����Ⱑ ���� ���������
				int count = 0;
				while(count < 8) {
					int fX = fishs2[i].x + dx[fishs2[i].d];
					int fY = fishs2[i].y + dy[fishs2[i].d];
					
					if(fX >= 0 && fX < 4 && fY >= 0 && fY < 4 && !(x == fX && y == fY)) {	// ����Ⱑ ������ ������ �ʰ� �� ���� �� �ִ� ���� �ƴϸ�
						// ������ �ش� �������� �̵��Ѵ�.
						if(map2[fX][fY] == 0) {	// �� ��ġ�� �ٸ� ����Ⱑ ������
							map2[fishs2[i].x][fishs2[i].y] = 0; 
							map2[fX][fY] = i;
							fishs2[i].x = fX;
							fishs2[i].y = fY;
						} else {	// �ٸ� ����Ⱑ ������
							// map�� n �� ����
							// Fish�� x, y�� ����
							
							map2[fishs2[i].x][fishs2[i].y] = map2[fX][fY];
							fishs2[map2[fX][fY]].x = fishs2[i].x;
							fishs2[map2[fX][fY]].y = fishs2[i].y;
							
							map2[fX][fY] = i;
							fishs2[i].x = fX;
							fishs2[i].y = fY;
						}
						break;	// ����Ⱑ �̵�����
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
		
		// ����Ⱑ ��� �̵��ϸ� �� �̵��ϰ� ��ƸԴ´�.
		for (int i = 1; i < 4; i++) {
			int nx = x + dx[d] * i;
			int ny = y + dy[d] * i;
			
			if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map2[nx][ny] > 0) {	// ����� �̵��� ���� ���̰� �� ĭ�� ����Ⱑ ������
				// ����⸦ ��Ƹ԰� �� �������� �̵��Ѵ�.
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
		int x;	// x��ǥ
		int y;	// y��ǥ
		int n;	// ��ȣ
		int d;	// ����
		boolean live;	// ����ִ���
		
		public Fish(int x, int y, int n, int d, boolean live) {
			this.x = x;
			this.y = y;
			this.n = n;
			this.d = d;
			this.live = live;
		}
	}
}

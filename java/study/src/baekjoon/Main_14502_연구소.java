package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14502_������ {
	static int N, M;
	static int[][] map;
	static int len;
	static int[] save;
	static boolean[] check;
	static List<int[]> viruses;	// ���̷����� �ִ� ������
	static List<int[]> walls;	// ���� ���� ���� �� �ִ� ������
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		walls = new ArrayList<>();
		viruses = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 0) {
					walls.add(new int[] {i, j});
				} else if(map[i][j] == 2) {
					viruses.add(new int[] {i, j});
				}
			}
		}
		
		/**
		 * ����
		 * �޸� : 27316KB, �ð� : 240ms
		 */
		/*
		len = walls.size();
		save = new int[3];
		check = new boolean[len];
		max = 0;
		
		comb(0, 0);
		*/
		
		/**
		 * for��
		 * �޸� : 22420KB, �ð� : 164ms
		 */
		len = walls.size();
		max = 0;
		
		for (int i = 0; i < len - 2; i++) {
			map[walls.get(i)[0]][walls.get(i)[1]] = 1;
			for (int j = i + 1; j < len -1 ; j++) {
				map[walls.get(j)[0]][walls.get(j)[1]] = 1;
				for (int k = j + 1; k < len; k++) {
					map[walls.get(k)[0]][walls.get(k)[1]] = 1;
					
					diffusion();
					
					map[walls.get(k)[0]][walls.get(k)[1]] = 0;
				}
				map[walls.get(j)[0]][walls.get(j)[1]] = 0;
			}
			map[walls.get(i)[0]][walls.get(i)[1]] = 0;
		}
		
		System.out.println(max);
	}
	
	// ���� ���� ���� ���� ã��
	static void comb(int count, int index) {
		if(count == 3) {
			// �� 3�� �߰��ϱ�
			for (int i = 0; i < 3; i++) {
				int[] location = walls.get(save[i]);
				
				map[location[0]][location[1]] = 1;
			}
			
			// ���̷��� Ȯ��
//			bfs();
			diffusion();
			
			// ���� ���� �� 3�� �����ϱ�
			for (int i = 0; i < 3; i++) {
				int[] location = walls.get(save[i]);
				
				map[location[0]][location[1]] = 0;
			}
			
			return;
		}
		
		for (int i = index; i < len; i++) {
			if(!check[i]) {
				check[i] = true;
				save[count] = i;
				comb(count + 1, i + 1);
				check[i] = false;
			}
		}
	}
	
	
	/**
	 * bfs�� �̿��� Ȯ��
	 * �޸� : 137328KB, �ð� : 356ms
	 */
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	// ���̷��� Ȯ���Ű��
	static void bfs() {
		boolean[][] visited = new boolean[N][M];
		
		int[][] q = new int[N * M][2];
		int front = -1;
		int rear = -1;
		
		int result = len - 3;
		
		// ���� ���̷����� ��ǥ�� q�� ����
		for (int i = 0; i < viruses.size(); i++) {
			int[] location = viruses.get(i);
			visited[location[0]][location[1]] = true;
			q[++rear] = location;
		}
		
		// bfs�� �̿��� ���̷��� Ȯ��
		while(front < rear) {
			int[] location = q[++front];
			
			for (int i = 0; i < 4; i++) {
				int x = location[0] + dx[i];
				int y = location[1] + dy[i];
				
				if(x >= 0 && x < N && y >= 0 && y < M && !visited[x][y] && map[x][y] == 0) {
					visited[x][y] = true;
					result--;
					q[++rear] = new int[] {x, y};
				}
			}
		}
		
		max = result > max ? result : max;
	}
	
	/**
	 * dfs�� �̿��� Ȯ��
	 * �޸� : 27316KB, �ð� : 240ms
	 */
	static boolean[][] visited2;
	static int result2;
	static void diffusion() {
		visited2 = new boolean[N][M];
		result2 = len - 3;
		
		for (int i = 0; i < viruses.size(); i++) {
			int[] location = viruses.get(i);
			
			visited2[location[0]][location[1]] = true;
			dfs(location[0], location[1]);
		}
		
		max = result2 > max ? result2 : max;
	}
	
	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited2[nx][ny] && map[nx][ny] == 0) {
				visited2[nx][ny] = true;
				result2--;
				dfs(nx, ny);
			}
		}
	}
}

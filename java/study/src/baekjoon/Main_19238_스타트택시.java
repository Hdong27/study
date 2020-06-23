package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19238_스타트택시 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	// map의 크기 N * N
		int M = Integer.parseInt(st.nextToken());	// 사람의 수
		int L = Integer.parseInt(st.nextToken());	// 초기 연료의 양
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		Taxi taxi = new Taxi(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, L);
		
		Customer[] customers = new Customer[M + 2];
		for (int i = 2; i < M + 2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			customers[i] = new Customer(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
			
			map[customers[i].startX][customers[i].startY] = i;
		}
		
		int count = M;	// 옮겨야 할 사람의 수
		
		while(count > 0) {
			// 현재 태울 고객의 시작 위치
			int[] location = {N, N};
			
			// 1. 택시로 부터 가장 가까운 사람을 찾는다.
			boolean[][] check = new boolean[N][N];
			
			int len = 0; // 승객 까지의 거리
			
			int[][] q = new int[N * N][2];
			int front = -1;
			int rear = -1;
			
			check[taxi.x][taxi.y] = true;
			q[++rear] = new int[] {taxi.x, taxi.y};
			
			boolean flag = false;
			while(front < rear) {
				int start = front;
				int end = rear;
				
				for (int s = start; s < end; s++) {
					int x = q[++front][0];
					int y = q[front][1];
					
					// x, y에 사람이 있으면
					if(map[x][y] > 1) {
						flag = true;
						if(location[0] > x) {
							location[0] = x;
							location[1] = y;
						} else if(location[0] == x && location[1] > y) {
							location[0] = x;
							location[1] = y;
						}
					}
					
					if(flag) continue;
					for (int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						
						if(nx >= 0 && nx < N && ny >= 0 && ny < N && !check[nx][ny] && map[nx][ny] != 1) {
							check[nx][ny] = true;
							q[++rear] = new int[] {nx, ny};
						}
					}
				}
				if(flag) break;
				len++;
			}
			
			// 태울 수 있는 승객이 없으면
			if(!flag) {
				break;
			}
			
			// location의 승객에게 간다.
			taxi.l -= len;
			
			// 연료가 부족하면
			if(taxi.l < 0) {
				break;
			}
			
			taxi.x = location[0];
			taxi.y = location[1];
			
			int num = map[taxi.x][taxi.y];
			map[taxi.x][taxi.y] = 0; 
			
			// 도착지점으로 이동한다.
			check = new boolean[N][N];
			
			q = new int[N * N][2];
			front = -1;
			rear = -1;
			
			check[taxi.x][taxi.y] = true;
			q[++rear] = new int[] {taxi.x, taxi.y};
			
			flag = false;
			len = 0;
			while(front < rear) {
				int start = front;
				int end = rear;
				
				for (int i = start; i < end; i++) {
					int x = q[++front][0];
					int y = q[front][1];
					
					// 도착지점에 도착하면
					if(x == customers[num].endX && y == customers[num].endY) {
						flag = true;
						taxi.x = x;
						taxi.y = y;
						break;
					}
					
					for (int j = 0; j < 4; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						
						if(nx >= 0 && nx < N && ny >= 0 && ny < N && !check[nx][ny] && map[nx][ny] != 1) {
							check[nx][ny] = true;
							q[++rear] = new int[] {nx, ny};
						}
					}
				}
				if(flag) {
					break;
				}
				
				len++;
				
			}
			
			if(!flag) {
				break;
			}
			
			taxi.l -= len;
			
			if(taxi.l < 0) {
				break;
			}
			
			taxi.l += len * 2;
			
			count--;
		}
		
		if(count > 0) {
			System.out.println(-1);
		} else {
			System.out.println(taxi.l);
		}
	}
	
	static class Taxi {
		int x;
		int y;
		int l;
		
		public Taxi(int x, int y, int l) {
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}
	
	static class Customer {
		int startX;
		int startY;
		int endX;
		int endY;
		
		public Customer(int startX, int startY, int endX, int endY) {
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
		}
	}
}

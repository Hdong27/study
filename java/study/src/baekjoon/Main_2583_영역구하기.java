package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					map[j][k] = true;
				}
			}
		}
		
		int result = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!map[i][j]) {
					result++;
					int[][] q = new int[N*M][2];
					int front = -1;
					int rear = -1;
					
					map[i][j] = true;
					q[++rear] = new int[] {i, j};
					int area = 1;
					
					while(front < rear) {
						int[] location = q[++front];
						
						for (int l = 0; l < 4; l++) {
							int x = location[0] + dx[l];
							int y = location[1] + dy[l];
							
							if(x >= 0 && x < N && y >= 0 && y < M && !map[x][y]) {
								map[x][y] = true;
								q[++rear] = new int[] {x, y};
								area++;
							}
						}
					}
					
					pq.add(area);
				}
			}
		}
		
		bw.append(result + "\n");
		
		while(!pq.isEmpty()) {
			bw.append(pq.poll() + " ");
		}
		
		bw.flush();
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] G = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			G[u][v] = true;
			G[v][u] = true;
		}
		
		int result = 0;
		boolean[] visited = new boolean[N + 1];
		
		int[] q = new int[N + 1];
		int front = -1;
		int rear = -1;
		
		while(isFinish(N, visited)) {
			for (int i = 1; i <= N; i++) {
				if(!visited[i]) {
					result++;
					visited[i] = true;
					q[++rear] = i;
					
					while(front < rear) {
						int v = q[++front];
						for (int j = 1; j <= N; j++) {
							if(G[v][j] && !visited[j]) {
								visited[j] = true;
								q[++rear] = j;
							}
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
	
	static boolean isFinish(int N, boolean[] visited) {
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) return true;
		}
		return false;
	}
}

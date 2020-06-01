package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5567_°áÈ¥½Ä {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		
		boolean[][] G = new boolean[N+1][N+1];
		boolean[] check = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			G[a][b] = true;
			G[b][a] = true;
		}
		
		int[] q = new int[N+1];
		int front = -1;
		int rear = -1;
		
		q[++rear] = 1;
		check[1] = true;
		
		for (int i = 0; i < 2; i++) {
			int start = front;
			int end = rear;
			
			for (int j = start; j < end; j++) {
				int v = q[++front];
				
				for (int k = 2; k <= N; k++) {
					if(G[v][k] && !check[k]) {
						q[++rear] = k;
						check[k] = true;
					}
				}
			}
		}
		
		System.out.println(rear);
	}
}

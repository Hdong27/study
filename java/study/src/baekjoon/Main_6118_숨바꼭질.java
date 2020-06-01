package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6118_¼û¹Ù²ÀÁú {
	static boolean[][] G;
	static boolean[] check;
	static int[] answer;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		G = new boolean[N+1][N+1];
		check = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			G[a][b] = true;
			G[b][a] = true;
		}
		
		answer = new int[3];
		
		int[] q = new int[N + 1];
		int front = -1;
		int rear = -1;
		
		q[++rear] = 1;
		check[1] = true;
		
		while(front < rear) {
			
			int start = front;
			int end = rear;
			
			int min = 20001;
			for (int i = start; i < end; i++) {
				int v = q[++front];
				
				for (int j = 2; j <= N; j++) {
					if(G[v][j] && !check[j]) {
						q[++rear] = j;
						check[j] = true;
						min = j < min ? j : min;
					}
				}
			}
			
			answer[2] = end - start;
			if(front < rear) {
				answer[1]++;
				answer[0] = min;
			}
		}
		
		System.out.printf("%d %d %d", answer[0], answer[1], answer[2]);
	}
}

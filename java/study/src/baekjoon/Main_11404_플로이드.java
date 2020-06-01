package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {
	static int max = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		
		int[][] G = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				G[i][j] = max;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			G[x][y] = G[x][y] < cost ? G[x][y] : cost;
		}
		
		for (int v = 1; v <= N; v++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i == j) continue;
					G[i][j] = G[i][j] < G[i][v] + G[v][j] ? G[i][j] : G[i][v] + G[v][j];
				}
			}
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				bw.append((G[i][j] == max ? 0 : G[i][j]) + " ");
			}
			bw.append("\n");
		}
		
		bw.flush();
	}
}

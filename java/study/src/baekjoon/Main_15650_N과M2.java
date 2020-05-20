package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N°úM2 {
	static int N, M;
	static boolean[] check;
	static int[] save;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check = new boolean[N+1];
		save = new int[M];
		
		dfs(0, 1);
	}
	
	static void dfs(int count, int index) {
		if(count == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(save[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = index; i <= N; i++) {
			if(!check[i]) {
				check[i] = true;
				save[count] = i;
				dfs(count + 1, i + 1);
				check[i] = false;
			}
		}
	}
}

package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_�������ϱ� {
	public static void main(String[] args) {
		System.out.println(solution(4, new int[][] {
			{0, 1, 1},
			{0, 2, 2},
			{1, 2, 5},
			{1, 3, 1},
			{2, 3, 8}
		}));
		
		System.out.println(solution(4, new int[][] {
			{0, 1, 1},
			{0, 2, 2},
			{2, 3, 1}
		}));
	}
	
	
	// ũ�罺Į �˰����� �̿��� �ּ� ���д� Ʈ�� ã��
	static int[] d;
	public static int solution(int n, int[][] costs) {
		int answer = 0;
		
		// d[i]�� ���� i�� �θ�
		d = new int[n];
		
		// 1. d[i] = i�� �θ� ��´�. ó������ �ڱ��ڽ��� �θ�
		// disjoint-set�� ����ϱ� ���� �ʱ�ȭ
		for (int i = 0; i < n; i++) {
			d[i] = i;
		}
		
		// 2. ������ ����ġ ���� �������� ����
		Arrays.sort(costs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		// 3. ��� ������ �˻�
		for (int i = 0; i < costs.length; i++) {
			int start = find(costs[i][0]);
			int end = find(costs[i][1]);
			int cost = costs[i][2];
			
			// 4. start�� end�� ���� ������� �ʾҴٸ�
			if(start != end) {
				// 1) start�� �θ� end�� �����ϰ�
				d[start] = end;
				
				// 2) ������ ����ġ�� ����� ���Ѵ�.
				answer += cost;
			}
		}
		
		return answer;
	}
	
	static int find(int node) {
		// �ڱ� �ڽ��� �θ��� �ֻ��� ���
		if(node == d[node]) return node;
		
		// �ƴ϶�� �ֻ��� �θ��� �θ� ã�´�.
		else return d[node] = find(d[node]);
	}
	
	/*
	static int[] save;
	static int N, M;	
	static boolean[] used;
	static int answer;
	static int max = Integer.MAX_VALUE;
	public static int solution(int n, int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		
		answer = max;
		
		N = costs.length;
		used = new boolean[N];
		
		for (int i = n - 1; i <= N; i++) {
			M = i;
			save = new int[i];
			comb(0, 0, costs, n);
			
			if(answer != max) {
				break;
			}
		}
		
		return answer;
	}
	
	static void comb(int index, int cnt, int[][] costs, int n) {
		if(cnt == M) {
			boolean[][] G = new boolean[n][n];
			
			int temp = 0;
			
			for (int i = 0; i < save.length; i++) {
				G[costs[save[i]][0]][costs[save[i]][1]] = true;
				G[costs[save[i]][1]][costs[save[i]][0]] = true;
				temp += costs[save[i]][2];
			}
			
			if(isLink(n, G)) {
				answer = temp < answer ? temp : answer;
			}
			return;
		}
		
		if(answer != max) {
			return;
		}
		
		for (int i = index; i < N; i++) {
			if(!used[i]) {
				used[i] = true;
				save[cnt] = i;
				comb(i + 1, cnt + 1, costs, n);
				used[i] = false;
			}
		}
	}
	
	static boolean isLink(int n, boolean[][] G) {
		boolean[] check = new boolean[n];
		
		int[] q = new int[n];
		int front = -1;
		int rear = -1;
		
		check[0] = true;
		q[++rear] = 0;
		
		while(front < rear) {
			int v = q[++front];
			
			for (int i = 0; i < n; i++) {
				if(G[v][i] && !check[i]) {
					check[i] = true;
					q[++rear] = i;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			if(!check[i]) {
				return false;
			}
		}
		
		return true;
	}
	*/
}

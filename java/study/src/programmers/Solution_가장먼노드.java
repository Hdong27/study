package programmers;

public class Solution_가장먼노드 {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[][] {
			{3, 6},
			{4, 3},
			{3, 2},
			{1, 3},
			{1, 2},
			{2, 4},
			{5, 2}
		}));
	}
	
	public static int solution(int n, int[][] edge) {
		int answer = 0;
		
		boolean[][] G = new boolean[n + 1][n + 1];
		
		// 그래프 만들기
		for (int i = 0; i < edge.length; i++) {
			G[edge[i][0]][edge[i][1]] = true;
			G[edge[i][1]][edge[i][0]] = true;
		}
		
		// bfs를 이용해 그래프 탐색
		boolean[] visited = new boolean[n + 1];	// 방문 체크
		
		int[] q = new int[n + 1];
		int front = -1;
		int rear = -1;
		
		visited[1] = true;
		q[++rear] = 1;	// 시작할 노드는 항상 1번
		
		while(front < rear) {
			int start = front;
			int end = rear;
			
			for (int i = start; i < end; i++) {
				int v = q[++front];
				
				for (int j = 1; j <= n; j++) {
					if(G[v][j] && !visited[j]) {	// 갈 수 있고 방문하지 않았으면
						visited[j] = true;
						q[++rear] = j;
					}
				}
			}
			
			answer = end - start;
		}
		
		return answer;
	}
}

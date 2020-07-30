package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_경주로건설 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {
			{0,0,0,0,0,0},
			{0,1,1,1,1,0},
			{0,0,1,0,0,0},
			{1,0,0,1,0,1},
			{0,1,0,0,0,1},
			{0,0,0,0,0,0}
		}));
	}
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		
		int N = board.length;
		int[][] map = new int[N][N];
		
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(0, 0, 1, 0));
		q.add(new Point(0, 0, 2, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == N - 1 && p.y == N - 1 && p.count < answer) {
				answer = p.count;
				continue;
			}
			
			int[] arr = {(p.dir - 1) % 4 >= 0 ? (p.dir - 1) % 4 : 3, p.dir, (p.dir + 1) % 4};
			
			for (int i : arr) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				
				if(x >= 0 && y >= 0 && x < N && y < N && board[x][y] == 0) {
					int count = 0;
					
					if(p.dir == i) {
						count = p.count + 100;
					} else {
						count = p.count + 600;
					}
					
					if(map[x][y] == 0) {
						map[x][y] = count;
						q.add(new Point(x, y, i, count));
					} else  if(map[x][y] >= count) {
						map[x][y] = count;
						q.add(new Point(x, y, i, count));
					}
				}
			}
		}
		
		return answer;
	}
	
	static class Point {
		int x;
		int y;
		int dir;
		int count;

		public Point(int x, int y, int dir, int count) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
		}
	}
}

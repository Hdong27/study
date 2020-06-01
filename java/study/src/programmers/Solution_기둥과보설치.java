package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_기둥과보설치 {
	public static void main(String[] args) {
		int[][] result = solution(5, new int[][] {
//			{1,0,0,1},
//			{1,1,1,1},
//			{2,1,0,1},
//			{2,2,1,1},
//			{5,0,0,1},
//			{5,1,0,1},
//			{4,2,1,1},
//			{3,2,1,1}
			
			{0,0,0,1},
			{2,0,0,1},
			{4,0,0,1},
			{0,1,1,1},
			{1,1,1,1},
			{2,1,1,1},
			{3,1,1,1},
			{2,0,0,0},
			{1,1,1,0},
			{2,2,0,1}
		});
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
	
	static boolean[][][] map;
	static int N;
	public static int[][] solution(int n, int[][] build_frame) {
		N = n;
		map = new boolean[n+1][n+1][2];
		
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];	// 가로
			int y = build_frame[i][1];	// 세로
			int a = build_frame[i][2];	// 0 : 기둥, 1 : 보
			int b = build_frame[i][3];	// 0 : 삭제, 1 : 설치
			
			if(b == 0) {
				// 하나를 삭제하고 나머지가 모두 가능한지 확인한다.
				map[x][y][a] = false;
				boolean flag = true;
				int index = -1;
				
				for (int j = 0; j < list.size(); j++) {
					int[] temp = list.get(j);
					
					if(temp[0] == x && temp[1] == y && temp[2] == a) {
						index = j;
					}
					
					if(!isPossible(temp[0], temp[1], temp[2])) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					list.remove(index);
				} else {
					map[x][y][a] = true;
				}
			} else {	// b == 1
				// 그 하나만 가능한지 확인한다.
				if(isPossible(x, y, a)) {
					map[x][y][a] = true;
					list.add(new int[] {x, y, a});
				}
			}
		}
		
		int[][] answer = new int[list.size()][3];
		
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					if(o1[1] == o2[1]) {
						return o1[2] - o2[2];
					}
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
	
	static boolean isPossible(int x, int y, int a) {
		if(a == 0) {
			// 기둥 설치가 가능한 경우
			// (1) 바닥 위에 있거나 (2) 보의 한쪽 끝 부분 위에 있거나 (3) 기둥 위에 있는 경우
			if(y == 0 || (x-1 >= 0 && map[x-1][y][1]) || map[x][y][1] || (y-1 >= 0 && map[x][y-1][0])) {
				return true;
			}
		} else {	// a == 1
			// 보 설치가 가능한 경우
			// (1) 한쪽 끝 부분이 기둥 위에 있거나 (2) 양쪽 끝 부분이 보와 동시에 연결되어 있는 경우
			if((y-1 >= 0 && map[x][y-1][0]) || (x+1 < N+1 && y-1 >= 0 && map[x+1][y-1][0]) || ((x-1 >= 0 && map[x-1][y][1]) && (x+1 < N+1 && map[x+1][y][1]))) {
				return true;
			}
		}
		return false;
	}
}

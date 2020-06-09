package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_��հ�����ġ {
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
			int x = build_frame[i][0];	// ����
			int y = build_frame[i][1];	// ����
			int a = build_frame[i][2];	// 0 : ���, 1 : ��
			int b = build_frame[i][3];	// 0 : ����, 1 : ��ġ
			
			if(b == 0) {
				// �ϳ��� �����ϰ� �������� ��� �������� Ȯ���Ѵ�.
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
				// �� �ϳ��� �������� Ȯ���Ѵ�.
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
			// ��� ��ġ�� ������ ���
			// (1) �ٴ� ���� �ְų� (2) ���� ���� �� �κ� ���� �ְų� (3) ��� ���� �ִ� ���
			if(y == 0 || (x-1 >= 0 && map[x-1][y][1]) || map[x][y][1] || (y-1 >= 0 && map[x][y-1][0])) {
				return true;
			}
		} else {	// a == 1
			// �� ��ġ�� ������ ���
			// (1) ���� �� �κ��� ��� ���� �ְų� (2) ���� �� �κ��� ���� ���ÿ� ����Ǿ� �ִ� ���
			if((y-1 >= 0 && map[x][y-1][0]) || (x+1 < N+1 && y-1 >= 0 && map[x+1][y-1][0]) || ((x-1 >= 0 && map[x-1][y][1]) && (x+1 < N+1 && map[x+1][y][1]))) {
				return true;
			}
		}
		return false;
	}
}

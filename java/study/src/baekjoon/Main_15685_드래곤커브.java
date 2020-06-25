package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15685_�巡��Ŀ�� {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		boolean[][] map = new boolean[101][101];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());	// ���� ( 0 : x++, 1 : y--, 2 : x--, 3 : y++ )
			int g = Integer.parseInt(st.nextToken());	// ���� ��ȣ
			
			// 0 : ����
			// 1 : ����
			// 2 ~ 10 : �ݺ�
			List<Integer> list = new ArrayList<>();
			
			// ������ 0 �̻��̱� ������ (x, y) ���� ���� �׸���.
			list.add(d);
			
			if(g >= 1) {
				// 1�� �׸���.
				list.add((list.get(0) + 1) % 4);
				if(g >= 2) {
					// g���� �ݺ���Ų��.
					for (int j = 2; j <= g; j++) {
						int len = list.size();
						int mid = len / 2;
						
						for (int k = 0; k < mid; k++) {
							list.add((list.get(k) + 2) % 4);
							
						}
						
						for (int k = mid; k < len; k++) {
							list.add(list.get(k));
						}
					}
				}
			}
			
			map[x][y] = true;
			// ������ ������ Ŀ�� �׸���
			for (Integer dir : list) {
				x += dx[dir];
				y += dy[dir];
				
				map[x][y] = true;
			}
			
		}
		
		
		// �簢�� ���� ���ϱ�
		int result = 0;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// (i, j), (i + 1, j), (i, j + 1), (i + 1, j + 1)
				if(map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1722_�����Ǽ��� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		boolean[] check = new boolean[N + 1];
		long[] fac = new long[N + 1];
		fac[0] = 1;
		fac[1] = 1;
		
		// �� �ܰ��� ����� �� ���
		for (int i = 2; i <= N; i++) {
			fac[i] = fac[i - 1] * i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int l = Integer.parseInt(st.nextToken());
		
		if(l == 1) {
			long k = Long.parseLong(st.nextToken());
			
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {	// i �ڸ���
				for (int j = 1; j <= N; j++) {	// i �ڸ����� �� j
					if(check[j]) continue;
					
					if(fac[N - i - 1] < k) {	// k�� �ش� ����� �� ���� �ڿ� ������ j����
						k -= fac[N - i - 1];
					} else {	// k�� �ش� ����� �� ���� �ȿ� ������ j ���� �� ���� �ε���
						arr[i] = j;
						check[j] = true;
						break;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
		} else {
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long result = 0;	// result����
			for (int i = 0; i < N; i++) {	// i��°
				for (int j = 1; j < arr[i]; j++) {
					if(!check[j]) {	// ���� ������ �ʾ����� �ش��ϴ� ����� �� ����
						result += fac[N - i - 1];
					}
				}
				check[arr[i]] = true;	// �ش� ��ȣ ���
			}
			
			System.out.println(result + 1);
		}
	}
}

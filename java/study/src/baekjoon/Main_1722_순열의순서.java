package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1722_순열의순서 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		boolean[] check = new boolean[N + 1];
		long[] fac = new long[N + 1];
		fac[0] = 1;
		fac[1] = 1;
		
		// 각 단계의 경우의 수 계산
		for (int i = 2; i <= N; i++) {
			fac[i] = fac[i - 1] * i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int l = Integer.parseInt(st.nextToken());
		
		if(l == 1) {
			long k = Long.parseLong(st.nextToken());
			
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {	// i 자리수
				for (int j = 1; j <= N; j++) {	// i 자리수에 들어갈 j
					if(check[j]) continue;
					
					if(fac[N - i - 1] < k) {	// k가 해당 경우의 수 보다 뒤에 있으면 j증가
						k -= fac[N - i - 1];
					} else {	// k가 해당 경우의 수 범위 안에 있으면 j 저장 후 다음 인덱스
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
			
			long result = 0;	// result번쨰
			for (int i = 0; i < N; i++) {	// i번째
				for (int j = 1; j < arr[i]; j++) {
					if(!check[j]) {	// 아직 사용되지 않았으면 해당하는 경우의 수 저장
						result += fac[N - i - 1];
					}
				}
				check[arr[i]] = true;	// 해당 번호 사용
			}
			
			System.out.println(result + 1);
		}
	}
}

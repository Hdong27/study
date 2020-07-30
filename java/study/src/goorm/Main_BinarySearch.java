package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BinarySearch {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int find = Integer.parseInt(br.readLine());
		
		int result = -1;
		
		int left = 0;
		int right = N - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] == find) {
				result = mid;
				break;
			} else if(arr[mid] > find) {
				right = mid - 1;
			} else {	// arr[mid] < find
				left = mid + 1;
			}
		}
		
		System.out.println(result == -1 ? "X" : result + 1);
	}
}

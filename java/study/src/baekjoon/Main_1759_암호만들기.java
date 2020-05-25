package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static int L, C;
	static char[] save, arr;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		save = new char[L];
		check = new boolean[C];
		dfs(0, 0, 0, 0);
	}
	
	// 모음 : a, e, i, o, u
	public static void dfs(int count, int index, int a, int b) {	// a : 자음 갯수, b : 모음 갯수
		if(count == L) {
			if(a >= 2 && b >= 1) {
				String result = "";
				for (int i = 0; i < save.length; i++) {
					result += save[i];
				}
				System.out.println(result);
			}
			return;
		}
		
		for (int i = index; i < C; i++) {
			if(!check[i]) {
				check[i] = true;
				save[count] = arr[i];
				if(function(arr[i])) {
					dfs(count + 1, i + 1, a, b + 1);
				} else {
					dfs(count + 1, i + 1, a + 1, b);
				}
				check[i] = false;
			}
		}
	}
	
	public static boolean function(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		}
		return false;
	}
}

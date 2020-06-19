package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19235_모노미노도미노 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		Block[][] blue = new Block[4][6];
		Block[][] green = new Block[6][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				blue[i][j] = new Block();
				green[j][i] = new Block();
			}
		}
		
		int score = 0;	// 최종 점수
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 1. 들어온 블록을 파랑과 초록에 각각 쌓는다.
			int index = 0;
			switch(num) {
			case 1:
				// blue
				// x 고정, y 이동 (0 ~ 6)
				index = 0;
				while(index < 6) {
					if(blue[x][index].num > 0) {
						index--;
						blue[x][index].num = 1;
						blue[x][index].part = 'x';
						break;
					}
					index++;
				}
				
				if(index >= 6) {
					// 맨 끝에 붙인다.
					blue[x][5].num = 1;
					blue[x][5].part = 'x';
				}
				
				// green
				// y 고정, x 이동(0 ~ 6)
				index = 0;
				while(index < 6) {
					if(green[index][y].num > 0) {
						index--;
						green[index][y].num = 1;
						green[index][y].part = 'x';
						break;
					}
					index++;
				}
				
				if(index >= 6) {
					// 맨 끝에 붙인다.
					green[5][y].num = 1;
					green[5][y].part = 'x';
				}
				
				break;
			case 2:	// 1 x 2
				index = 0;
				while(index < 6) {
					if(blue[x][index].num > 0) {
						index--;
						blue[x][index].num = 2;
						blue[x][index].part = 'r';
						index--;
						blue[x][index].num = 2;
						blue[x][index].part = 'l';
						break;
					}
					index++;
				}
				
				if(index >= 6) {
					blue[x][5].num = 2;
					blue[x][5].part = 'r';
					blue[x][4].num = 2;
					blue[x][4].part = 'l';
				}
				
				index = 0;
				while(index < 6) {
					if(green[index][y].num > 0 || green[index][y + 1].num > 0) {
						index--;
						green[index][y].num = 2;
						green[index][y].part = 'l';
						green[index][y + 1].num = 2;
						green[index][y + 1].part = 'r';
						break;
					}
					index++;
				}
				
				if(index >= 6) {
					green[5][y].num = 2;
					green[5][y].part = 'l';
					green[5][y + 1].num = 2;
					green[5][y + 1].part = 'r';
				}
				
				break;
			case 3:
				index = 0;
				while(index < 6) {
					if(blue[x][index].num > 0 || blue[x + 1][index].num > 0) {
						index--;
						blue[x][index].num = 3;
						blue[x][index].part = 'u';
						blue[x + 1][index].num = 3;
						blue[x + 1][index].part = 'd';
						break;
					}
					index++;
				}
				
				if(index >= 6) {
					blue[x][5].num = 3;
					blue[x][5].part = 'u';
					blue[x + 1][5].num = 3;
					blue[x + 1][5].part = 'd';
				}
				
				index = 0;
				while(index < 6) {
					if(green[index][y].num > 0) {
						index--;
						green[index][y].num = 3;
						green[index][y].part = 'd';
						index--;
						green[index][y].num = 3;
						green[index][y].part = 'u';
						break;
					}
					index++;
				}
				
				if(index >= 6) {
					green[4][y].num = 3;
					green[4][y].part = 'u';
					green[5][y].num = 3;
					green[5][y].part = 'd';
				}
				break;
			}
			// 여기까지 블록 쌓는 거 완료
			
			
			
			// 2. 반복
			// 2-1. 블록을 줄 단위로 없앤다.
			
			// 줄이 모두 깨졌는지 확인할 변수
			boolean blueFlag = true;
			boolean greenFlag = true;
			
			while(blueFlag || greenFlag) {
				blueFlag = false;
				greenFlag = false;
				
				// 파랑 줄 삭제
				for (int y2 = 2; y2 < 6; y2++) {
					boolean line = true;
					for (int x2 = 0; x2 < 4; x2++) {
						if(blue[x2][y2].num == 0) {
							line = false;
							break;
						}
					}
					
					if(line) {	// 한줄이 모두 채워져 있으면
						blueFlag = true;
						score++;	// 1점 추가
						for (int x2 = 0; x2 < 4; x2++) {
							if(blue[x2][y2].num == 2) {	// 1 x 2 lr
								if(blue[x2][y2].part == 'l') {	// 왼쪽이면 오른쪽을 1 x 1로 만든다.
									blue[x2][y2 + 1].num = 1;
									blue[x2][y2 + 1].part = 'x';
								} else {	// 오른쪽이면 왼쪽을 1 x 1로 만든다.
									blue[x2][y2 - 1].num = 1;
									blue[x2][y2 - 1].part = 'x';
								}
							}
							blue[x2][y2].num = 0;
							blue[x2][y2].part = 'x';
						}
					}
				}
				
				// 초록 줄 삭제
				for (int x2 = 2; x2 < 6; x2++) {
					boolean line = true;
					for (int y2 = 0; y2 < 4; y2++) {
						if(green[x2][y2].num == 0) {
							line = false;
							break;
						}
					}
					
					if(line) {
						greenFlag = true;
						score++;
						for (int y2 = 0; y2 < 4; y2++) {
							if(green[x2][y2].num == 3) { // 2 x 1 ud
								if(green[x2][y2].part == 'u') {	// 아래쪽을 1 x 1로 만든다.
									green[x2 + 1][y2].num = 1;
									green[x2 + 1][y2].part = 'x';
								} else {	// 위쪽을 1 x 1로 만든다.
									green[x2 - 1][y2].num = 1;
									green[x2 - 1][y2].part = 'x';
								}
							}
							green[x2][y2].num = 0;
							green[x2][y2].part = 'x';
						}
					}
				}
				
				// 2-2. 남아있는 블록을 아래로 내린다. (2개 짜리 블록 내릴 때 조심)
				if(blueFlag) {	// 파란색에서 삭제한게 있다면
					// 왼쪽에서 오른쪽으로 블록을 옮긴다.
					// 2 x 1을 조심해서 내린다. num == 3
					for (int y2 = 4; y2 >= 0; y2--) {
						for (int x2 = 0; x2 < 4; x2++) {
							if(blue[x2][y2].num == 1) {	// 아래로 내린다.
								int yIndex = 5;
								for (int y3 = y2 + 1; y3 < 6; y3++) {
									if(blue[x2][y3].num > 0) {
										// 그 전의 친구한테 넣는다.
										yIndex = y3 - 1;
										break;
									}
								}
								blue[x2][y2].num = 0;
								blue[x2][y2].part = 'x';
								
								blue[x2][yIndex].num = 1;
								blue[x2][yIndex].part = 'x';
							} else if(blue[x2][y2].num == 2 && blue[x2][y2].part == 'r') {	// 왼쪽에 있는 블럭도 같이 아래로 내린다.
								int yIndex = 5;
								for (int y3 = y2 + 1; y3 < 6; y3++) {
									if(blue[x2][y3].num > 0) {
										yIndex = y3 - 1;
										break;
									}
								}
								blue[x2][y2].num = 0;
								blue[x2][y2].part = 'x';
								blue[x2][y2 - 1].num = 0;
								blue[x2][y2 - 1].part = 'x';
								
								blue[x2][yIndex].num = 2;
								blue[x2][yIndex].part = 'r';
								blue[x2][yIndex - 1].num = 2;
								blue[x2][yIndex - 1].part = 'l';
							} else if(blue[x2][y2].num == 3 && blue[x2][y2].part == 'u') {
								int yIndex = 5;
								for (int y3 = y2 + 1; y3 < 6; y3++) {
									if(blue[x2][y3].num > 0 || blue[x2 + 1][y3].num > 0) {
										yIndex = y3 - 1;
										break;
									}
								}
								blue[x2][y2].num = 0;
								blue[x2][y2].part = 'x';
								blue[x2 + 1][y2].num = 0;
								blue[x2 + 1][y2].part = 'x';
								
								blue[x2][yIndex].num = 3;
								blue[x2][yIndex].part = 'u';
								blue[x2 + 1][yIndex].num = 3;
								blue[x2 + 1][yIndex].part = 'd';
							}
						}
					}
				}
				
				if(greenFlag) {	// 초록색에서 삭제한게 있다면
					// 위에서 아래로 블록을 옮긴다.
					// 1 x 2를 조심해서 내린다. num == 2
					for (int x2 = 4; x2 >= 0; x2--) {
						for (int y2 = 0; y2 < 4; y2++) {
							if(green[x2][y2].num == 1) {
								int xIndex = 5;
								for (int x3 = x2 + 1; x3 < 6; x3++) {
									if(green[x3][y2].num > 0) {
										xIndex = x3 - 1;
										break;
									}
								}
								green[x2][y2].num = 0;
								green[x2][y2].part = 'x';
								
								green[xIndex][y2].num = 1;
								green[xIndex][y2].part = 'x';
							} else if(green[x2][y2].num == 2 && green[x2][y2].part == 'l') {
								int xIndex = 5;
								for (int x3 = x2 + 1; x3 < 6; x3++) {
									if(green[x3][y2].num > 0 || green[x3][y2 + 1].num > 0) {
										xIndex = x3 - 1;
										break;
									}
								}
								green[x2][y2].num = 0;
								green[x2][y2].part = 'x';
								green[x2][y2 + 1].num = 0;
								green[x2][y2 + 1].part = 'x';
								
								green[xIndex][y2].num = 2;
								green[xIndex][y2].part = 'l';
								green[xIndex][y2 + 1].num = 2;
								green[xIndex][y2 + 1].part = 'r';
							} else if(green[x2][y2].num == 3 && green[x2][y2].part == 'd') {
								int xIndex = 5;
								for (int x3 = x2 + 1; x3 < 6; x3++) {
									if(green[x3][y2].num > 0) {
										xIndex = x3 - 1;
										break;
									}
								}
								green[x2][y2].num = 0;
								green[x2][y2].part = 'x';
								green[x2 - 1][y2].num = 0;
								green[x2 - 1][y2].part = 'x';
								
								green[xIndex][y2].num = 3;
								green[xIndex][y2].part = 'd';
								green[xIndex - 1][y2].num = 3;
								green[xIndex - 1][y2].part = 'u';
							}
							
						}
						
					}
				}
				
			}
			
			// 3. 0이나 1번 자리에 블록이 남아있을 경우 아래를 없애고 내린다.
			// 파란색에 0, 1
			boolean flag = false;
			for (int x2 = 0; x2 < 4; x2++) {
				if(blue[x2][0].num > 0) {
					flag = true;
					break;
				}
			}
			
			if(flag) {
				// 2칸 없애기
				for (int x2 = 0; x2 < 4; x2++) {
					for (int y2 = 5; y2 >= 2; y2--) {
						blue[x2][y2].num = blue[x2][y2 - 2].num;
						blue[x2][y2].part = blue[x2][y2 - 2].part;
					}
					
					for (int y2 = 0; y2 < 2; y2++) {
						blue[x2][y2].num = 0;
						blue[x2][y2].part = 'x';
					}
					
					if(blue[x2][5].num == 2 && blue[x2][5].part == 'l') {
						blue[x2][5].num = 1;
						blue[x2][5].part = 'x';
					}
				}
			} else {
				for (int x2 = 0; x2 < 4; x2++) {
					if(blue[x2][1].num > 0) {
						flag = true;
						break;
					}
				}
				
				if(flag) {
					// 1칸 없애기
					for (int x2 = 0; x2 < 4; x2++) {
						for (int y2 = 5; y2 >= 2; y2--) {
							blue[x2][y2].num = blue[x2][y2 - 1].num;
							blue[x2][y2].part = blue[x2][y2 - 1].part;
						}
						
						for (int y2 = 1; y2 < 2; y2++) {
							blue[x2][y2].num = 0;
							blue[x2][y2].part = 'x';
						}
						
						if(blue[x2][5].num == 2 && blue[x2][5].part == 'l') {
							blue[x2][5].num = 1;
							blue[x2][5].part = 'x';
						}
					}
				}
			}
			
			// 초록색에 0, 1
			flag = false;
			for (int y2 = 0; y2 < 4; y2++) {
				if(green[0][y2].num > 0) {
					flag = true;
					break;
				}
			}
			
			if(flag) {
				for (int y2 = 0; y2 < 4; y2++) {
					for (int x2 = 5; x2 >= 2; x2--) {
						green[x2][y2].num = green[x2 - 2][y2].num;
						green[x2][y2].part = green[x2 - 2][y2].part;
					}
					
					for (int x2 = 0; x2 < 2; x2++) {
						green[x2][y2].num = 0;
						green[x2][y2].part = 'x';
					}
					
					if(green[5][y2].num == 3 && green[5][y2].part == 'u') {
						green[5][y2].num = 1;
						green[5][y2].part = 'x';
					}
				}
			} else {
				for (int y2 = 0; y2 < 4; y2++) {
					if(green[1][y2].num > 0) {
						flag = true;
						break;
					}
				}
				
				if(flag) {
					for (int y2 = 0; y2 < 4; y2++) {
						for (int x2 = 5; x2 >= 2; x2--) {
							green[x2][y2].num = green[x2 - 1][y2].num;
							green[x2][y2].part = green[x2 - 1][y2].part;
						}
						
						for (int x2 = 1; x2 < 2; x2++) {
							green[x2][y2].num = 0;
							green[x2][y2].part = 'x';
						}
						
						if(green[5][y2].num == 3 && green[5][y2].part == 'u') {
							green[5][y2].num = 1;
							green[5][y2].part = 'x';
						}
					}
				}
			}
			
			
//			for (int j = 0; j < 4; j++) {
//				for (int k = 0; k < 6; k++) {
//					System.out.print(blue[j][k].num + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
//			for (int j = 0; j < 6; j++) {
//				for (int k = 0; k < 4; k++) {	
//					System.out.print(green[j][k].num + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
		}
		
		
		
		System.out.println(score);
		
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				if(blue[i][j].num > 0) {
					count++;
				}
				if(green[j][i].num > 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	static class Block {
		int num;	// 1 x 1 : 1, 1 x 2 : 2, 2 x 1 : 3
		char part;	// 1 x 1 : (x), 1 x 2 : (l, r), 2 x 1 : (u, d)
		
		// 초기화
		public Block() {
			this.num = 0;
			this.part = 'x';
		}
		
		// 1 x 1
		public Block(int num) {
			this.num = num;
			this.part = 'x';
		}
		
		// 1 x 2, 2 x 1
		public Block(int num, char part) {
			this.num = num;
			this.part = part;
		}
	}
}

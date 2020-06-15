package study;

public class Stack {
	int[] arr;
	int top;
	
	// 초기화
	public Stack() {
		this.top = -1;
		this.arr = new int[100];
	}
	
	// 삽입
	public void push(int n) {
		arr[++this.top] = n;
	}
	
	// 삭제
	public int pop() {
		if(top > -1) {
			return arr[this.top--];
		} else {
			return -1;
		}
	}
	
	// 검색
	public int peek() {
		if(top > -1) {
			return arr[this.top];
		} else {
			return -1;
		}
	}
	
	// 현재 길이
	public int getLength() {
		return this.top + 1;
	}
	
	// 비어있는지
	public boolean isEmpty() {
		return this.top == -1 ? true : false;
	}
	
	// 가득차있는지
	public boolean isFull() {
		return this.top == 99 ? true : false;
	}
}

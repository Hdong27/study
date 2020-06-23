package study;

public class Stack {
	int[] arr;
	int top;
	
	// �ʱ�ȭ
	public Stack() {
		this.top = -1;
		this.arr = new int[100];
	}
	
	// ����
	public void push(int n) {
		arr[++this.top] = n;
	}
	
	// ����
	public int pop() {
		if(top > -1) {
			return arr[this.top--];
		} else {
			return -1;
		}
	}
	
	// �˻�
	public int peek() {
		if(top > -1) {
			return arr[this.top];
		} else {
			return -1;
		}
	}
	
	// ���� ����
	public int getLength() {
		return this.top + 1;
	}
	
	// ����ִ���
	public boolean isEmpty() {
		return this.top == -1 ? true : false;
	}
	
	// �������ִ���
	public boolean isFull() {
		return this.top == 99 ? true : false;
	}
}

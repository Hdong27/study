package study;

public class Queue {
	int[] arr;
	int front;
	int rear;
	
	public Queue() {
		this.arr = new int[100];
		this.front = -1;
		this.rear = -1;
	}
	
	public void add(int n) {
		this.arr[++this.rear] = n;
	}
	
	public int peek() {
		if(rear > front) {
			return this.arr[this.front + 1];
		} else {
			return -1;
		}
	}
	
	public int pull() {
		if(rear > front) {
			return this.arr[++this.front];
		} else {
			return -1;
		}
	}
	
	public int getLength() {
		return rear - front;
	}
}

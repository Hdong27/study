package study;

public class test {
	public static void main(String[] args) {
		/**
		 * stack �׽�Ʈ
		 */
		
		/*
		Stack st = new Stack();
		
		System.out.println("����ִ°� : " + st.isEmpty());

		st.push(1);
		st.push(2);
		st.push(3);
		st.push(2);
		st.push(1);

		System.out.println("���� ������ ���� : " + st.getLength());
		System.out.println("���� �� �˻� : " + st.peek());
		System.out.println("���� �� �˻� �� ���� : " + st.pop());
		System.out.println("���� �� �˻� �� ���� : " + st.pop());
		System.out.println("���� �� �˻� : " + st.peek());
		
		System.out.println("����ִ°� : " + st.isEmpty());

		Stack st2 = new Stack();
		
		for (int i = 1; i <= 100; i++) {
			st2.push(i);
		}
		
		System.out.println("����á�°� : " + st2.isFull());
		
		for (int i = 0; i < 100; i++) {
			System.out.println(st2.pop());
		}
		*/
		
		Queue q = new Queue();
		
		System.out.println(q.pull());
		
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		System.out.println(q.getLength());
		System.out.println(q.peek());
		System.out.println(q.pull());
		System.out.println(q.pull());
		System.out.println(q.pull());
		System.out.println(q.pull());
	}
}
